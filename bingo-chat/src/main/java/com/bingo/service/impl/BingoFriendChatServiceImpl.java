package com.bingo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bingo.mapper.BingoFriendChatMapper;
import com.bingo.pojo.dto.FriendChatDTO;
import com.bingo.pojo.po.BingoFriendChat;
import com.bingo.pojo.vo.ChatContentVO;
import com.bingo.service.BingoFriendChatService;
import com.bingo.store.BingoFriendChatStore;
import com.bingo.store.BingoUserRelationStore;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 周英俊
 * @since 2023-07-16
 */
@Service
public class BingoFriendChatServiceImpl extends ServiceImpl<BingoFriendChatMapper, BingoFriendChat> implements BingoFriendChatService {

    @Autowired
    private BingoFriendChatStore friendChatStore;
    @Autowired
    private BingoUserRelationStore relationStore;

    /**
     * 好友发送消息
     */
    @Override
    public Boolean saveFriendChat(FriendChatDTO friendChatDTO) {
        // 校验双方是否是好友


        BingoFriendChat bingoFriendChat = new BingoFriendChat();
        BeanUtils.copyProperties(friendChatDTO, bingoFriendChat);
        return friendChatStore.saveFriendChat(bingoFriendChat);
    }

    /**
     * 删除好友消息
     */
    @Override
    public Boolean deleteFriendChat(Long id) {
        return friendChatStore.deleteFriendChat(id);
    }

    /**
     * 查询用户聊天记录
     */
    @Override
    public List<ChatContentVO> getChatContentByUserId(Long userId1, Long userId2) {
        return null;
    }
}