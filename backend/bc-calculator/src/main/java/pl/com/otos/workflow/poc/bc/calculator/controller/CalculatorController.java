package pl.com.otos.workflow.poc.bc.calculator.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import pl.com.otos.workflow.poc.bc.calculator.dto.CalculatorRequest;
import pl.com.otos.workflow.poc.bc.calculator.dto.CalculatorResponse;
import pl.com.otos.workflow.poc.bc.calculator.service.CalculatorService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/calculator")
public class CalculatorController {

    @Qualifier("CalculatorService")
    private final CalculatorService calculatorService;

    @PostMapping
    public CalculatorResponse completeTask(@RequestBody CalculatorRequest request) {
        return calculatorService.completeTask(request);
    }
}
