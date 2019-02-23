package health.checker.springmvc.model.checker;

import health.checker.springmvc.model.checker.entity.configuration.ExaminerAgentConfiguration;
import health.checker.springmvc.model.checker.entity.configuration.OverallServerHealthCheckConfiguration;
import health.checker.springmvc.model.checker.entity.result.HealthCheckFromAgentResult;

/**
 * Ping host specified in {@see model.checker.OverallServerHealthCheckConfiguration}
 * and represent result in {@see model.checker.HealthCheckFromAgentResult}
 * Agent can be local or proxy and call remote agent server
 * Configuration of agent contains in {@see model.checker.ExaminerAgentConfiguration}
 */
public interface ExaminerAgent {
    HealthCheckFromAgentResult checkServers(OverallServerHealthCheckConfiguration overallServerHealthCheckConfiguration);

    void setExaminerAgentConfiguration(ExaminerAgentConfiguration examinerAgentConfiguration);

    ExaminerAgentConfiguration getExaminerAgentConfiguration();
}
