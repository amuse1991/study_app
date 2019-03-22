package io.github.yoonho.studytime.service.users;

import io.github.yoonho.studytime.dto.users.UserAuthDto;
import io.github.yoonho.studytime.dto.users.UserInfoResDto;
import io.github.yoonho.studytime.dto.users.UserInsertReqDto;
import io.github.yoonho.studytime.utils.types.AuthorityName;

import java.util.List;

public interface UsersService {

    String signUp(UserInsertReqDto form);

    List<UserInfoResDto> getAllUsers();
    UserInfoResDto getUserByUserId(String userId);

    UserInfoResDto updateUser(String userId, UserInsertReqDto form);
    UserAuthDto updateUserAuth(String userId, AuthorityName auth);
    UserInfoResDto increasePoint(String userId, int value);
    UserInfoResDto decreasePoint(String userId, int value);

    boolean destroyUser(String id);

}
