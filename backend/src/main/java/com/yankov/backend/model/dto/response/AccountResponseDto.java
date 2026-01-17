package com.yankov.backend.model.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AccountResponseDto {

    private Long id;

    private String accountNumber;

    private BigDecimal balance;

    private Long userId;

    private LocalDateTime createdAt;
}
