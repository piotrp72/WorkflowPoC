package pl.com.otos.workflow.poc.bc.orchestrator.kafka;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Map;

@RequiredArgsConstructor
@Getter
@Setter
public class TaskCompletedEvent {
    String sender;
    String processId;
    String taskId;
    Map<String, Object> payload;
}
