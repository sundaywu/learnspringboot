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

import java.util.Map;
import java.util.Set;

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
    Long delKeyValue(String key);

    /**
     * 检查redis中是否存在key
     *
     * @param key
     * @return
     * @throws Exception
     */
    Boolean exists(String key);

    /**
     * 将一个 member 元素及其 score 值加入到有序集 key 当中
     *
     * @param key
     * @param score
     * @param member
     * @return
     */
    Long zadd(String key, double score, String member);

    /**
     * 将多个 member 元素及其 score 值加入到有序集 key 当中
     *
     * @param key
     * @param scoreMembers
     * @return
     */
    Long zadd(String key, Map<String, Double> scoreMembers);

    /**
     * 返回有序集 key 中，成员 member 的 score 值
     *
     * @param key
     * @param member
     * @return
     */
    Double zscore(String key, String member);

    /**
     * 返回有序集 key 的基数
     *
     * @param key
     * @return
     */
    Long zcard(String key);

    /**
     * 返回有序集 key 中，所有 score 值介于 min 和 max 之间(包括等于 min 或 max )的成员
     * 有序集成员按 score 值递增(从小到大)次序排列
     *
     * @param key
     * @param min
     * @param max
     * @param offset
     * @param count
     * @return
     */
    Set<String> zrangeByScore(final String key, final double min, final double max,
                              final int offset, final int count);

    Set<String> zrangeByScore(final String key, final double min, final double max);

    /**
     * 返回有序集 key 中， score 值介于 max 和 min 之间(默认包括等于 max 或 min )的所有的成员
     * 有序集成员按 score 值递减(从大到小)的次序排列
     *
     * @param key
     * @param max
     * @param min
     * @param offset
     * @param count
     * @return
     */
    Set<String> zrevrangeByScore(final String key, final double max, final double min,
                                 final int offset, final int count);

    Set<String> zrevrangeByScore(final String key, final double max, final double min);
}
