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

import com.sunday.learn.enums.CommonRetCodeEnum;
import com.sunday.learn.enums.ResponseCodeEnum;
import com.sunday.learn.model.base.CommonResult;
import com.sunday.learn.model.base.JsonResponse;

import java.util.Objects;

/**
 * @Author : Sunday
 * @Description : 返回值组装工具类
 * @Date : 12:56 2017/8/21
 * @Modified By :
 */
public class ResultUtils {

    private static <T> JsonResponse<T> response(Integer code) {
        return response(code, null);
    }

    private static <T> JsonResponse<T> response(Integer code, String msg) {
        JsonResponse<T> response = new JsonResponse<>();
        response.setCode(code);
        response.setMsg(msg);
        return response;
    }

    private static <T> JsonResponse<T> responseWithData(Integer code, T data) {
        JsonResponse<T> response = response(code);
        response.setData(data);
        return response;
    }

    public static <T> JsonResponse<T> response(CommonResult<T> dto) {
        if (dto == null) {
            return response(ResponseCodeEnum.COMMON_ERROR.getCode(), ResponseCodeEnum.COMMON_ERROR.getRemark());
        } else if (null != dto.getCommonRetCodeEnum()) {
            CommonRetCodeEnum codeEnum = dto.getCommonRetCodeEnum();
            return response(codeEnum.getCode(), codeEnum.getRemark());
        } else if (Objects.equals(dto.getCode(), ResponseCodeEnum.OK.getCode())) {
            return responseWithData(dto.getCode(), dto.getData());
        } else if (!Objects.equals(dto.getCode(), ResponseCodeEnum.OK.getCode())) {
            return response(dto.getCode(), dto.getErrorMsg());
        } else {
            return response(ResponseCodeEnum.COMMON_ERROR.getCode(), ResponseCodeEnum.COMMON_ERROR.getRemark());
        }
    }

}
