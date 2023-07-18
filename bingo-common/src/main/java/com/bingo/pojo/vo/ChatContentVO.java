package com.bingo.pojo.vo;

import lombok.Data;

import java.util.Date;

/**
 * @Author 徐志斌
 * @Date: 2023/7/17 22:10
 * @Version 1.0
 * @Description: 单条聊天信息
 */
@Data
public class ChatContentVO {
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 用户昵称
     */
    private String nickName;
    /**
     * 用户头像
     */
    private String avatarUrl;
    /**
     * 聊天消息
     */
    private String chatContent;
    /**
     * 发送时间
     */
    private Date createTime;
}
