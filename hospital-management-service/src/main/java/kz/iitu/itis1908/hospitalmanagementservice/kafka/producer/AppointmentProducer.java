package kz.iitu.itis1908.hospitalmanagementservice.kafka.producer;

import kz.iitu.itis1908.hospitalmanagementservice.model.event.AppointmentEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class AppointmentProducer {

  @Value("${spring.kafka.topic1.name}")
  private String appointmentRequestTopic;

  @Value("${spring.kafka.topic2.name}")
  private String appointmentAcceptTopic;

  @Value("${spring.kafka.topic3.name}")
  private String appointmentFinishTopic;

  private final KafkaTemplate<Long, AppointmentEvent> kafkaTemplate;

  public void sendAppointmentRequestMessage(AppointmentEvent appointmentEvent) {
    log.info("Appointment request event => {}", appointmentEvent);

    Message<AppointmentEvent> message = MessageBuilder
        .withPayload(appointmentEvent)
        .setHeader(KafkaHeaders.TOPIC, appointmentRequestTopic)
        .build();

    kafkaTemplate.send(message);
  }

  public void sendAppointmentAcceptMessage(AppointmentEvent appointmentEvent) {
    log.info("Appointment accept event => {}", appointmentEvent);

    Message<AppointmentEvent> message = MessageBuilder
        .withPayload(appointmentEvent)
        .setHeader(KafkaHeaders.TOPIC, appointmentAcceptTopic)
        .build();

    kafkaTemplate.send(message);
  }

  public void sendAppointmentFinishMessage(AppointmentEvent appointmentEvent) {
    log.info("Appointment finish event => {}", appointmentEvent);

    Message<AppointmentEvent> message = MessageBuilder
        .withPayload(appointmentEvent)
        .setHeader(KafkaHeaders.TOPIC, appointmentFinishTopic)
        .build();

    kafkaTemplate.send(message);
  }

}
