package io.github.yoonho.studytime.service;

import io.github.yoonho.studytime.domain.users.Users;
import io.github.yoonho.studytime.domain.users.UsersRepository;
import io.github.yoonho.studytime.dto.users.SignUpRequestDto;
import io.github.yoonho.studytime.dto.users.UserInfoResponseDto;
import io.github.yoonho.studytime.exceptions.IdAlreadyExistingException;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest{

    @Autowired
    private UsersRepository usersRepository;

    @After
    public void cleanup(){
        if(usersRepository != null) {
            usersRepository.deleteAll();
        }
    }

    @Test(expected = IdAlreadyExistingException.class)
    public void signUp함수는_id가_중복되면_IdAlreadyExistingException을_반환한다(){
        //given
        usersRepository.save(Users.builder()
                .user_id("estrella917@naver.com")
                .password("111")
                .nickname("테스터")
                .phone("010-1111-2222")
                .point(0)
                .authority("user")
                .build()
        );
        //request로 들어온 회원 정보
        Users user = Users.builder()
                .user_id("estrella917@naver.com") //중복
                .password("222")
                .nickname("테스터2")
                .phone("010-1111-3333")
                .point(0)
                .authority("user")
                .build();

        //아이디 중복 체크
        if(usersRepository.existsByUserId(user.getUser_id())){
            throw new IdAlreadyExistingException();
        }
    }
}
