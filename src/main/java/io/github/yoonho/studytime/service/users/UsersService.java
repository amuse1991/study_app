package io.github.yoonho.studytime.service.users;

import io.github.yoonho.studytime.dto.users.UserInfoRequestDto;
import io.github.yoonho.studytime.dto.users.UserInfoResponseDto;

public interface UsersService {
    String signUp(UserInfoRequestDto form);
    boolean destroyUser(String id);
    UserInfoResponseDto updateUser(UserInfoRequestDto form);
}
