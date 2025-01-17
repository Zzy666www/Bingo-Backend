package com.bingo.pojo.dto.im;

import lombok.Data;

/**
 * @Author 徐志斌
 * @Date: 2023/5/29 21:03
 * @Version 1.0
 * @Description: ChatMsgDTO
 */
@Data
public class ChatMsgDTO {
    /**
     * 消息内容
     */
    private String msg;
    /**
     * 接收用户
     */
    private Long uid;
    /**
     * 群id
     */
    private Long groupId;
}
