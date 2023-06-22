package com.bingo.kafka;

import com.alibaba.fastjson.JSON;
import com.bingo.config.RestHighLevelClientConfig;
import com.bingo.pojo.constant.ESConstant;
import com.bingo.pojo.constant.MQTopicConstant;
import com.bingo.pojo.po.BingoPost;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @Author 徐志斌
 * @Date: 2023/5/13 21:22
 * @Version 1.0
 * @Description: KafkaConsumer
 */
@Slf4j
@Component
public class KafkaConsumer {
    @Autowired
    private RestHighLevelClient esClient;

    /**
     * 保存帖子
     */
    @KafkaListener(topics = MQTopicConstant.COMMUNITY_POST_TOPIC, groupId = MQTopicConstant.POST_GROUP_ID)
    public String savePost(String message) {
        try {
            BingoPost bingoPost = JSON.parseObject(message, BingoPost.class);
            IndexRequest request = new IndexRequest(ESConstant.POST_INDEX)
                    .id(bingoPost.getId().toString())
                    .source(JSON.toJSONString(bingoPost), XContentType.JSON);
            IndexResponse response = esClient.index(request, RestHighLevelClientConfig.COMMON_OPTIONS);
            return response.getId();
        } catch (Exception e) {
            log.error("保存帖子ES数据报错：{}", e.getMessage());
            return null;
        }
    }

    /**
     * 点赞帖子
     */
    @KafkaListener(topics = MQTopicConstant.POST_LIKE_TOPIC, groupId = MQTopicConstant.POST_GROUP_ID)
    public String likePost(String message) {
        return null;
    }
}
