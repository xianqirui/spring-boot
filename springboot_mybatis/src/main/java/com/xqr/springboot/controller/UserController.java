package com.xqr.springboot.controller;

import com.github.pagehelper.PageInfo;
import com.xqr.springboot.exception.ParamsException;
import com.xqr.springboot.po.User;
import com.xqr.springboot.query.UserQuery;
import com.xqr.springboot.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

//@Controller //可以视图，可以json
@RestController//返回json,可以不加@ResponseBody注解
public class UserController {
    @Resource
    private UserService userService;
    @GetMapping("user/name/{userName}")
    //@ResponseBody
    public User findUser(@PathVariable String userName){
    return userService.findUser(userName);
    }

    @GetMapping("user/id/{userId}")
    public User findByid(@PathVariable Integer userId){
        return userService.findByid(userId);
    }
    //添加操作
    @PostMapping("user/add")
    public Map<String,Object> addUser(@RequestBody User user){
    Map<String,Object> map=new HashMap<>();
    /*try {
        //调用service方法
        userService.addUser(user);
        map.put("code",200);
        map.put("msg","添加用户成功");
    }catch (ParamsException p){
        map.put("code",p.getCode());
        map.put("msg",p.getMsg());
        p.printStackTrace();
    }catch (Exception e){
        map.put("code",500);
        map.put("msg","用户添加失败");
        e.printStackTrace();
    }*/
        userService.addUser(user);
        map.put("code",200);
        map.put("msg","添加用户成功");
      return map;
    }
    //添加校验
    @PostMapping("user02")
    public Map<String,Object> addUser02(@Valid User user) {
        Map<String, Object> map = new HashMap<>();
        userService.addUser(user);
        map.put("code", 200);
        map.put("msg", "添加用户成功");
        return map;
    }
    @PutMapping("user/update")
    public Map<String,Object> updateuser(@RequestBody User user){
        Map<String,Object> map=new HashMap<>();
        userService.updateUser(user);
        map.put("code",200);
        map.put("msg","修改用户成功");
        return map;
    }
    //删除用户
    @DeleteMapping("user/delect/{id}")
    public Map<String,Object> delectuser(@PathVariable Integer id){
        Map<String,Object> map=new HashMap<>();
        userService.delectUser(id);
        map.put("code",200);
        map.put("msg","删除用户成功");
        return map;
    }
    //分页擦查询
    @RequestMapping("list")
    public PageInfo<User> queryUserByname(UserQuery userQuery){
        return userService.queryByName(userQuery);
    }

}
