package com.bingo.store;


import com.baomidou.mybatisplus.extension.service.IService;
import com.bingo.pojo.po.BingoFriendChat;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 周英俊
 * @since 2023-07-16
 */
public interface BingoFriendChatStore extends IService<BingoFriendChat> {
    Boolean saveFriendChat(BingoFriendChat bingoFriendChat);

    Boolean deleteFriendChat(Long id);

    List<BingoFriendChat> getContentsByRelation(String relation);
}