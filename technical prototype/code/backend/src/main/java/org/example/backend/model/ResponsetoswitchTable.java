package org.example.backend.model;

import org.springframework.data.relational.core.sql.In;

public class ResponsetoswitchTable {
    private int code;

    public class Data {
        private String Cookie;
        private Integer tableId;

        public Data() {
        }

        // getters
        public String getCookie() {
            return Cookie;
        }

        public Integer getTableId() {
            return tableId;
        }

        // setters
        public void setCookie(String Cookie) {
            this.Cookie = Cookie;
        }

        public void setTableId(Integer tableId) {
            this.tableId = tableId;
        }
    }

    private Data data;

    public ResponsetoswitchTable() {
    }

    // getters
    public int getCode() {
        return code;
    }

    public Data getData() {
        return data;
    }

    // setters
    public void setCode(int value) {
        this.code = value;
    }

    public void setData(String Cookie, Integer tableId) {
        this.data = new Data();
        data.setCookie(Cookie);
        data.setTableId(tableId);
    }
}
