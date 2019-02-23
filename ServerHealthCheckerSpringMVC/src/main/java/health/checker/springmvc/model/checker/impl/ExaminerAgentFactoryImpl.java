package health.checker.springmvc.model.checker.impl;


import health.checker.springmvc.model.checker.AgentConstant;
import health.checker.springmvc.model.checker.ExaminerAgent;
import health.checker.springmvc.model.checker.ExaminerAgentFactory;
import health.checker.springmvc.model.checker.entity.configuration.ExaminerAgentConfiguration;
import health.checker.springmvc.model.checker.entity.configuration.OverallExaminerAgentsConfiguration;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ExaminerAgentFactoryImpl implements ExaminerAgentFactory {
    @Override
    public ExaminerAgent build() {
        ExaminerAgent examinerAgent = new LocalExaminerAgent();
        examinerAgent.setExaminerAgentConfiguration(this.initLocalServerConfiguration());
        return examinerAgent;
    }

    @Override
    public ExaminerAgent build(ExaminerAgentConfiguration examinerAgentConfiguration) {
        ExaminerAgent examinerAgent = new RemoteExaminerAgent();
        examinerAgent.setExaminerAgentConfiguration(examinerAgentConfiguration);
        return examinerAgent;
    }

    @Override
    public List<ExaminerAgent> build(OverallExaminerAgentsConfiguration overallExaminerAgentsConfiguration) {
        return overallExaminerAgentsConfiguration.getExaminerAgentConfigurations()
                .stream()
                .map(this::build)
                .collect(Collectors.toList());
    }

    private ExaminerAgentConfiguration initLocalServerConfiguration() {
        ExaminerAgentConfiguration examinerAgentConfiguration = new ExaminerAgentConfiguration(
                AgentConstant.LOCALHOST,
                AgentConstant.UNKNOWN_PORT,
                true
        );
        return examinerAgentConfiguration;
    }
}
