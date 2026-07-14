package pl.com.otos.workflow.poc.bc.orchestrator.kafka.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.com.otos.workflow.poc.bc.orchestrator.kafka.TaskCompletedEvent;
import pl.com.otos.workflow.poc.bc.orchestrator.kafka.payload.CalculatorPayload;
import pl.com.otos.workflow.poc.bc.orchestrator.kafka.payload.CollectorPayload;
import pl.com.otos.workflow.poc.bc.orchestrator.kafka.payload.DecisionPayload;
import pl.com.otos.workflow.poc.bc.orchestrator.service.DecisionTaskFinishedService;

@Slf4j
@RequiredArgsConstructor
@Service
public class DecisionTaskFinishedHandler {

    private DecisionTaskFinishedService decisionTaskFinishedService;

    private final ObjectMapper objectMapper;

    public void handleTaskFinished(TaskCompletedEvent event) {
        DecisionPayload decisionPayload = objectMapper.convertValue(event.getPayload(),DecisionPayload.class);
        log.info("Odebrano wiadomość z decision: process.id: {}, taskId: {}, payload: {} ", event.getProcessId(), event.getTaskId(), decisionPayload.getDecision());
        decisionTaskFinishedService.service(event.getProcessId(), event.getTaskId(), decisionPayload);
    }
}
