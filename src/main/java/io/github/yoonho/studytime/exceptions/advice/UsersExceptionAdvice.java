package io.github.yoonho.studytime.exceptions.advice;

import io.github.yoonho.studytime.exceptions.users.IdAlreadyExistingException;
import io.github.yoonho.studytime.exceptions.users.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class UsersExceptionAdvice {
    @ResponseBody
    @ExceptionHandler(IdAlreadyExistingException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String idAlreadyExistingHandler(IdAlreadyExistingException ex){
        log.error(ex.getClass()+" : "+ex.getMessage());
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String userNotFoundHandler(UserNotFoundException ex){
        log.error(ex.getClass()+" : "+ex.getMessage());
        return ex.getMessage();
    }
}
