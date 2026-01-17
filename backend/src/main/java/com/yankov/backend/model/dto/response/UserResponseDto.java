package com.yankov.backend.model.dto.response;

import com.yankov.backend.enums.Role;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class UserResponseDto {

    private Long id;

    private String fullName;

    private String email;

    private Role role;

    private LocalDateTime createdAt;
}
