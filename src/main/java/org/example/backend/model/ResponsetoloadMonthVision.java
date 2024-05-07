package org.example.backend.model;

import java.util.ArrayList;
import java.util.List;

public class ResponsetoloadMonthVision {
    private int code;
    public class DayInformation{
        //是否有日程
        private boolean isHaveSchedule;
        //是否有日程
        private boolean isHaveCourse;
        private boolean isImportant;
        private boolean isChanged;
        // getters
        public boolean getIsHaveSchedule() { return isHaveSchedule; }
        public boolean getIsHaveCourse() { return isHaveCourse; }
        public boolean getIsImportant() { return isImportant; }
        public boolean getIsChanged() { return isChanged; }

        // setters
        public void setIsHaveSchedule(boolean isHaveSchedule) { this.isHaveSchedule = isHaveSchedule; }
        public void setIsHaveCourse(boolean isHaveCourse) { this.isHaveCourse = isHaveCourse; }
        public void setIsImportant(boolean isImportant) { this.isImportant = isImportant; }
        public void setIsChanged(boolean isChanged) { this.isChanged = isChanged; }
    }
    private List<DayInformation> dayInformations;
    public ResponsetoloadMonthVision(){
        code = 1;
        dayInformations = new ArrayList<>();
    }
    public void setCode(int code){
        this.code = code;
    }
    public int getCode(){
        return code;
    }
    public void addDayInformation(boolean isHaveSchedule,boolean isHaveCourse,boolean isImportant,boolean isChanged){
        DayInformation dayInformation = new DayInformation();
        dayInformation.setIsHaveSchedule(isHaveSchedule);
        dayInformation.setIsHaveCourse(isHaveCourse);
        dayInformation.setIsImportant(isImportant);
        dayInformation.setIsChanged(isChanged);
        dayInformations.add(dayInformation);
    }
    public List<DayInformation> getDayInformations(){
        return dayInformations;
    }
    public void setDayInformations(List<DayInformation> dayInformations){
        this.dayInformations = dayInformations;
    }
}
