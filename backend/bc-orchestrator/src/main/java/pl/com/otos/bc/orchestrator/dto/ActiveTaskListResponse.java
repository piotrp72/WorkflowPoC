package pl.com.otos.bc.orchestrator.dto;

import java.util.List;

public record ActiveTaskListResponse(List<TaskDto> taskList) {
}
