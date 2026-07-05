package pl.com.otos.bc.orchestrator.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import pl.com.otos.bc.orchestrator.dto.CompleteDefineAmountTaskRequest;
import pl.com.otos.bc.orchestrator.dto.CompleteTaskResponse;
import pl.com.otos.bc.orchestrator.service.TaskService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/workflow/tasks")
public class TaskController {

    @Qualifier("TaskService")
    private final TaskService taskService;

    @PostMapping("/{taskId}/complete")
    public CompleteTaskResponse completeTask(@PathVariable String taskId, @RequestBody CompleteDefineAmountTaskRequest request) {
        return taskService.completeTask(taskId, request);
    }
}
