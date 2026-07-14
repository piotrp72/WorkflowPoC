package pl.com.otos.workflow.poc.bc.orchestrator.kafka.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.com.otos.workflow.poc.bc.orchestrator.kafka.TaskCompletedEvent;
import pl.com.otos.workflow.poc.bc.orchestrator.kafka.payload.CollectorPayload;
import pl.com.otos.workflow.poc.bc.orchestrator.service.CollectorTaskFinishedService;

@Slf4j
@RequiredArgsConstructor
@Service
public class CollectorTaskFinishedHandler {

    CollectorTaskFinishedService collectorTaskFinishedService;

    private final ObjectMapper objectMapper;

    public void handleTaskFinished(TaskCompletedEvent event) {
        CollectorPayload collectorPayload = objectMapper.convertValue(event.getPayload(),CollectorPayload.class);
        log.info("Odebrano wiadomość z collector: process.id: {}, taskId: {}, payload: {} ", event.getProcessId(), event.getTaskId(), collectorPayload.getFirstName());
        collectorTaskFinishedService.service(event.getProcessId(), event.getTaskId(), collectorPayload);
    }
}
