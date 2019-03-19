package io.github.yoonho.studytime.dao;

import io.github.yoonho.studytime.domain.users.Users;
import io.github.yoonho.studytime.domain.users.UsersRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.CoreMatchers.is;

import java.util.List;

import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsersDaoTest {

    @Autowired
    UsersRepository usersRepository;

    @After
    public void cleanup(){
        if(usersRepository != null) {
            usersRepository.deleteAll();
        }
    }

    @Test
    public void 회원정보_저장_불러오기(){
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

        //when
        List<Users> usersList = usersRepository.findAll();

        //then
        Users users = usersList.get(0);
        assertThat(users.getUser_id(), is("estrella917@naver.com"));
    }
}
