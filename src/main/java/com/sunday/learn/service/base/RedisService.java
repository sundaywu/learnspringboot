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

/**
 * @Author : Sunday
 * @Description : redis服务类
 * @Date : 10:18 2017/9/11
 * @Modified By :
 */
public interface RedisService {

    /**
     * 设置redis值
     *
     * @param key
     * @param value
     * @param expiredTime
     * @throws Exception
     */
    Boolean setKeyValue(String key,String value,Long expiredTime);

    /**
     * 获取redis中的key值
     *
     * @param key
     * @return
     * @throws Exception
     */
    String getValue(String key);

    /**
     * 往redis中存放key的自增值，如果key的value不存在则创建key的值为0并且加1，存在则直接加1
     *
     * @param key
     * @throws Exception
     */
    Boolean incr(String key);

    /**
     * 设置reids中key对应的失效时间，单位为秒
     *
     * @param key
     * @param expiredTime
     * @throws Exception
     */
    Boolean expire(String key,Long expiredTime);

    /**
     * 删除redis中指定key与值
     *
     * @param key
     * @throws Exception
     */
    Boolean delKeyValue(String key);

    /**
     * 检查redis中是否存在key
     *
     * @param key
     * @return
     * @throws Exception
     */
    Boolean exists(String key);

}
