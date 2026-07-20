package pl.com.otos.workflow.poc.bc.calculator.dto;

public record CalculatorRequest(String processId, String taskId, Double amount) {
}
