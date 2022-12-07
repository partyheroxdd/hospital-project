package kz.iitu.itis1908.hospitalmanagementservice.config.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

  @Value("${spring.kafka.topic1.name}")
  private String appointmentRequestTopic;

  @Value("${spring.kafka.topic2.name}")
  private String appointmentAcceptTopic;

  @Value("${spring.kafka.topic3.name}")
  private String appointmentFinishTopic;

  @Bean
  public NewTopic appointmentRequestTopic(){
    return TopicBuilder.name(appointmentRequestTopic)
        .build();
  }

  @Bean
  public NewTopic appointmentAcceptTopic(){
    return TopicBuilder.name(appointmentAcceptTopic)
        .build();
  }

  @Bean
  public NewTopic appointmentFinishTopic(){
    return TopicBuilder.name(appointmentFinishTopic)
        .build();
  }
}
