package health.checker.springmvc.model.service.impl;

import health.checker.springmvc.model.checker.ExaminerAgent;
import health.checker.springmvc.model.checker.ExaminerAgentFactory;
import health.checker.springmvc.model.checker.HealthCheckOrchestrator;
import health.checker.springmvc.model.checker.entity.configuration.OverallServerHealthCheckConfiguration;
import health.checker.springmvc.model.checker.entity.result.OverallHealthCheckResult;
import health.checker.springmvc.model.dao.HealthCheckConfigurationDAO;
import health.checker.springmvc.model.service.HealthCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class HealthCheckServiceImpl implements HealthCheckService {

    @Autowired
    private HealthCheckOrchestrator healthCheckOrchestrator;

    @Autowired
    private ExaminerAgentFactory examinerAgentFactory;

    @Autowired
    private HealthCheckConfigurationDAO healthCheckConfigurationDAO;

    @Override
    public OverallHealthCheckResult getHealthCheckResult() {
        OverallServerHealthCheckConfiguration configuration = healthCheckConfigurationDAO.getConfiguration();
        return healthCheckOrchestrator.checkServers(configuration);
    }

    @PostConstruct
    private void initRevisorServer() {
        ExaminerAgent localExaminerAgent = examinerAgentFactory.build();
        healthCheckOrchestrator.addExaminerAgent(localExaminerAgent);
    }

    public HealthCheckOrchestrator getHealthCheckOrchestrator() {
        return healthCheckOrchestrator;
    }

    public void setHealthCheckOrchestrator(HealthCheckOrchestrator healthCheckOrchestrator) {
        this.healthCheckOrchestrator = healthCheckOrchestrator;
    }

    public ExaminerAgentFactory getExaminerAgentFactory() {
        return examinerAgentFactory;
    }

    public void setExaminerAgentFactory(ExaminerAgentFactory examinerAgentFactory) {
        this.examinerAgentFactory = examinerAgentFactory;
    }
}
