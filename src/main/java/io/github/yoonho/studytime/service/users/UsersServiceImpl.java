package io.github.yoonho.studytime.service.users;

import io.github.yoonho.studytime.domain.users.Users;
import io.github.yoonho.studytime.domain.users.UsersRepository;
import io.github.yoonho.studytime.dto.users.UserAuthDto;
import io.github.yoonho.studytime.dto.users.UserInfoResDto;
import io.github.yoonho.studytime.dto.users.UserInsertReqDto;

import io.github.yoonho.studytime.exceptions.users.IdAlreadyExistingException;
import io.github.yoonho.studytime.exceptions.users.UserNotFoundException;
import io.github.yoonho.studytime.utils.types.AuthorityName;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
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
        String userId = form.getUserId();
        //아이디 중복 체크
        if(usersRepository.existsByUserId(userId)){
            throw new IdAlreadyExistingException(userId);
        }

        //새 유저 생성
        Users newUser = Users.builder()
                .userId(userId)
                .password(form.getPassword())
                .nickname(form.getNickname())
                .phone(form.getPhone())
                .point(form.getPoint())
                .authority(form.getAuthority())
                .build();

        usersRepository.save(newUser);
        return newUser.getUserId();
    }

    @Override
    public List<UserInfoResDto> getAllUsers() {
        //TODO:구현
        /*
        모든 유저를 반환할 필요 있음??
        유저 검색 기능으로 바꾸는게 좋을듯
         */
        return null;
    }

    @Override
    public UserInfoResDto getUserByUserId(String userId) {
        Users exampleUser = Users.builder().userId(userId).build(); //query by example
        Users user = usersRepository.findOne(Example.of(exampleUser))
                .orElseThrow(()->new UserNotFoundException(userId)); //user id에 해당하는 유저가 존재하지 않을 경우

        UserInfoResDto result = new UserInfoResDto();
        result.setUserId(user.getUserId());
        result.setNickname(user.getNickname());
        result.setPhone(user.getPhone());
        result.setPoint(user.getPoint());
        result.setAuthority(user.getAuthority());

        return result;
    }

    @Override
    public UserInfoResDto updateUser(String userId, UserInsertReqDto form) {
        //TODO : 권한 확인

        //유저가 존재하는지 확인
        if(!usersRepository.existsByUserId(userId)){
            throw new UserNotFoundException(userId);
        }

        // 변경사항 object에 적용
        Users user = usersRepository.findUsersByUserId(userId); // db에서 객체 가져오기
        user.updatePassword(form.getPassword());
        user.updateNickname(form.getNickname());
        user.updateAuthority(form.getAuthority());
        user.updatePhone(form.getPhone());
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
    public UserAuthDto updateUserAuth(String userId, AuthorityName auth) {
        
        return null;
    }


    @Override
    public UserInfoResDto increasePoint(String userId, int value) {
        Users user = usersRepository.findUsersByUserId(userId);
        user.increasePoint(value);
        usersRepository.save(user);
        return null;
    }

    @Override
    public UserInfoResDto decreasePoint(String userId, int value) {
        Users user = usersRepository.findUsersByUserId(userId);
        user.decreasePoint(value);
        usersRepository.save(user);
        return null;
    }


    @Override
    public boolean destroyUser(String id) {
        // TODO : 권한 확인

        // 유저가 존재하는지 확인
        if(!usersRepository.existsByUserId(id)){
            throw new UserNotFoundException(id);
        }
        // 유저 삭제
        usersRepository.deleteUsersByUserId(id);
        return true;
    }
}
