package pl.com.otos.workflow.poc.bc.calculator.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.com.otos.workflow.poc.bc.calculator.client.OrchestratorClient;
import pl.com.otos.workflow.poc.bc.calculator.dto.CalculatorResponse;
import pl.com.otos.workflow.poc.bc.calculator.dto.CompleteTaskResponse;
import pl.com.otos.workflow.poc.bc.calculator.dto.FinishCalculatorTaskDto;

@Service("CalculatorService")
@RequiredArgsConstructor
@Slf4j
public class CalculatorService {

    private final KafkaProducerService kafkaProducerService;
    private final OrchestratorClient orchestratorClient;

    public CalculatorResponse finishTask(FinishCalculatorTaskDto request) {
        log.info("Początek serwisu");
      //  kafkaProducerService.sendMessage("task.completed", "calculator", request);
        CompleteTaskResponse completeTaskResponse = orchestratorClient.completeCalculatorTask(request);
        return new CalculatorResponse("STATUS - >" + completeTaskResponse.status());
    }
}
