package com.bingo.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bingo.mapper.BingoTopicMapper;
import com.bingo.pojo.dto.TopicDTO;
import com.bingo.pojo.po.BingoTopic;
import com.bingo.pojo.vo.BingoTopicVO;
import com.bingo.service.BingoTopicService;
import com.bingo.store.BingoTopicStore;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 周英俊
 * @since 2023-07-01
 */
@Service
public class BingoTopicServiceImpl extends ServiceImpl<BingoTopicMapper, BingoTopic> implements BingoTopicService {

    @Autowired
    private BingoTopicStore topicStore;

    /**
     * 用户创建话题
     */
    @SneakyThrows
    @Override
    public Boolean saveTopic(TopicDTO topicDTO) {
        if (!StringUtils.isNotEmpty(topicDTO.getUserId())){
            throw new Exception("用户ID为空");
        }
        BingoTopic bingoTopic = new BingoTopic();
        BeanUtils.copyProperties(topicDTO, bingoTopic);
        Boolean isSuccess = topicStore.saveTopic(bingoTopic);
        return isSuccess;
    }

    /**
     * 用户删除话题
     */
    @Override
    public Boolean deleteTopic(Long id) {
        Boolean isSuccess = topicStore.deleteTopic(id);
        return isSuccess;
    }

    /**
     * 话题详细信息
     */
    @Override
    public BingoTopicVO topicInformation(Long topicId) {
        return null;
    }
}
