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

package com.sunday.learn.service.impl;

import com.sunday.learn.dao.UserDao;
import com.sunday.learn.enums.CommonRetCodeEnum;
import com.sunday.learn.enums.ResponseCodeEnum;
import com.sunday.learn.model.User;
import com.sunday.learn.model.base.CommonResult;
import com.sunday.learn.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author : Sunday
 * @Description :
 * @Date : 12:02 2017/8/21
 * @Modified By :
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public CommonResult<Integer> addUser(User user) {
        CommonResult<Integer> result = new CommonResult<>();
        Integer num;
        try {
            num = userDao.addUser(user);
            result.setData(num);
            result.setCode(ResponseCodeEnum.OK.getCode());
        } catch (Exception e) {
            log.error("addUser from db error, query : {},  e : {}", user.toString(), e);
            result.setCommonRetCodeEnum(CommonRetCodeEnum.BIZ_ERROR);
        }
        return result;
    }

    @Override
    public CommonResult<List<User>> getAllUser() {
        CommonResult<List<User>> result = new CommonResult<>();
        List<User> userList;
        try {
            userList = userDao.getAllUser();
            result.setData(userList);
            result.setCode(ResponseCodeEnum.OK.getCode());
        } catch (Exception e) {
            log.error("getAllUser from db error, e : {}", e);
            result.setCommonRetCodeEnum(CommonRetCodeEnum.BIZ_ERROR);
        }
        return result;
    }

    @Override
    public CommonResult<User> getUserById(Integer id) {
        CommonResult<User> result = new CommonResult<>();
        User user;
        try {
            user = userDao.getUserById(id);
            result.setData(user);
            result.setCode(ResponseCodeEnum.OK.getCode());
        } catch (Exception e) {
            log.error("getUserById from db error, e : {}", e);
            result.setCommonRetCodeEnum(CommonRetCodeEnum.BIZ_ERROR);
        }
        return result;
    }

    @Override
    public CommonResult<Integer> delUserById(Integer id) {
        CommonResult<Integer> result = new CommonResult<>();
        Integer num;
        try {
            num = userDao.delUserById(id);
            result.setData(num);
            result.setCode(ResponseCodeEnum.OK.getCode());
        } catch (Exception e) {
            log.error("delUserById from db error, query : {},  e : {}", id, e);
            result.setCommonRetCodeEnum(CommonRetCodeEnum.BIZ_ERROR);
        }
        return result;
    }

    @Override
    public CommonResult<Integer> updateUserById(Integer id, User user) {
        CommonResult<Integer> result = new CommonResult<>();
        Integer num;
        try {
            user.setId(id);
            num = userDao.updateUserById(user);
            result.setData(num);
            result.setCode(ResponseCodeEnum.OK.getCode());
        } catch (Exception e) {
            log.error("updateUserById from db error, query : {},  e : {}", user.toString(), e);
            result.setCommonRetCodeEnum(CommonRetCodeEnum.BIZ_ERROR);
        }
        return result;
    }
}
