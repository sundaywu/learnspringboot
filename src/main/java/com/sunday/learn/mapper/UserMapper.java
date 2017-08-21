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
package com.sunday.learn.mapper;

import com.sunday.learn.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

import java.util.List;

/**
 * @Author : Sunday
 * @Description :
 * @Date : 11:42 2017/8/21
 * @Modified By :
 */
@Mapper
public interface UserMapper {

    public Integer addUser(User user) throws DataAccessException;

    public List<User> getAllUser() throws DataAccessException;

    public User getUserById(Integer id) throws DataAccessException;

    public Integer delUserById(Integer id) throws DataAccessException;

    public Integer updateUserById(User user) throws DataAccessException;
}
