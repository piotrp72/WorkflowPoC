package pl.com.otos.workflow.poc.bc.orchestrator.dto;


import pl.com.otos.workflow.poc.bc.orchestrator.dto.payload.CalculatorPayload;

public record FinishCalculatorTaskDto(String sender, String processId, String taskId, CalculatorPayload payload) {
}
