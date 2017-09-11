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

package com.sunday.learn.service.base.impl;

import com.sunday.learn.service.base.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @Author : sunday
 * @Description : redis服务类
 * @Date : 16:12 2017/9/9
 * @Modified By :
 */
@Slf4j
@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private JedisPool jedisPool;

    private Jedis jedis = null;

    @Override
    public Boolean setKeyValue(String key, String value, Long expiredTime) {
        Boolean flag = false;
        try {
            getResource(jedis);
            jedis.set(key, value);
            if (expiredTime != null) {
                jedis.expire(key, Integer.valueOf(expiredTime.toString()));
            }
            flag = true;
        } catch (Exception e) {
            log.error("Redis setKeyValue error. key : {}, value : {}, e ： {}", key, value, e);
        } finally {
            closeResource(jedis);
        }
        return flag;
    }

    @Override
    public String getValue(String key) {
        String ret = null;
        try {
            getResource(jedis);
            ret = jedis.get(key);
        } catch (Exception e) {
            log.error("Redis getValue error. key : {}, e : {}", key, e);
        } finally {
            closeResource(jedis);
        }
        return ret;
    }

    @Override
    public Boolean incr(String key) {
        Boolean flag = false;
        try {
            getResource(jedis);
            jedis.incr(key);
            flag = true;
        } catch (Exception e) {
            log.error("Redis incr error. key : {}, e ： {}", key, e);
        } finally {
            closeResource(jedis);
        }
        return flag;
    }

    @Override
    public Boolean expire(String key, Long expiredTime) {
        Boolean flag = false;
        try {
            getResource(jedis);
            jedis.expire(key, Integer.valueOf(expiredTime.toString()));
            flag = true;
        } catch (Exception e) {
            log.error("Redis expire error. key : {}, expiredTime : {}, e ： {}", key, expiredTime, e);
        } finally {
            closeResource(jedis);
        }
        return flag;
    }

    @Override
    public Boolean delKeyValue(String key) {
        Boolean flag = false;
        try {
            getResource(jedis);
            if (jedis.exists(key)) {
                jedis.del(key);
            } else {
                log.warn("Redis del key does not exist. key : {}", key);
            }
            flag = true;
        } catch (Exception e) {
            log.error("Redis del error. key : {}, e ： {}", key, e);
        } finally {
            closeResource(jedis);
        }
        return flag;
    }

    @Override
    public Boolean exists(String key) {
        Boolean flag = false;
        try {
            getResource(jedis);
            flag = jedis.exists(key);
        } catch (Exception e) {
            log.error("Redis del error. key : {}, e ： {}", key, e);
        } finally {
            closeResource(jedis);
        }
        return flag;
    }

    /**
     * 连接jedisPool连接池，返回jedis资源
     * 添加日志记录
     *
     * @param jedis
     */
    private void getResource(Jedis jedis) {
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
    private void closeResource(Jedis jedis) {
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
