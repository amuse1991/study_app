package io.github.yoonho.studytime.dao;

import io.github.yoonho.studytime.domain.users.Users;
import io.github.yoonho.studytime.domain.users.UsersRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.CoreMatchers.is;

import java.util.List;

import static org.junit.Assert.assertNull;
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
                .userId("estrella917@naver.com")
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
        assertThat(users.getUserId(), is("estrella917@naver.com"));
    }


    @Test
    public void 회원정보_삭제(){
        //given
        usersRepository.save(Users.builder()
                .userId("estrella917@naver.com")
                .password("111")
                .nickname("테스터")
                .phone("010-1111-2222")
                .point(0)
                .authority("user")
                .build()
        );
        String id = "estrlla917@naver.com";

        //when
        usersRepository.deleteUsersByUserId(id);

        //then
        Users user = usersRepository.findUsersByUserId(id);
        assertNull(user);
    }

    @Test
    public void id_중복검사(){
        //given
        usersRepository.save(Users.builder()
                .userId("estrella917@naver.com")
                .password("111")
                .nickname("테스터")
                .phone("010-1111-2222")
                .point(0)
                .authority("user")
                .build()
        );

        Users user = Users.builder()
                .userId("estrella917@naver.com")
                .password("222")
                .nickname("테스터2")
                .phone("010-1111-3333")
                .point(0)
                .authority("user")
                .build();

        //when
        boolean res = usersRepository.existsByUserId(user.getUserId());
        assertThat(res,is(true));
    }
}
