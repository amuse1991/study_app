package io.github.yoonho.studytime.service.users;

import io.github.yoonho.studytime.domain.users.Users;
import io.github.yoonho.studytime.domain.users.UsersRepository;
import io.github.yoonho.studytime.dto.users.UserAuthDto;
import io.github.yoonho.studytime.dto.users.UserInfoResDto;
import io.github.yoonho.studytime.dto.users.UserInsertReqDto;
import io.github.yoonho.studytime.exceptions.users.IdAlreadyExistingException;
import io.github.yoonho.studytime.exceptions.users.UserNotFoundedException;
import io.github.yoonho.studytime.utils.AuthorityName;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Transactional
@Service
public class UsersServiceImpl implements UsersService {

    private UsersRepository usersRepository;

    @Override
    public String signUp(UserInsertReqDto form) {
        Users newUser = form.toEntity();
        //아이디 중복 체크
        if(usersRepository.existsByUserId(newUser.getUserId())){
            throw new IdAlreadyExistingException();
        }
        usersRepository.save(newUser);
        return newUser.getUserId();
    }

    @Override
    public List<UserInfoResDto> getAllUsers() {
        return null;
    }

    @Override
    public UserInfoResDto getUserByUserId(String userId) {
        return null;
    }

    @Override
    public UserInfoResDto updateUser(String userId, UserInsertReqDto form) {
        Users updateData = form.toEntity();
        //TODO : 권한 확인

        //유저가 존재하는지 확인
        if(!usersRepository.existsByUserId(updateData.getUserId())){
            throw new UserNotFoundedException();
        }

        String password = updateData.getPassword();
        String nickname = updateData.getNickname();
        Integer point = updateData.getPoint();
        AuthorityName auth = updateData.getAuthority();
        String phone = updateData.getPhone();

        // 변경사항 object에 적용
        Users user = usersRepository.findUsersByUserId(userId); // db에서 객체 가져오기
        user.setPassword(password);
        user.setNickname(nickname);
        user.setPoint(point);
        user.setAuthority(auth);
        user.setPhone(phone);
        // 변경사항 DB에 적용
        usersRepository.save(user);

        UserInfoResDto response = new UserInfoResDto();
        response.setUserId(user.getUserId());
        response.setNickname(user.getNickname());
        response.setAuthority(user.getAuthority());
        response.setPhone(user.getPhone());

        return response;
    }

    @Override
    public UserInfoResDto updateUserPoint(String userId, int value) {
        return null;
    }

    @Override
    public UserAuthDto updateUserAuth(String userId, AuthorityName auth) {
        return null;
    }

    @Override
    public boolean destroyUser(String id) {
        // TODO : 권한 확인

        // 유저가 존재하는지 확인
        if(!usersRepository.existsByUserId(id)){
            throw new UserNotFoundedException();
        }
        // 유저 삭제
        usersRepository.deleteUsersByUserId(id);
        return true;
    }
}
