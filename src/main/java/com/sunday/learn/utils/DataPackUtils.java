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

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Sunday
 * @Description :
 * @Date : 14:24 2017/8/21
 * @Modified By :
 */
public class DataPackUtils {

    /**
     * 拆分list,
     */
    public static <T> List<List<T>> createList(List<T> target, int size) {
        List<List<T>> listArr = new ArrayList<>();
        // 获取被拆分的数组个数
        int arrSize = target.size() % size == 0 ? target.size() / size : target.size() / size + 1;
        for (int i = 0; i < arrSize; i++) {
            List<T> sub = new ArrayList<>();
            // 把指定索引数据放入到list中
            for (int j = i * size; j <= size * (i + 1) - 1; j++) {
                if (j <= target.size() - 1) {
                    sub.add(target.get(j));
                }
            }
            listArr.add(sub);
        }
        return listArr;
    }

    /**
     * 格式化分页总数
     *
     * @param total
     * @param pageSize
     * @return
     */
    public static Integer formatTotalPage(Integer total, Integer pageSize) {
        return (total % pageSize == 0) ? total / pageSize : total / pageSize + 1;
    }

}
