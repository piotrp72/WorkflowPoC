package pl.com.otos.workflow.poc.bc.orchestrator.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import pl.com.otos.workflow.poc.bc.orchestrator.dto.NextStep;
import pl.com.otos.workflow.poc.bc.orchestrator.dto.StartProcessResponse;
import pl.com.otos.workflow.poc.bc.orchestrator.dto.ActiveTaskListResponse;
import pl.com.otos.workflow.poc.bc.orchestrator.service.ProcessService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/workflow/process")
public class ProcessController {

    @Qualifier("ProcessService")
    private final ProcessService processService;

    @PostMapping
    public StartProcessResponse startProcess() {
        return processService.startProcess();
    }

    @GetMapping("/{processId}/tasks")
    public ActiveTaskListResponse getActiveTasksByApplicationId(@PathVariable String processId) {
        return processService.getActiveTasksByApplicationId(processId);
    }

    @GetMapping("/{processId}/next-step")
    public NextStep getNextStep(@PathVariable("processId") String processId) {
        return processService.getNextStep(processId);
    }

}
