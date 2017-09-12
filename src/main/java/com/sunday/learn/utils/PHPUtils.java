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

package com.sunday.learn.utils;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author : Sunday
 * @Description : php manual to java
 * @Date : 9:39 2017/9/12
 * @Modified By :
 * todo
 */
@Slf4j
public class PHPUtils {

    /**
     * 获取变量的整数值,成功时返回 var 的 integer 值，失败时返回 0。 空的 array 返回 0，非空的 array 返回 1。
     *
     * @return
     */
    public static Integer intval(Object object) {
        // 输入参数可能为int str array
        try {
            if (object instanceof String) {
                return Integer.parseInt(object.toString());
            } else if (object instanceof Integer) {
                return (Integer) object;
            }
        } catch (Exception e) {
            log.warn("PHPUtils intval error, param ： {}", JSONObject.toJSONString(object));
        }
        return null;
    }

    public static String strval() {
        return null;
    }

}
