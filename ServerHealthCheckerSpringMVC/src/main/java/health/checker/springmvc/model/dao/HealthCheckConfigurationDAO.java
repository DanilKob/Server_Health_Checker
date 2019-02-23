package health.checker.springmvc.model.dao;

import health.checker.springmvc.model.checker.entity.configuration.OverallServerHealthCheckConfiguration;

public interface HealthCheckConfigurationDAO {
    OverallServerHealthCheckConfiguration getConfiguration();

    void updateConfiguration(OverallServerHealthCheckConfiguration configuration);
}
