package health.checker.springmvc.model.checker.entity.result;

import health.checker.springmvc.model.checker.entity.configuration.ExaminerAgentConfiguration;

import java.util.List;

/**
 * Result of ping all hosts done by one {@see model.checker.ExaminerAgent}
 */
public class HealthCheckFromAgentResult {
    private List<HealthCheckResultItem> healthCheckResultItemList;
    private ExaminerAgentConfiguration examinerAgentConfiguration;

    public ExaminerAgentConfiguration getExaminerAgentConfiguration() {
        return examinerAgentConfiguration;
    }

    public void setExaminerAgentConfiguration(ExaminerAgentConfiguration examinerAgentConfiguration) {
        this.examinerAgentConfiguration = examinerAgentConfiguration;
    }

    public List<HealthCheckResultItem> getHealthCheckResultItemList() {
        return healthCheckResultItemList;
    }

    public void setHealthCheckResultItemList(List<HealthCheckResultItem> healthCheckResultItemList) {
        this.healthCheckResultItemList = healthCheckResultItemList;
    }
}
