package pl.com.otos.workflow.poc.bc.orchestrator.kafka;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import pl.com.otos.workflow.poc.bc.orchestrator.kafka.handler.CalculatorTaskFinishedHandler;
import pl.com.otos.workflow.poc.bc.orchestrator.kafka.handler.CollectorTaskFinishedHandler;
import pl.com.otos.workflow.poc.bc.orchestrator.kafka.handler.DecisionTaskFinishedHandler;


@Slf4j
@RequiredArgsConstructor
@Service
public class TaskCompletedConsumer {

    private final CalculatorTaskFinishedHandler calculatorTaskFinishedHandler;
    private final CollectorTaskFinishedHandler collectorTaskFinishedHandler;
    private final DecisionTaskFinishedHandler decisionTaskFinishedHandler;

    @KafkaListener(
            topics = "task.completed",
            groupId = "orchestrator-group",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void onMessage(TaskCompletedEvent event) {
        switch (event.getSender()) {
            case "calculator" -> calculatorTaskFinishedHandler.handleTaskFinished(event);
            case "collector" -> collectorTaskFinishedHandler.handleTaskFinished(event);
            case "decision" -> decisionTaskFinishedHandler.handleTaskFinished(event);
            default -> throw new IllegalArgumentException("Unknown sender: " + event.getSender());
        }
    }
}
