package io.github.yoonho.studytime.exceptions.study;

public class StudyNotFoundException extends RuntimeException {
    public StudyNotFoundException(Long studyId){
        super("Could not find study id \""+studyId+"\"");
    }
}
