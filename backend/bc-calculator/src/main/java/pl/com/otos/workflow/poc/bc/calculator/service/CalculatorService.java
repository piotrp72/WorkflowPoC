package pl.com.otos.workflow.poc.bc.calculator.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.com.otos.workflow.poc.bc.calculator.client.OrchestratorClient;
import pl.com.otos.workflow.poc.bc.calculator.dto.FinishCalculatorTask;
import pl.com.otos.workflow.poc.bc.calculator.dto.NextStep;

@Service("CalculatorService")
@RequiredArgsConstructor
@Slf4j
public class CalculatorService {

    private final OrchestratorClient orchestratorClient;

    public NextStep finishTask(FinishCalculatorTask request) {
        return orchestratorClient.completeCalculatorTask(request);
    }
}
