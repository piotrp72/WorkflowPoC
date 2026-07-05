package pl.com.otos.bc.orchestrator.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import pl.com.otos.bc.orchestrator.dto.NextStepResponse;
import pl.com.otos.bc.orchestrator.dto.StartProcessResponse;
import pl.com.otos.bc.orchestrator.dto.ActiveTaskListResponse;
import pl.com.otos.bc.orchestrator.service.ProcessService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/workflow")
public class ProcessController {

    @Qualifier("ProcessService")
    private final ProcessService processService;


    @PostMapping("/process")
    public StartProcessResponse startProcess() {
        return processService.startProcess();
    }

    @GetMapping("/{applicationId}/tasks")
    public ActiveTaskListResponse getActiveTasksByApplicationId(@PathVariable String applicationId) {
        return processService.getActiveTasksByApplicationId(applicationId);
    }

    @GetMapping("/{applicationId}/next-step")
    public NextStepResponse getNextStep(@PathVariable String applicationId) {
        return processService.getNextStep(applicationId);
    }

}
