package pl.com.otos.workflow.poc.bc.calculator.dto;

public record FinishCalculatorTaskDto(String sender, String processId, String taskId, CalculatorPayload payload) {
}
