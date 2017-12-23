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

/**
 * @Author : Sunday
 * @Description :
 * @Date : 16:58 2017/12/23
 * @Modified By :
 */
public class ParamFormatUtils {

    /**
     * 日志中多参数的打印
     *
     * @param objects
     * @return
     */
    public static String formatLog(Object... objects) {
        return JSONObject.toJSONString(objects);
    }

}
