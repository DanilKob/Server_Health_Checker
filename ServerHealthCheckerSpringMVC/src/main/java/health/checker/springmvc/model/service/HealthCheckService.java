package health.checker.springmvc.model.service;

import health.checker.springmvc.model.checker.entity.result.OverallHealthCheckResult;

public interface HealthCheckService {
    OverallHealthCheckResult getHealthCheckResult();
}
