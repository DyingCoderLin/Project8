package org.example.backend.model;

public class ResponsetoisPasswordCorrect {
    private int code;

    public class Data {
        //private String cookie;
        private boolean isLogin;//1为密码正确，0为密码或用户名错误
        private int tableID;
        //TODO：此外还要新建一张空表返回给前端

        //public String getCookie() { return cookie; }
        //public void setCookie(String value) { this.cookie = value; }

        public boolean getIsLogin() { return isLogin; }
        public void setIsLogin(boolean value) { this.isLogin = value; }

        public int getTableID() { return tableID; }
        public void setTableID(int value) { this.tableID = value; }
    }

    private Data data;

    public ResponsetoisPasswordCorrect() {
        this.code = 1; // 默认响应码为1
        this.data = null; // 默认数据为空
    }

    public ResponsetoisPasswordCorrect(int code, Data data) {
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

    public void setData(boolean isLogin, int tableID) {
        this.data = new Data();
        this.data.setIsLogin(isLogin);
        this.data.setTableID(tableID);
    }
}
