package io.github.yoonho.studytime.service.users;

import io.github.yoonho.studytime.dto.users.UserAuthDto;
import io.github.yoonho.studytime.dto.users.UserInfoResDto;
import io.github.yoonho.studytime.dto.users.UserInsertReqDto;
import io.github.yoonho.studytime.utils.AuthorityName;

import java.util.List;

public interface UsersService {

    String signUp(UserInsertReqDto form);

    List<UserInfoResDto> getAllUsers();
    UserInfoResDto getUserByUserId(String userId);

    UserInfoResDto updateUser(String userId, UserInsertReqDto form);
    UserInfoResDto updateUserPoint(String userId, int value);
    UserAuthDto updateUserAuth(String userId, AuthorityName auth);

    boolean destroyUser(String id);

}
