package pl.com.otos.workflow.poc.bc.orchestrator.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.com.otos.workflow.poc.bc.orchestrator.dto.payload.CollectorPayload;

@Slf4j
@RequiredArgsConstructor
@Service
public class CollectorTaskFinishedService {

    public void service(String processId, String taskId, CollectorPayload payload) {
        log.info("### CollectorTaskFinishedService #####");
    }
}
