package com.bingo.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ElasticSearch 客户端配置
 *
 * @author 徐志斌
 */
@Configuration
public class ElasticSearchConfig {
    @Bean
    public RestHighLevelClient elasticsearchClient() {
        return new RestHighLevelClient(
                RestClient.builder(new HttpHost("101.42.13.186", 9200, "http"))
        );
    }
}