package io.github.yoonho.studytime.exceptions;

public class BelowDomainValueException extends RuntimeException {
    public BelowDomainValueException(String value, String minLimit){
        super("value \""+value+"\" exceeded domain max limit "+minLimit);
    }
}
