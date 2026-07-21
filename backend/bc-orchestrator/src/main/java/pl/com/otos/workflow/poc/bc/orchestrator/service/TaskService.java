package pl.com.otos.workflow.poc.bc.orchestrator.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.com.otos.workflow.poc.bc.orchestrator.dto.NextStep;
import pl.com.otos.workflow.poc.bc.orchestrator.dto.payload.CalculatorPayload;

import java.util.HashMap;
import java.util.Map;

@Service("TaskService")
@RequiredArgsConstructor
@Slf4j
public class TaskService {

    private final org.eximeebpms.bpm.engine.TaskService workflowEnfineTaskService;
    private final ProcessService processService;

    public NextStep completeCalculatorTaskAndGetNextTask(String processId, String taskId, CalculatorPayload payload) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("amount", payload.getAmount());
        workflowEnfineTaskService.complete(taskId,variables);
        return processService.getNextStep(processId);
    }
}
