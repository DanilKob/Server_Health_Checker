package health.checker.springmvc.model.checker;

import health.checker.springmvc.model.checker.entity.configuration.ExaminerAgentConfiguration;
import health.checker.springmvc.model.checker.entity.configuration.OverallExaminerAgentsConfiguration;

import java.util.List;

/**
 * Build {@see model.checker.ExaminerAgent} and set its configuration
 * if no configuration given build Agent on local server {@see model.checker.impl.LocalExaminerAgent}
 */
public interface ExaminerAgentFactory {
    ExaminerAgent build();

    ExaminerAgent build(ExaminerAgentConfiguration examinerAgentConfiguration);

    List<ExaminerAgent> build(OverallExaminerAgentsConfiguration overallExaminerAgentsConfiguration);
}
