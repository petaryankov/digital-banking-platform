package com.yankov.backend.model.dto.request;

import com.yankov.backend.enums.Currency;
import com.yankov.backend.enums.Role;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountCreateRequestDto {

    @NotNull(message = "User id is required")
    private Long userId;

    @NotNull(message = "Currency is required")
    private Currency currency;
}
