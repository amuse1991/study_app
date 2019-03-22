package io.github.yoonho.studytime.service.users;

import io.github.yoonho.studytime.dto.users.UserAuthDto;
import io.github.yoonho.studytime.dto.users.UserInfoResDto;
import io.github.yoonho.studytime.dto.users.UserInsertReqDto;
import io.github.yoonho.studytime.dto.users.UserPointDto;
import io.github.yoonho.studytime.utils.types.AuthorityName;

import java.util.List;

public interface UsersService {

    String createUser(UserInsertReqDto form);

    List<UserInfoResDto> getAllUsers();
    UserInfoResDto getUserByUserId(String userId);

    UserInfoResDto updateUser(String userId, UserInsertReqDto form);
    UserAuthDto updateUserAuth(String userId, AuthorityName auth);
    UserPointDto increasePoint(String userId, int value);
    UserPointDto decreasePoint(String userId, int value);

    boolean destroyUser(String id);

}
