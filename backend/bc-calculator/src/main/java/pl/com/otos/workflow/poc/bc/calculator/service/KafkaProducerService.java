package pl.com.otos.workflow.poc.bc.calculator.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import pl.com.otos.workflow.poc.bc.calculator.dto.MessageDto;

@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, MessageDto> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, MessageDto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, String key, MessageDto message) {
        CompletableFuture<SendResult<String, MessageDto>> future =
                kafkaTemplate.send(topic, key, message);

        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Wysłano message na topic=" + topic
                        + ", partition=" + result.getRecordMetadata().partition()
                        + ", offset=" + result.getRecordMetadata().offset());
            } else {
                System.err.println("Błąd wysyłki na Kafka: " + ex.getMessage());
            }
        });
    }
}
