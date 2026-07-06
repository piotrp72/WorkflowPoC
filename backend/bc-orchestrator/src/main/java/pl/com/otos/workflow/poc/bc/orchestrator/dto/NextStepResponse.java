package pl.com.otos.workflow.poc.bc.orchestrator.dto;

public record NextStepResponse(String applicationId, String taskId, String step) {
}

