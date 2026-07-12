package pl.com.otos.workflow.poc.bc.calculator.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.com.otos.workflow.poc.bc.calculator.dto.CalculatorResponse;
import pl.com.otos.workflow.poc.bc.calculator.dto.MessageDto;

@Service("CalculatorService")
@RequiredArgsConstructor
@Slf4j
public class CalculatorService {

    private final KafkaProducerService kafkaProducerService;

    public CalculatorResponse completeTask(MessageDto request) {
        kafkaProducerService.sendMessage("task.completed", "calculator", request);
        return new CalculatorResponse("OK - >" + request);
    }
}
