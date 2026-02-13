package com.yankov.backend.util;

import com.yankov.backend.model.dto.request.TransactionRequestDto;
import com.yankov.backend.model.dto.request.TransferRequestDto;

import java.math.BigDecimal;

public final class TestRequestFactory {

    private TestRequestFactory() {
    }

    private static final String ACCOUNT_NUMBER = "ACC123456";
    private static final String TARGET_ACCOUNT_NUMBER = "ACC654321";

    public static TransactionRequestDto depositRequest() {

        return TransactionRequestDto.builder()
                .accountNumber(ACCOUNT_NUMBER)
                .amount(BigDecimal.TEN)
                .build();
    }

    public static TransactionRequestDto withdrawRequest() {

        return TransactionRequestDto.builder()
                .accountNumber(ACCOUNT_NUMBER)
                .amount(BigDecimal.TEN)
                .build();
    }

    public static TransferRequestDto transferRequest() {

        return TransferRequestDto.builder()
                .sourceAccountNumber(ACCOUNT_NUMBER)
                .targetAccountNumber(TARGET_ACCOUNT_NUMBER)
                .build();

    }
}
