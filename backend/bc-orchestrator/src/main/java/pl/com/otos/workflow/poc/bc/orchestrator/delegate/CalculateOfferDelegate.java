package pl.com.otos.workflow.poc.bc.orchestrator.delegate;


import org.eximeebpms.bpm.engine.delegate.DelegateExecution;
import org.eximeebpms.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class CalculateOfferDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) {
        System.out.println("Calculating offer");
        execution.setVariable("offerAmount",20000);
        execution.setVariable("installmentAmount",20000);
    }
}