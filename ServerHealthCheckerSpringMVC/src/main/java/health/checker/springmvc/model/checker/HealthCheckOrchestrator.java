package health.checker.springmvc.model.checker;

import health.checker.springmvc.model.checker.entity.configuration.OverallServerHealthCheckConfiguration;
import health.checker.springmvc.model.checker.entity.result.OverallHealthCheckResult;

/**
 * Manage {@see model.checker.ExaminerAgent}
 */
public interface HealthCheckOrchestrator {
    OverallHealthCheckResult checkServers(OverallServerHealthCheckConfiguration overallServerHealthCheckConfiguration);

    void addExaminerAgent(ExaminerAgent examinerAgent);

    void update(ExaminerAgent examinerAgent);
}
