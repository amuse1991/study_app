package io.github.yoonho.studytime.api.users;

import io.github.yoonho.studytime.dto.users.UserInfoRequestDto;
import io.github.yoonho.studytime.dto.users.UserInfoResponseDto;
import io.github.yoonho.studytime.service.users.UsersServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor // bean을 생성자 주입 해주는 롬복 어노테이션(autowired 보다 생성자 주입이 더 권장됨)
@Slf4j
public class UsersApi {

    //private UsersRepository usersRepository; //@AllArgsConstructor에 의해 생성자 주입되므로 @Autowired안붙인다.
    private UsersServiceImpl usersService;

    @PostMapping("/users")
    public String signUp(@RequestBody UserInfoRequestDto form){
        return usersService.signUp(form);
    }

    @PutMapping("/users")
    public UserInfoResponseDto updateUser(@RequestBody UserInfoRequestDto form){
        return usersService.updateUser(form);
    }

    @DeleteMapping("/users/{userId}")
    public boolean destroyUser(@PathVariable String userId){
        return usersService.destroyUser(userId);
    }
}
