package pl.com.otos.workflow.poc.bc.calculator.dto;

public record FinishCalculatorTask(String sender, String processId, String taskId, CalculatorPayload payload) {
}
