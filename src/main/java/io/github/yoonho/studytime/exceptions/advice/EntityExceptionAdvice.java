package io.github.yoonho.studytime.exceptions.advice;

import io.github.yoonho.studytime.exceptions.BelowDomainValueException;
import io.github.yoonho.studytime.exceptions.ExceededDomainValueException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class EntityExceptionAdvice {
    @ResponseBody
    @ExceptionHandler(ExceededDomainValueException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String exceededDomainValueHandler(ExceededDomainValueException ex){
        log.error(ex.getClass()+" : "+ex.getMessage());
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(BelowDomainValueException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String belowDomainValueException(BelowDomainValueException ex){
        log.error(ex.getClass()+" : "+ex.getMessage());
        return ex.getMessage();
    }
}
