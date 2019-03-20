package io.github.yoonho.studytime.api;

import io.github.yoonho.studytime.dto.users.SignUpRequestDto;
import io.github.yoonho.studytime.service.UsersServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor // bean을 생성자 주입 해주는 롬복 어노테이션(autowired 보다 생성자 주입이 더 권장됨)
@Slf4j
public class UsersApi {

    //private UsersRepository usersRepository; //@AllArgsConstructor에 의해 생성자 주입되므로 @Autowired안붙인다.
    private UsersServiceImpl usersService;

    @PostMapping("/users")
    public String signUp(@RequestBody SignUpRequestDto form){
        return usersService.signUp(form);
    }
}
