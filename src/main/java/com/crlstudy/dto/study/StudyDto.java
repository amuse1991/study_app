package com.crlstudy.dto.study;

import java.sql.Time;
import java.util.Date;

public class StudyDto {
    private int studyId;
    private String studyName;
    private Date studyDate;
    private Time studyTime;
    private int studyPoint;

    public int getStudyId() {
        return studyId;
    }

    public void setStudyId(int studyId) {
        this.studyId = studyId;
    }

    public String getStudyName() {
        return studyName;
    }

    public void setStudyName(String studyName) {
        this.studyName = studyName;
    }

    public Date getStudyDate() {
        return studyDate;
    }

    public void setStudyDate(Date studyDate) {
        this.studyDate = studyDate;
    }

    public Time getStudyTime() {
        return studyTime;
    }

    public void setStudyTime(Time studyTime) {
        this.studyTime = studyTime;
    }

    public int getStudyPoint() {
        return studyPoint;
    }

    public void setStudyPoint(int studyPoint) {
        this.studyPoint = studyPoint;
    }

    @Override
    public String toString() {
        return "StudyDto{" +
                "studyId=" + studyId +
                ", studyName='" + studyName + '\'' +
                ", studyDate=" + studyDate +
                ", studyTime=" + studyTime +
                ", studyPoint=" + studyPoint +
                '}';
    }
}
