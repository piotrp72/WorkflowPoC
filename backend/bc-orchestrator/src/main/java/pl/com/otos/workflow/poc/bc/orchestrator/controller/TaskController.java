package pl.com.otos.workflow.poc.bc.orchestrator.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import pl.com.otos.workflow.poc.bc.orchestrator.dto.FinishCalculatorTask;
import pl.com.otos.workflow.poc.bc.orchestrator.dto.NextStep;
import pl.com.otos.workflow.poc.bc.orchestrator.service.TaskService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/workflow/tasks")
public class TaskController {

    @Qualifier("TaskService")
    private final TaskService taskService;

    @PostMapping("/calculator/complete")
    public NextStep completeCalculatorTask(@RequestBody FinishCalculatorTask request) {
        return taskService.completeCalculatorTaskAndGetNextTask(request.processId(), request.taskId(), request.payload());
    }


}
