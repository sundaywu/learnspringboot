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

package com.sunday.learn.model.base;

import com.sunday.learn.enums.CommonRetCodeEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author : Sunday
 * @Description : 通用结果类
 * @Date : 12:04 2017/8/21
 * @Modified By :
 */
@Getter
@Setter
public class CommonResult<T> extends BaseObject {

    private Integer code;

    private String errorMsg;

    private CommonRetCodeEnum commonRetCodeEnum;

    private T data;

}
