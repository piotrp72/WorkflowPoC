package pl.com.otos.workflow.poc.bc.orchestrator.kafka.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.com.otos.workflow.poc.bc.orchestrator.dto.payload.CalculatorPayload;
import pl.com.otos.workflow.poc.bc.orchestrator.kafka.TaskCompletedEvent;
import pl.com.otos.workflow.poc.bc.orchestrator.service.CalculatorTaskFinishedService;

@Slf4j
@RequiredArgsConstructor
@Service
public class CalculatorTaskFinishedHandler {

    CalculatorTaskFinishedService calculatorTaskFinishedService;

    private final ObjectMapper objectMapper;

    public void handleTaskFinished(TaskCompletedEvent event) {
        CalculatorPayload calculatorPayload = objectMapper.convertValue(event.getPayload(),CalculatorPayload.class);
        log.info("Odebrano wiadomość z calculator: process.id: {}, taskId: {}, payload: {} ", event.getProcessId(), event.getTaskId(), calculatorPayload.getAmount());
        calculatorTaskFinishedService.service(event.getProcessId(), event.getTaskId(), calculatorPayload);
    }
}
