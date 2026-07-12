package pl.com.otos.workflow.poc.bc.calculator.dto;

public record MessageDto(String sender, String processId, String taskId, CalculatorPayload payload) {
}
