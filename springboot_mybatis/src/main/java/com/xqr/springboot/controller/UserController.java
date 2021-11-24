package com.xqr.springboot.controller;

import com.github.pagehelper.PageInfo;
import com.xqr.springboot.exception.ParamsException;
import com.xqr.springboot.po.User;
import com.xqr.springboot.query.UserQuery;
import com.xqr.springboot.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
@Api(tags = "用户控制模块")
//@Controller //可以视图，可以json
@RestController//返回json,可以不加@ResponseBody注解
public class UserController {
    @Resource
    private UserService userService;
    @ApiOperation(value = "根据用户名查询用户对象")
    @ApiImplicitParam(name = "userName",value = "用户名")
    @GetMapping("user/name")
    //@ResponseBody
    public User findUser(@Valid String userName){
        System.out.println("测试热部署-----------------------");
    return userService.findUser(userName);
    }
    //
    @ApiOperation(value = "根据用户id查询用户对象")
    @ApiImplicitParam(name = "userId",value = "用户id")
    @GetMapping("user/id")
    @Cacheable(value = "users",key = "#userId")
    public User findByid(@Valid Integer userId){
        return userService.findByid(userId);
    }

    //添加操作
    @PostMapping("user/add")
    @ApiOperation(value = "使用json添加对象")
    @ApiImplicitParam(name = "user",value = "用户对象")
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
    /*参数校验需要在校验的参数前添加@Valid注解*/
    @PostMapping("user02")
    @ApiOperation(value = "添加校验")
    @ApiImplicitParam(name = "user",value = "用户对象")
    public Map<String,Object> addUser02(@Valid User user) {
        Map<String, Object> map = new HashMap<>();
        userService.addUser(user);
        map.put("code", 200);
        map.put("msg", "添加用户成功");
        return map;
    }
    //修改
    @PutMapping("user/update")
    @ApiOperation(value = "修改对象")
    @ApiImplicitParam(name = "user",value = "用户对象")
    public Map<String,Object> updateuser(@Valid User user){
        Map<String,Object> map=new HashMap<>();
        userService.updateUser(user);
        map.put("code",200);
        map.put("msg","修改用户成功");
        return map;
    }
    //chcache修改
    /*
    * 设置缓存但更新时，缓存与数据库同步
    * */
    @PutMapping("user/update02")
    @CachePut(value = "users",key ="#user.id" )
    @ApiOperation(value = "cache修改对象")
    @ApiImplicitParam(name = "user",value = "用户对象")
    public User updateuser02(@RequestBody User user){
        userService.updateUser(user);
        return user;
    }
    //删除用户
    @DeleteMapping("user/delect/{id}")
    @CacheEvict(value = "users",key = "#id")
    @ApiOperation(value = "删除对象")
    @ApiImplicitParam(name = "id",value = "用户id")
    public Map<String,Object> delectuser(@PathVariable Integer id){
        Map<String,Object> map=new HashMap<>();
        userService.delectUser(id);
        map.put("code",200);
        map.put("msg","删除用户成功");
        return map;
    }
    //分页擦查询
    @GetMapping("list")
    @Cacheable(value = "users",key = "#userQuery.userName+'-'+#userQuery.pageNum+'-'+userQuery.pageSize")
    @ApiOperation(value = "分页查询对象")
    @ApiImplicitParam(name = "userQuery",value = "分页用户对象")
    public PageInfo<User> queryUserByname(UserQuery userQuery){
        return userService.queryByName(userQuery);
    }

}
