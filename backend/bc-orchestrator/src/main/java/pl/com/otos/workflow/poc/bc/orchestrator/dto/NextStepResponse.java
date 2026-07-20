package pl.com.otos.workflow.poc.bc.orchestrator.dto;

public record NextStepResponse(String processId, String taskId, String step) {
}

