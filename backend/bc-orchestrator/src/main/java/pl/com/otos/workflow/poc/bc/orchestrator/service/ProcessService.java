package pl.com.otos.workflow.poc.bc.orchestrator.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.eximeebpms.bpm.engine.RuntimeService;
import org.eximeebpms.bpm.engine.TaskService;
import org.eximeebpms.bpm.engine.runtime.ProcessInstance;
import org.eximeebpms.bpm.engine.task.Task;
import org.springframework.stereotype.Service;
import pl.com.otos.workflow.poc.bc.orchestrator.dto.ActiveTaskListResponse;
import pl.com.otos.workflow.poc.bc.orchestrator.dto.NextStepResponse;
import pl.com.otos.workflow.poc.bc.orchestrator.dto.StartProcessResponse;
import pl.com.otos.workflow.poc.bc.orchestrator.dto.TaskDto;
import java.util.List;
import java.util.stream.Collectors;

@Service("ProcessService")
@RequiredArgsConstructor
@Slf4j
public class ProcessService {

    private final RuntimeService workflowEngineRuntimeService;
    private final TaskService workflowEngineTaskService;
    private static final String PROCESS_KEY = "CreditProcess";

    public StartProcessResponse startProcess() {
        ProcessInstance instance =
                workflowEngineRuntimeService.startProcessInstanceByKey(
                        PROCESS_KEY
                );
        log.info("Starting process {}", instance.getProcessInstanceId());
        return new StartProcessResponse(instance.getProcessInstanceId());
    }

    public ActiveTaskListResponse getActiveTasksByApplicationId(String processId) {
        List<TaskDto> taskList;

        taskList = workflowEngineTaskService.createTaskQuery()
                .processInstanceId(processId)
                .active()
                .list()
                .stream()
                .map(task -> new TaskDto(task.getId(),task.getTaskDefinitionKey()))
                .collect(Collectors.toList());

        return new ActiveTaskListResponse(taskList);

    }

    public NextStepResponse getNextStep(String processId) {
        Task task;
        task = workflowEngineTaskService.createTaskQuery()
                .processInstanceId(processId)
                .active()
                .singleResult();

        if (task != null) {
            return new NextStepResponse(processId, task.getId(),task.getTaskDefinitionKey());
        } else {
            return new NextStepResponse("","","ERROR");
        }
    }
}
