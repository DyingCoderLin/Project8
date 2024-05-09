package org.example.backend.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.example.backend.model.*;
import org.example.backend.service.EventTableService;
import org.example.backend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

@RestController
//@CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true")
public class UserController {
    /*
    处理所有登录、密码修改相关的请求
    TODO：
        isPasswordCorrect 去数据库中检查密码是否正确，done,需要找到默认的table，如果没有coursetimetable要给他创建一个
        addUserToDatabase 进行注册时，将用户信息添加到数据库,done
        addUserInfo 用户信息界面，点击保存后对于非用户名、密码的用户信息直接进行修改,done
        modifyPassword 用户信息界面支持修改密码的操作 done
        getUserInfo 显示个人信息页面的内容返回 done
    */

    @Autowired
    private UserService userService;

    @Autowired
    private EventTableService eventTableService;

    @Autowired
    private CourseTimeTableService courseTimeTableService;

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
        EventTable defaulteventTable = null;
//        log.info("to here");
        if(user!=null){//如果正确
            Set<EventTable> eventTables = userService.getEventTablesByuserID(userID);
            if(eventTables.isEmpty()) {//如果user下面一张表都没有
//                log.info("no table");
                defaulteventTable = new EventTable();
                defaulteventTable.setUser(user);
                defaulteventTable.setDefaultTable(true);
                eventTableService.saveEventTable(defaulteventTable);
                tableID = defaulteventTable.getTableID();
                //courseTimeTable和eventTable一一对应，所以eventtable的创建、删除要与courseTimeTable绑定
                CourseTimeTable courseTimeTable = new CourseTimeTable();
                courseTimeTable.setEventTableID(tableID);
                courseTimeTableService.save(courseTimeTable);
            }
            else {
                //找到第一个default值为true的表
                for(EventTable eventTable : eventTables) {
                    if(eventTable.getDefaultTable()) {
                        tableID = eventTable.getTableID();
                        defaulteventTable = eventTable;
                        break;
                    }
                }
            }
            String cookieValue = "userID="+ userID + ";tableID=" + tableID; // 将 userID 和 tableID 拼接成一个字符串
            response.setData(true, tableID,cookieValue,defaulteventTable.getTableName(),defaulteventTable.getBackground(),defaulteventTable.getFont(),defaulteventTable.getCourseColor(),defaulteventTable.getEventColor(),MyUtils.dateToString(defaulteventTable.getFirstDayDate()),defaulteventTable.getWeekAmount());
        }
        else {
            response.setFailureData(false, 0,null);
        }
        return response;
//        return "passwordCorrect";
    }

    @PostMapping("/addUserToDatabase")
    public ResponsetoaddUsertoDatabase addUserToDatabase(@RequestBody Map<String,Object> userData) {
        //先搜索username在数据库中是否存在，如果存在则返回错误信息
        final Logger log = Logger.getLogger(UserController.class.getName());
        String userID = (String) userData.get("userID");
        String password = (String) userData.get("password");
        User user = new User();
        user.setUserID(userID);
        user.setPassword(password);
        ResponsetoaddUsertoDatabase response = new ResponsetoaddUsertoDatabase();
        log.info("to here 0");
        if(userService.saveUser(user)) {
            response.setData(true);
            response.setCode(1);
            EventTable eventTable = new EventTable();
            eventTable.setUser(user);
            eventTable.setDefaultTable(true);
            eventTableService.saveEventTable(eventTable);
            int tableID = eventTable.getTableID();
            //courseTimeTable和eventTable一一对应，所以eventtable的创建、删除要与courseTimeTable绑定
            CourseTimeTable courseTimeTable = new CourseTimeTable();
            courseTimeTable.setEventTableID(tableID);
            courseTimeTableService.save(courseTimeTable);
        }
        else {
            response.setData(false);
        }
        return response;
    }

    @PostMapping("/addUserInfo")
    public void addUserInfo(@RequestHeader(value="Cookie") String cookie,
                              @RequestBody Map<String,Object> requestBody) {
        String userID = null;
//        Integer tableID = 0;
        String userName = (String) requestBody.get("userName");
        boolean userGender = (boolean) requestBody.get("userGender");//0为男，1为女
        String userLocation = (String) requestBody.get("userLocation");
        String AvatarURL = (String) requestBody.get("AvatarURL");
        String[] cookieInfo = MyUtils.getCookieInfo(cookie);
        userID = cookieInfo[0];
//        tableID = Integer.parseInt(cookieInfo[1]);
        User user = userService.getUserByUserID(userID);
        user.setUserName(userName);
        user.setUserGender(userGender);
        user.setUserLocation(userLocation);
        user.setAvatarURL(AvatarURL);
        userService.updateUser(user);
//        return "addUserInfo";
    }

    @PostMapping("/modifyPassword")
    public ResponsetomodifyPassword modifyPassword(@RequestHeader(value="Cookie") String cookie,
                               @RequestBody Map<String,Object> requestBody) {
        String userID = null;
        String[] cookieInfo = MyUtils.getCookieInfo(cookie);
        userID = cookieInfo[0];
        String oldPassword = (String) requestBody.get("oldPassword");
        String newPassword = (String) requestBody.get("newPassword");
        User user = userService.isPasswardCorrect(userID, oldPassword);
        ResponsetomodifyPassword response = new ResponsetomodifyPassword();
        response.setCode(1);
        //先检查该用户的用户名和密码是否正确
        if(user!=null){
            if(oldPassword.equals(newPassword)) {
                response.setData(1);
            }
            else {
                user.setPassword(newPassword);
                userService.updateUser(user);
                response.setData(2);
            }
        }
        else{
            response.setData(0);
        }
        return response;
    }

    @GetMapping("/getUserInfo")
    public ResponsetogetUserInfo getUserInfo(@RequestHeader(value="Cookie") String cookie) {
        String userID = null;
        String[] cookieInfo = MyUtils.getCookieInfo(cookie);
        userID = cookieInfo[0];
        User user = userService.getUserByUserID(userID);
        ResponsetogetUserInfo response = new ResponsetogetUserInfo();
        response.setCode(1);
        response.setData(user.getUserID(), user.getUserName(), user.getUserGender(), user.getUserLocation());
//        response.setCode(1);
//        response.setData(user.getUserName(), user.getUserGender(), user.getUserLocation(), user.getAvatarURL());
        return response;
    }
}
