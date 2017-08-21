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

package com.sunday.learn.dao.impl;

import com.sunday.learn.dao.UserDao;
import com.sunday.learn.mapper.UserMapper;
import com.sunday.learn.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author : Sunday
 * @Description :
 * @Date : 11:56 2017/8/21
 * @Modified By :
 */
@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer addUser(User user) throws DataAccessException {
        return userMapper.addUser(user);
    }

    @Override
    public List<User> getAllUser() throws DataAccessException {
        return userMapper.getAllUser();
    }

    @Override
    public User getUserById(Integer id) throws DataAccessException {
        return userMapper.getUserById(id);
    }

    @Override
    public Integer delUserById(Integer id) throws DataAccessException {
        return userMapper.delUserById(id);
    }

    @Override
    public Integer updateUserById(User user) throws DataAccessException {
        return userMapper.updateUserById(user);
    }

}
