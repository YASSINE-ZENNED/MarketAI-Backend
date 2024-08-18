package com.MarketAI.Config;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KLafkaTopic {

    @Bean
    public NewTopic testTopic() {
        return new NewTopic("test", 1, (short) 1);
    }
}
