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

package com.sunday.learn.service.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @Author : Sunday
 * @Description : redis 获取资源释放资源基类
 * @Date : 10:27 2017/9/11
 * @Modified By :
 */
@Slf4j
public class RedisBase {

    @Autowired
    private JedisPool jedisPool;

    /**
     * 连接jedisPool连接池，返回jedis资源
     * 添加日志记录
     *
     * @param jedis
     * @return
     */
    public void getResource(Jedis jedis) {
        log.info("Redis getResource start.");
        try {
            jedis = jedisPool.getResource();
            log.info("Redis getResource success.");
        } catch (Exception e) {
            log.error("Redis getResource error. e : {}", e);
        }
        log.info("Redis getResource end.");
    }

    /**
     * 返还到连接池
     * 添加日志记录
     *
     * @param jedis
     */
    public void closeResource(Jedis jedis) {
        log.info("Redis closeResource start.");
        try {
            jedis.close();
            log.info("Redis closeResource success.");
        } catch (Exception e) {
            log.error("Redis closeResource error. e : {}", e);
        }
        log.info("Redis closeResource end.");
    }


}
