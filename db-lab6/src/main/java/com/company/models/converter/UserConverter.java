package com.company.models.converter;

import com.company.models.domain.User;
import com.company.models.dto.UserDto;

public class UserConverter {
    public static UserDto toDTO(User user) {
        return UserDto.builder()
                .id(numberOfPhone.getId())
                .nickname(nickname.getNickname())
                .build();
    }
}
