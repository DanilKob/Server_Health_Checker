package health.checker.springmvc.controller;

import health.checker.springmvc.model.checker.entity.result.OverallHealthCheckResult;
import health.checker.springmvc.model.service.HealthCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @Autowired
    private HealthCheckService healthCheckService;

    @RequestMapping(path = "/results", method = RequestMethod.GET)
    public OverallHealthCheckResult getResults() {
        return healthCheckService.getHealthCheckResult();
    }
}
