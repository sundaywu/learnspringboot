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

package com.sunday.learn.enums;

/**
 * @Author : Sunday
 * @Description :
 * @Date : 12:09 2017/8/21
 * @Modified By :
 */
public enum CommonRetCodeEnum implements BaseEnum {

    PARAMETER_ERROR(4000, "参数错误"),
    CHANNEL_NAME_REPEAT(4001, "频道名称重复"),
    UPDATE_DB_FAILED(4002, "更新数据库失败"),
    SELECT_DB_FAILED(4003, "获取数据库数据失败"),
    BIZ_ERROR(4010, "业务异常"),
    REQUEST_COMMON_ERROR(4020, "请求出错"),
    USER_STATUS_ERROR(4030, "用户状态异常"),
    ACCOUNT_STATUS_ERROR(4040, "账号信息不匹配"),
    FILE_SIZE_ERROR(4050, "上传文件太大"),
    FILE_UPLOAD_ERROR(4060, "上传文件失败");

    private Integer code;
    private String  remark;

    CommonRetCodeEnum(Integer code, String remark){
        this.code = code;
        this.remark = remark;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getRemark() {
        return remark;
    }
}
