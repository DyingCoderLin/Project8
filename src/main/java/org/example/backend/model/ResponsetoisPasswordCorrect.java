package org.example.backend.model;

public class ResponsetoisPasswordCorrect {
    private int code;

    public class Data {
        private String cookie;
        private boolean isLogin;//1为密码正确，0为密码或用户名错误
        private int tableID;
        private String tableName;
        private String background;
        private String font;
        private String courseColor;
        private String eventColor;
        private String firstDayDate;
        private Integer weekAmount;
        //TODO：此外还要新建一张空表返回给前端

        // getters
        public String getCookie() { return cookie; }
        public boolean getIsLogin() { return isLogin; }
        public int getTableID() { return tableID; }
        public String getTableName() { return tableName; }
        public String getBackground() { return background; }
        public String getFont() { return font; }
        public String getCourseColor() { return courseColor; }
        public String getEventColor() { return eventColor; }
        public String getFirstDayDate() { return firstDayDate; }
        public Integer getWeekAmount() { return weekAmount; }

        // setters
        public void setCookie(String cookie) { this.cookie = cookie; }
        public void setIsLogin(boolean isLogin) { this.isLogin = isLogin; }
        public void setTableID(int tableID) { this.tableID = tableID; }
        public void setTableName(String tableName) { this.tableName = tableName; }
        public void setBackground(String background) { this.background = background; }
        public void setFont(String font) { this.font = font; }
        public void setCourseColor(String courseColor) { this.courseColor = courseColor; }
        public void setEventColor(String eventColor) { this.eventColor = eventColor; }
        public void setFirstDayDate(String firstDayDate) { this.firstDayDate = firstDayDate; }
        public void setWeekAmount(Integer weekAmount) { this.weekAmount = weekAmount; }
    }

    private Data data;

    public ResponsetoisPasswordCorrect() {
        this.code = 1; // 默认响应码为1
        this.data = null; // 默认数据为空
    }

    public ResponsetoisPasswordCorrect(int code, Data data,String cookie) {
        this.code = code;
        this.data = data;
    }

    public long getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Data getData() {
        return data;
    }

    public void setData(boolean isLogin, int tableID,String cookie,String tableName,String background, String font,String courseColor,String eventColor,String firstDayDate, Integer weekAmount) {
        this.data = new Data();
        this.data.setIsLogin(isLogin);
        this.data.setTableID(tableID);
        this.data.setCookie(cookie);
        this.data.setTableName(tableName);
        this.data.setBackground(background);
        this.data.setFont(font);
        this.data.setCourseColor(courseColor);
        this.data.setEventColor(eventColor);
        this.data.setFirstDayDate(firstDayDate);
        this.data.setWeekAmount(weekAmount);
    }

    public void setFailureData(boolean isLogin, int tableID,String cookie) {
        this.data = new Data();
        this.data.setIsLogin(isLogin);
        this.data.setTableID(tableID);
        this.data.setCookie(cookie);
    }
}
