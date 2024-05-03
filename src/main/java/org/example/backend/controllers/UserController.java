package org.example.backend.controllers;

import org.example.backend.model.*;
import org.example.backend.service.EventTableService;
import org.example.backend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

@RestController
//@CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true")
public class UserController {
    /*
    处理所有登录、密码修改相关的请求
    TODO：
        isPasswordCorrect 去数据库中检查密码是否正确
        addUserToDatabase 进行注册时，将用户信息添加到数据库
        addUserInfo 用户信息界面，点击保存后对于非用户名、密码的用户信息直接进行修改
        modifyPassword 用户信息界面支持修改密码的操作
        getUserInfo 显示个人信息页面的内容返回
    */

    @Autowired
    private UserService userService;

    @Autowired
    private EventTableService eventTableService;

    @PostMapping("/isPasswordCorrect")
    public ResponsetoisPasswordCorrect isPasswordCorrect(@RequestBody Map<String,Object> userData) {
        final Logger log = Logger.getLogger(UserController.class.getName());
//        log.info("receive isPasswordCorrect");
        String userID = (String) userData.get("userID");
        String password = (String) userData.get("password");
        int tableID = 0;
        ResponsetoisPasswordCorrect response = new ResponsetoisPasswordCorrect();
        response.setCode(1);
        User user = userService.isPasswardCorrect(userID, password);
        log.info("to here");
        if(user!=null){//如果正确
            Set<EventTable> eventTables = userService.getEventTablesByuserID(userID);
            if(eventTables.isEmpty()) {//如果user下面一张表都没有
                log.info("no table");
                EventTable eventTable = new EventTable();
                eventTable.setUser(user);
                eventTable.setDefaultTable(true);
                eventTableService.saveEventTable(eventTable);
                tableID = eventTable.getTableID();
            }
            else {
                //找到第一个default值为true的表
                for(EventTable eventTable : eventTables) {
                    if(eventTable.getDefaultTable()) {
                        tableID = eventTable.getTableID();
                        break;
                    }
                }
            }
            response.setData(true, tableID);//TODO:找到用户上次关闭时访问的表格（新用户就新建一张），并且返回这个table的ID
        }
        else {
            response.setData(false, 0);
        }
        return response;
//        return "passwordCorrect";
    }

    @PostMapping("/addUserToDatabase")
    public ResponsetoaddUsertoDatabase addUserToDatabase(@RequestBody Map<String,Object> userData) {
        //先搜索username在数据库中是否存在，如果存在则返回错误信息
        String userID = (String) userData.get("userID");
        String password = (String) userData.get("password");
        User user = new User();
        user.setUserID(userID);
        user.setPassword(password);
        ResponsetoaddUsertoDatabase response = new ResponsetoaddUsertoDatabase();
        if(userService.saveUser(user)) {
            response.setData(true);
            response.setCode(1);
            EventTable eventTable = new EventTable();
            eventTable.setUser(user);
            eventTable.setDefaultTable(true);
            eventTableService.saveEventTable(eventTable);
        }
        else {
            response.setData(false);
        }
        return response;
    }

    @PostMapping("/addUserInfo")
    public String addUserInfo(String username, String password) {
        return "addUserInfo";
    }

}
