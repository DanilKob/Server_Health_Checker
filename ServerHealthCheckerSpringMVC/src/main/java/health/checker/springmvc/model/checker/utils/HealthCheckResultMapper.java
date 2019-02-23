package health.checker.springmvc.model.checker.utils;

import health.checker.springmvc.model.checker.entity.result.OverallHealthCheckResult;
import health.checker.springmvc.model.dto.OverallHealthCheckResultDto;

public interface HealthCheckResultMapper {
    OverallHealthCheckResultDto convertToDto(OverallHealthCheckResult overallHealthCheckResult);
}
