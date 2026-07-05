package pl.com.otos.bc.orchestrator.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.com.otos.bc.orchestrator.dto.CompleteDefineAmountTaskRequest;
import pl.com.otos.bc.orchestrator.dto.CompleteTaskResponse;

import java.util.HashMap;
import java.util.Map;

@Service("TaskService")
@RequiredArgsConstructor
@Slf4j
public class TaskService {

    private final org.eximeebpms.bpm.engine.TaskService taskService;

    public CompleteTaskResponse completeTask(String taskId, CompleteDefineAmountTaskRequest request) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("amount", request.amount());
        taskService.complete(taskId,variables);
        return new CompleteTaskResponse("OK");
    }
}
