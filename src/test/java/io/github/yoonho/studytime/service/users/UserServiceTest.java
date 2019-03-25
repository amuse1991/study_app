package io.github.yoonho.studytime.service.users;

import io.github.yoonho.studytime.domain.users.Users;
import io.github.yoonho.studytime.domain.users.UsersRepository;
import io.github.yoonho.studytime.exceptions.users.IdAlreadyExistingException;
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
}
