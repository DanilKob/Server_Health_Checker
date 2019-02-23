package health.checker.springmvc.model.checker.impl;

import health.checker.springmvc.model.checker.ExaminerAgent;
import health.checker.springmvc.model.checker.HealthCheckOrchestrator;
import health.checker.springmvc.model.checker.entity.configuration.ExaminerAgentConfiguration;
import health.checker.springmvc.model.checker.entity.configuration.OverallServerHealthCheckConfiguration;
import health.checker.springmvc.model.checker.entity.result.HealthCheckFromAgentResult;
import health.checker.springmvc.model.checker.entity.result.OverallHealthCheckResult;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class StatusCheckOrchestratorImpl implements HealthCheckOrchestrator {

    private Map<ExaminerAgentConfiguration, ExaminerAgent> examinerAgentMap = new HashMap<>();

    @Override
    public OverallHealthCheckResult checkServers(OverallServerHealthCheckConfiguration overallServerHealthCheckConfiguration) {
        List<HealthCheckFromAgentResult> healthCheckFromAgentResults = examinerAgentMap.values()
                .stream()
                .map(examinerAgent -> examinerAgent.checkServers(overallServerHealthCheckConfiguration))
                .collect(Collectors.toList());
        OverallHealthCheckResult overallHealthCheckResult = new OverallHealthCheckResult();
        overallHealthCheckResult.setHealthCheckFromAgentResultList(healthCheckFromAgentResults);
        return overallHealthCheckResult;
    }

    @Override
    public void addExaminerAgent(ExaminerAgent examinerAgent) {
        examinerAgentMap.put(examinerAgent.getExaminerAgentConfiguration(), examinerAgent);
    }

    @Override
    public void update(ExaminerAgent examinerAgent) {
        examinerAgentMap.put(examinerAgent.getExaminerAgentConfiguration(), examinerAgent);
    }
}
