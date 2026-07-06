package pl.com.otos.workflow.poc.bc.orchestrator.dto;

import java.util.List;

public record ActiveTaskListResponse(List<TaskDto> taskList) {
}
