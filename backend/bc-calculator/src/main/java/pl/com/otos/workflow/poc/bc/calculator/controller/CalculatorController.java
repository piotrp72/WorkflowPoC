package pl.com.otos.workflow.poc.bc.calculator.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import pl.com.otos.workflow.poc.bc.calculator.dto.*;
import pl.com.otos.workflow.poc.bc.calculator.service.CalculatorService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    @PostMapping("/finish")
    public NextStep finishTask(@RequestBody CalculatorRequest request) {
        FinishCalculatorTask finishCalculatorTask = new FinishCalculatorTask("calculator",request.processId(), request.taskId(), new CalculatorPayload(request.amount()));
        return calculatorService.finishTask(finishCalculatorTask);
    }
}
