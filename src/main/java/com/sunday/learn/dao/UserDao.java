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
package com.sunday.learn.dao;

import com.sunday.learn.model.User;
import org.springframework.dao.DataAccessException;

import java.util.List;

/**
 * @Author : Sunday
 * @Description :
 * @Date : 13:57 2017/8/21
 * @Modified By :
 */
public interface UserDao {

    public Integer addUser(User user) throws DataAccessException;

    public List<User> getAllUser() throws DataAccessException;

    public User getUserById(Integer id) throws DataAccessException;

    public Integer delUserById(Integer id) throws DataAccessException;

    public Integer updateUserById(User user) throws DataAccessException;
}
