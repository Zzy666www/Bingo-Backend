package com.bingo.store;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bingo.pojo.po.im.BingoChatGroup;

import java.util.List;

/**
 * <p>
 * 群聊信息表 服务类
 * </p>
 *
 * @author 徐志斌
 * @since 2023-08-26
 */
public interface BingoChatGroupStore extends IService<BingoChatGroup> {

    List<BingoChatGroup> getGroupInfoByIds(List<Long> groupIds);
}
