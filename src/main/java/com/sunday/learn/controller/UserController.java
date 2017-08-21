/*
*          ┌─┐       ┌─┐
*       ┌──┘ ┴───────┘ ┴──┐
*       │                 │
*       │       ───       │
*       │  ─┬┘       └┬─  │
*       │                 │
*       │       ─┴─       │
*       │                 │
*       └───┐         ┌───┘
*           │         │
*           │         │
*           │         │
*           │         └──────────────┐
*           │                        │
*           │                        ├─┐
*           │                        ┌─┘    
*           │                        │
*           └─┐  ┐  ┌───────┬──┐  ┌──┘         
*             │ ─┤ ─┤       │ ─┤ ─┤         
*             └──┴──┘       └──┴──┘ 
*                 神兽保佑 
*                 代码无BUG! 
*/

package com.sunday.learn.controller;

import com.sunday.learn.model.User;
import com.sunday.learn.model.base.CommonResult;
import com.sunday.learn.model.base.JsonResponse;
import com.sunday.learn.service.UserService;
import com.sunday.learn.utils.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author : Sunday
 * @Description :
 * @Date : 12:57 2017/8/21
 * @Modified By :
 */
@Api(value="User Controller",description="用户表操作",tags={"用户表操作接口"})
@RestController
@RequestMapping(value = "/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value="获取用户列表", notes="")
    @RequestMapping(value = "/getAll", method= RequestMethod.GET)
    @ResponseBody
    public JsonResponse getAllUser() {
        CommonResult result = userService.getAllUser();
        return ResultUtils.response(result);
    }

    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @RequestMapping(value="/add", method=RequestMethod.POST)
    @ResponseBody
    public JsonResponse addUser(@RequestBody User user) {
        CommonResult result = userService.addUser(user);
        return ResultUtils.response(result);
    }

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @RequestMapping(value="/get", method= RequestMethod.POST)
    @ResponseBody
    public JsonResponse getUserById(@RequestParam Integer id) {
        CommonResult result = userService.getUserById(id);
        return ResultUtils.response(result);
    }

    @ApiOperation(value="更新用户详细信息", notes="根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @RequestMapping(value="/update", method=RequestMethod.POST)
    @ResponseBody
    public JsonResponse updateUserById(@RequestParam Integer id, @RequestBody User user) {
        CommonResult result = userService.updateUserById(id, user);
        return ResultUtils.response(result);
    }

    @ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
    @RequestMapping(value="/del", method=RequestMethod.GET)
    @ResponseBody
    public JsonResponse delUserById(@RequestParam Integer id) {
        CommonResult result = userService.delUserById(id);
        return ResultUtils.response(result);
    }

}
