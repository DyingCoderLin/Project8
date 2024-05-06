package org.example.backend.model;

public class ResponsetoloadMonthVision {
    private int code;
    public class dayInformation{
        //是否有日程
        private boolean isHaveSchedule;
        //是否有日程
        private boolean isHaveCourse;
        private boolean isImportant;
        private boolean isChanged;
    }
}
