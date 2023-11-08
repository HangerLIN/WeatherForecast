package com.lth.weather.controller;

import com.lth.weather.Utils.ResData;
import com.lth.weather.entity.User;
import com.lth.weather.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final Logger log = LogManager.getLogger(UserController.class.getName());

    private final UserServiceImpl userService;

//    测试
    @GetMapping("/error")
    public String error(){
        int a = 1/0;
        System.out.println("闭包报错");
        return "报错了";
    }

    @PostMapping("/login")//登录(返回用户信息，跟喜欢的信息)
    public ResData UserLogin(@RequestBody User user){
        return userService.UserLogin(user);
    }

    @GetMapping("/like/{id}")
    public ResData UserLike(@PathVariable("id")String id){
        return userService.UserLike(id);
    }

    @PostMapping("/editPwd")
    public ResData editPwd(@RequestBody User user){
        return userService.editPwd(user);
    }

    @PostMapping("/editInfo")
    public ResData editInfo(@RequestBody User user){
        return userService.editInfo(user);
    }

    @GetMapping("/addLike/{name}/{userId}")
    public ResData addLike(@PathVariable("name") String name,@PathVariable("userId") String userId){
        return userService.addLike(name,userId);
    }

    @GetMapping("/delLike/{name}/{userId}")
    public ResData delLike(@PathVariable("name") String name,@PathVariable("userId") String userId){
        return userService.delLike(name,userId);
    }

    @PostMapping("/add")
    public ResData addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping("/del")
    public ResData delUser(@PathVariable("del") String id){//删除一个用户
        return userService.delUser(id);
    }

    @GetMapping("/getAll")
    public ResData getAll(){
        return userService.getAll();
    }


}
