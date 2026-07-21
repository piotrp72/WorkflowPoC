package pl.com.otos.workflow.poc.bc.orchestrator.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.com.otos.workflow.poc.bc.orchestrator.dto.payload.CalculatorPayload;

@Slf4j
@RequiredArgsConstructor
@Service
public class CalculatorTaskFinishedService {

    public void service(String processId, String taskId, CalculatorPayload payload) {
        log.info("### CalculatorTaskFinishedService #####");
    }
}
