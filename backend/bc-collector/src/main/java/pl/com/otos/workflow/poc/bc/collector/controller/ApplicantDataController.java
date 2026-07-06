package pl.com.otos.workflow.poc.bc.collector.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import pl.com.otos.workflow.poc.bc.collector.dto.ApplicantDataRequest;
import pl.com.otos.workflow.poc.bc.collector.dto.ApplicantDataResponse;
import pl.com.otos.workflow.poc.bc.collector.service.ApplicantDataService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/applicant-data")
public class ApplicantDataController {

    @Qualifier("ApplicantDataService")
    private final ApplicantDataService applicantDataService;

    @PostMapping
    public ApplicantDataResponse completeTask(@RequestBody ApplicantDataRequest request) {
        return applicantDataService.completeTask(request);
    }

}

