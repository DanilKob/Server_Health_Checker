package health.checker.springmvc.model.checker.entity.result;

import java.util.List;

/**
 * Contains all results {@see model.checker.HealthCheckFromAgentResult} from
 * {@see model.checker.ExaminerAgent} about hosts statuses
 */
public class OverallHealthCheckResult {
    private List<HealthCheckFromAgentResult> healthCheckFromAgentResultList;

    public List<HealthCheckFromAgentResult> getHealthCheckFromAgentResultList() {
        return healthCheckFromAgentResultList;
    }

    public void setHealthCheckFromAgentResultList(List<HealthCheckFromAgentResult> healthCheckFromAgentResultList) {
        this.healthCheckFromAgentResultList = healthCheckFromAgentResultList;
    }
}
