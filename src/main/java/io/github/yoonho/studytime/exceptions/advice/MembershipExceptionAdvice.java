package io.github.yoonho.studytime.exceptions.advice;

import io.github.yoonho.studytime.exceptions.membership.MemberAuthNotFoundException;
import io.github.yoonho.studytime.exceptions.users.IdAlreadyExistingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class MembershipExceptionAdvice {
    @ResponseBody
    @ExceptionHandler(MemberAuthNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String MemberAuthNotFoundHandler(MemberAuthNotFoundException ex){
        log.error(ex.getClass()+" : "+ex.getMessage());
        return ex.getMessage();
    }
}
