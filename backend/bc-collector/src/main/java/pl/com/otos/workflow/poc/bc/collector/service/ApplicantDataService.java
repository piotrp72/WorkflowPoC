package pl.com.otos.workflow.poc.bc.collector.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.com.otos.workflow.poc.bc.collector.dto.ApplicantDataRequest;
import pl.com.otos.workflow.poc.bc.collector.dto.ApplicantDataResponse;

@Service("ApplicantDataService")
@RequiredArgsConstructor
@Slf4j
public class ApplicantDataService {
    public ApplicantDataResponse completeTask(ApplicantDataRequest request) {
        return new ApplicantDataResponse("OK -> " + request.firstName());
    }
}
