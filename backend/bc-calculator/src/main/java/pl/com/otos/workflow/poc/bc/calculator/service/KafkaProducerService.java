package pl.com.otos.workflow.poc.bc.calculator.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import pl.com.otos.workflow.poc.bc.calculator.dto.CalculatorRequest;

@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, CalculatorRequest> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, CalculatorRequest> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, String key, CalculatorRequest message) {
        CompletableFuture<SendResult<String, CalculatorRequest>> future =
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
