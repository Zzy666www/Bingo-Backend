package com.bingo.pojo.common.response;

import com.bingo.enums.RespCodeEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author 徐志斌
 * @Date: 2023/5/8 21:59
 * @Version 1.0
 * @Description: BaseResponse
 */
@Getter
@Setter
public class BaseResponse {
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 响应消息
     */
    private String msg;

    protected BaseResponse() {
    }

    protected BaseResponse(RespCodeEnum code) {
        this.code = code.getCode();
        this.msg = code.getMsg();
    }
}