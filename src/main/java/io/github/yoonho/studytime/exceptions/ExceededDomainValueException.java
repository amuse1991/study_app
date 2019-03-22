package io.github.yoonho.studytime.exceptions;

public class ExceededDomainValueException extends RuntimeException {
    public ExceededDomainValueException(String value, String maxLimit){
        super("value \""+value+"\" exceeded domain max limit "+maxLimit);
    }
}
