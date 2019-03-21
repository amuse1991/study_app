package io.github.yoonho.studytime.exceptions.users;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IdAlreadyExistingException extends RuntimeException {
    public IdAlreadyExistingException(String userId){
        super("user id \""+userId+"\" is already exist");
    }
}
