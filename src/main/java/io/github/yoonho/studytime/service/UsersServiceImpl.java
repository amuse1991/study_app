package io.github.yoonho.studytime.service;

import io.github.yoonho.studytime.domain.users.Users;
import io.github.yoonho.studytime.domain.users.UsersRepository;
import io.github.yoonho.studytime.dto.users.SignUpRequestDto;
import io.github.yoonho.studytime.dto.users.UserInfoResponseDto;
import io.github.yoonho.studytime.exceptions.IdAlreadyExistingException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UsersServiceImpl implements UsersService {

    private UsersRepository usersRepository;

    @Override
    public String signUp(SignUpRequestDto form) {
        Users newUser = form.toEntity();

        //아이디 중복 체크
        if(usersRepository.existsByUserId(newUser.getUser_id())){
            throw new IdAlreadyExistingException();
        }

        usersRepository.save(newUser);
        return newUser.getUser_id();
    }
}
