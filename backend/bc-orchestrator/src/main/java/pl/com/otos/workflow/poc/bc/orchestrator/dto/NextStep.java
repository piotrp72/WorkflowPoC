package pl.com.otos.workflow.poc.bc.orchestrator.dto;

public record NextStep(String processId, String taskId, String nextStep) {
}

