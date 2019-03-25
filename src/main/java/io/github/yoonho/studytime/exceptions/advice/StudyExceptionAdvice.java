package io.github.yoonho.studytime.exceptions.advice;

import io.github.yoonho.studytime.exceptions.study.StudyNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class StudyExceptionAdvice {
    @ResponseBody
    @ExceptionHandler(StudyNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String studyNotFoundHandler(StudyNotFoundException ex){
        log.error(ex.getClass()+" : "+ex.getMessage());
        return ex.getMessage();
    }

}
