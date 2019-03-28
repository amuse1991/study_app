package io.github.yoonho.studytime.exceptions.membership;

public class MemberAuthNotFoundException extends RuntimeException {
    public MemberAuthNotFoundException(String authName){
        super("Could not find membership authority name \""+authName+"\"");
    }
    public MemberAuthNotFoundException(Long authId){
        super("Could not find membership authority id \""+authId+"\"");
    }
}
