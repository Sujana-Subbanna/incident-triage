package io.github.sujanasubbanna.incidenttriage.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import static io.github.sujanasubbanna.incidenttriage.common.KafkaConstants.INCIDENT_CREATED_TOPIC;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic incidentTopic(){
        return TopicBuilder.name(INCIDENT_CREATED_TOPIC).partitions(1).replicas(1).build();
    }

}
