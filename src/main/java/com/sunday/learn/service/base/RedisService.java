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

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @Author : sunday
 * @Description : redis服务类
 * @Date : 16:12 2017/9/9
 * @Modified By :
 */
@Slf4j
public class RedisService {

    @Autowired
    JedisPool jedisPool;

    /**
     * 设置数据(不限时间)
     * todo
     *
     * @param key
     * @param val
     * @return
     */
    public Boolean setRedis(String key, Object val) {
        Jedis jedis = jedisPool.getResource();
        try {
            if (!jedis.exists(JSONObject.toJSONString(key))) {
                jedis.set(key, JSONObject.toJSONString(val));
            } else {
                log.warn("");
            }
        } catch (Exception e) {

        } finally {

        }
        return true;
    }

}
