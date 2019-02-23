package health.checker.springmvc.model.checker.impl;


import health.checker.springmvc.model.checker.ExaminerAgent;
import health.checker.springmvc.model.checker.entity.configuration.ExaminerAgentConfiguration;
import health.checker.springmvc.model.checker.entity.configuration.OverallServerHealthCheckConfiguration;
import health.checker.springmvc.model.checker.entity.result.HealthCheckFromAgentResult;

public class RemoteExaminerAgent implements ExaminerAgent {
    @Override
    public void setExaminerAgentConfiguration(ExaminerAgentConfiguration examinerAgentConfiguration) {

    }

    @Override
    public ExaminerAgentConfiguration getExaminerAgentConfiguration() {
        return null;
    }

    @Override
    public HealthCheckFromAgentResult checkServers(OverallServerHealthCheckConfiguration overallServerHealthCheckConfiguration) {
        return null;
    }
}
