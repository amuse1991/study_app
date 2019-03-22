package io.github.yoonho.studytime.exceptions.users;

public class IdAlreadyExistingException extends RuntimeException {
    public IdAlreadyExistingException(String userId){
        super("user id \""+userId+"\" is already exist");
    }
}
