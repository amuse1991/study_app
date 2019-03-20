package io.github.yoonho.studytime.service;

import io.github.yoonho.studytime.dto.users.SignUpRequestDto;
import io.github.yoonho.studytime.dto.users.UserInfoResponseDto;

public interface UsersService {
    String signUp(SignUpRequestDto form);
}
