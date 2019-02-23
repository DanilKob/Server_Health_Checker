package health.checker.springmvc.model.dao.impl;

import health.checker.springmvc.model.checker.entity.configuration.OverallServerHealthCheckConfiguration;
import health.checker.springmvc.model.checker.entity.configuration.SingleServerHealthCheckTask;
import health.checker.springmvc.model.dao.HealthCheckConfigurationDAO;
import org.springframework.stereotype.Repository;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

@Repository("javaConfigurationManagerBean")
public class HealthCheckConfigurationDAOJavaImpl implements HealthCheckConfigurationDAO {

    private OverallServerHealthCheckConfiguration statusCheckConfiguration = initRevisionConfiguration();

    @Override
    public OverallServerHealthCheckConfiguration getConfiguration() {
        return this.statusCheckConfiguration;
    }

    @Override
    public void updateConfiguration(OverallServerHealthCheckConfiguration configuration) {

    }

    private OverallServerHealthCheckConfiguration initRevisionConfiguration() {
        OverallServerHealthCheckConfiguration healthCheckConfiguration = new OverallServerHealthCheckConfiguration();
        List<SingleServerHealthCheckTask> singleServerHealthCheckTasks = new LinkedList<>();
        SingleServerHealthCheckTask statusCheckTask = new SingleServerHealthCheckTask();

        try {
            statusCheckTask.setUrl(new URL("https://www.tutorialspoint.com/javascript/javascript_placement.htm"));
            statusCheckTask.setCriticalTimeout(500);
            statusCheckTask.setErrorTimeout(700);
            singleServerHealthCheckTasks.add(statusCheckTask);

            statusCheckTask = new SingleServerHealthCheckTask();
            statusCheckTask.setUrl(new URL("https://sitis.com.ua/about/articles/programma_1s_dlya_chaynikov/"));
            statusCheckTask.setCriticalTimeout(400);
            statusCheckTask.setErrorTimeout(600);
            singleServerHealthCheckTasks.add(statusCheckTask);

            healthCheckConfiguration.setSingleServerHealthCheckTaskList(singleServerHealthCheckTasks);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return healthCheckConfiguration;
    }
}
