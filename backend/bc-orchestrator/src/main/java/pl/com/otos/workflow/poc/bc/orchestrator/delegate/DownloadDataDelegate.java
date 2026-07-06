package pl.com.otos.workflow.poc.bc.orchestrator.delegate;

import org.eximeebpms.bpm.engine.delegate.DelegateExecution;
import org.eximeebpms.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class DownloadDataDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) {
        System.out.println("Downloading data");
        execution.setVariable("firstName", "Piotr");
        execution.setVariable("lastName", "Pietrus");
    }
}