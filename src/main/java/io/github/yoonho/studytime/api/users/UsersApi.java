package io.github.yoonho.studytime.api.users;

import io.github.yoonho.studytime.dto.users.UserAuthDto;
import io.github.yoonho.studytime.dto.users.UserInfoResDto;
import io.github.yoonho.studytime.dto.users.UserInsertReqDto;
import io.github.yoonho.studytime.service.users.UsersServiceImpl;
import io.github.yoonho.studytime.utils.types.AuthorityName;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor // bean을 생성자 주입 해주는 롬복 어노테이션(autowired 보다 생성자 주입이 더 권장됨)
@Slf4j
public class UsersApi {

    //@AllArgsConstructor에 의해 생성자 주입되므로 @Autowired안붙인다.
    private UsersServiceImpl usersService;

    //root

    @PostMapping("/users") //유저 생성
    public String signUp(@RequestBody UserInsertReqDto form){
        return usersService.signUp(form);
    }

    @GetMapping("/users") //모든 유저 조회
    public List<UserInfoResDto> getAllUsers(){
        return usersService.getAllUsers();
    }

    // single item

    @GetMapping("/users/{userId}") //userId 값과 일치하는 유저 조회
    public UserInfoResDto getUserByUserId(@PathVariable String userId){
        return usersService.getUserByUserId(userId);
    }

    @PutMapping("/users/{userId}") //유저 정보 수정
    public UserInfoResDto updateUser(@PathVariable String userId,
                                     @RequestBody UserInsertReqDto form){
        return usersService.updateUser(userId,form);
    }

    @PutMapping("/users/{userId}/point") //유저에게 포인트 추가
    public UserInfoResDto updateUserPoint(@PathVariable String userId,
                                   @RequestParam(value = "value") int value){
        return usersService.increasePoint(userId,value);
    }

    @PutMapping("/users/{userId}/authority") //유저가 가진 권한 수정
    public UserAuthDto updateUserAuth(@PathVariable String userId,
                                      @RequestParam(value = "auth") AuthorityName auth){
        return usersService.updateUserAuth(userId, auth);
    }

    @DeleteMapping("/users/{userId}") //유저 삭제
    public boolean destroyUser(@PathVariable String userId){
        return usersService.destroyUser(userId);
    }
}
