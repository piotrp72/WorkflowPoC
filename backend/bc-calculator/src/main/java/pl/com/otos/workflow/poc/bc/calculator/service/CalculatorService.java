package pl.com.otos.workflow.poc.bc.calculator.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.com.otos.workflow.poc.bc.calculator.dto.CalculatorResponse;
import pl.com.otos.workflow.poc.bc.calculator.dto.CalculatorRequest;

@Service("CalculatorService")
@RequiredArgsConstructor
@Slf4j
public class CalculatorService {


public CalculatorResponse completeTask(CalculatorRequest request) {
    return new CalculatorResponse("OK - >" + request.amount());
}}
