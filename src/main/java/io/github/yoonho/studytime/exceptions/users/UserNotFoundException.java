package io.github.yoonho.studytime.exceptions.users;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String userId){
        super("Could not find user \""+userId+"\"");
    }
}

