package pl.com.otos.workflow.poc.bc.orchestrator.kafka.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalculatorPayload {
    private Double amount;
}
