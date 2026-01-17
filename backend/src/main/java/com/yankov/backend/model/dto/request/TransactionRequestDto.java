package com.yankov.backend.model.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransactionRequestDto {

    @NotNull(message = "Amount is required")
    private BigDecimal amount;

    @NotNull(message = "Source account ID is required")
    private Long sourceAccountId;

    @NotNull(message = "Target account ID is required")
    private Long targetAccountId;
}
