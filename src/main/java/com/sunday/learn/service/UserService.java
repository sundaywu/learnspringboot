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
package com.sunday.learn.service;

import com.sunday.learn.model.User;
import com.sunday.learn.model.base.CommonResult;

import java.util.List;

/**
 * @Author : Sunday
 * @Description :
 * @Date : 12:00 2017/8/21
 * @Modified By :
 */
public interface UserService {

    public CommonResult<Integer> addUser(User user);

    public CommonResult<List<User>> getAllUser();

    public CommonResult<User> getUserById(Integer id);

    public CommonResult<Integer> delUserById(Integer id);

    public CommonResult<Integer> updateUserById(Integer id, User user);
    
}
