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

import java.util.Random;
import java.util.UUID;

/**
 * @Author : Sunday
 * @Description : 生成UUID工具类
 * @Date : 14:12 2017/8/21
 * @Modified By :
 */
public class UUIDUtils {

    public static String generateUUID() {
        String uuid = UUID.randomUUID().toString() + new Random().nextInt(10000);
        return uuid.replaceAll("-", "");
    }

}
