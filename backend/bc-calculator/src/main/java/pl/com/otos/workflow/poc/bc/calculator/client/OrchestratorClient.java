package pl.com.otos.workflow.poc.bc.calculator.client;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.com.otos.workflow.poc.bc.calculator.dto.FinishCalculatorTask;
import pl.com.otos.workflow.poc.bc.calculator.dto.NextStep;

@Slf4j
@Service
public class OrchestratorClient {

    private final RestTemplate restTemplate;
    private final String orchestratorBaseUrl;

    public OrchestratorClient(RestTemplate restTemplate,
                              @Value("${orchestrator.base-url}") String orchestratorBaseUrl) {
        this.restTemplate = restTemplate;
        this.orchestratorBaseUrl = orchestratorBaseUrl;
    }

    public NextStep completeCalculatorTask(FinishCalculatorTask request) {
        String url = orchestratorBaseUrl + "/calculator/complete";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(java.util.List.of(MediaType.APPLICATION_JSON));

        HttpEntity<FinishCalculatorTask> entity = new HttpEntity<>(request, headers);

        ResponseEntity<NextStep> response = restTemplate.postForEntity(
                url,
                entity,
                NextStep.class
        );

        return response.getBody();
    }
}

