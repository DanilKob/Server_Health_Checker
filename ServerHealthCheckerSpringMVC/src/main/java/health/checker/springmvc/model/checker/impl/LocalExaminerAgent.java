package health.checker.springmvc.model.checker.impl;

import health.checker.springmvc.model.checker.ExaminerAgent;
import health.checker.springmvc.model.checker.entity.configuration.ExaminerAgentConfiguration;
import health.checker.springmvc.model.checker.entity.configuration.OverallServerHealthCheckConfiguration;
import health.checker.springmvc.model.checker.entity.configuration.SingleServerHealthCheckTask;
import health.checker.springmvc.model.checker.entity.result.HealthCheckFromAgentResult;
import health.checker.springmvc.model.checker.entity.result.HealthCheckResultItem;
import health.checker.springmvc.model.checker.entity.result.ResponseStatus;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class LocalExaminerAgent implements ExaminerAgent {

    private static final String GET_REQUEST_METHOD = "GET";
    private ExaminerAgentConfiguration examinerAgentConfiguration;

    @Override
    public ExaminerAgentConfiguration getExaminerAgentConfiguration() {
        return examinerAgentConfiguration;
    }

    @Override
    public void setExaminerAgentConfiguration(ExaminerAgentConfiguration examinerAgentConfiguration) {
        this.examinerAgentConfiguration = examinerAgentConfiguration;
    }

    @Override
    public HealthCheckFromAgentResult checkServers(OverallServerHealthCheckConfiguration overallServerHealthCheckConfiguration) {
        HealthCheckFromAgentResult healthCheckFromAgentResult = new HealthCheckFromAgentResult();
        // todo implement by Future
        List<SingleServerHealthCheckTask> singleServerHealthCheckTaskList = overallServerHealthCheckConfiguration.getSingleServerHealthCheckTaskList();
        List<HealthCheckResultItem> healthCheckResultItemList = singleServerHealthCheckTaskList
                .stream()
                .parallel()
                .map(this::ping)
                .collect(Collectors.toList());

        healthCheckFromAgentResult.setHealthCheckResultItemList(healthCheckResultItemList);
        healthCheckFromAgentResult.setExaminerAgentConfiguration(this.examinerAgentConfiguration);

        return healthCheckFromAgentResult;
    }

    private HealthCheckResultItem ping(SingleServerHealthCheckTask singleServerHealthCheckTask) {
        HealthCheckResultItem healthCheckResultItem = new HealthCheckResultItem();
        healthCheckResultItem.setSingleServerHealthCheckTask(singleServerHealthCheckTask);

        int criticalTimeout = singleServerHealthCheckTask.getCriticalTimeout();
        int errorTimeout = singleServerHealthCheckTask.getErrorTimeout();
        URL url = singleServerHealthCheckTask.getUrl();
        HttpURLConnection httpURLConnection = null;
        try {
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(errorTimeout);
            httpURLConnection.setRequestMethod(GET_REQUEST_METHOD);

            long startTime;
            long finishTime;
            double resultTime;

            startTime = System.nanoTime();
            httpURLConnection.connect();
            finishTime = System.nanoTime();

            resultTime = ((finishTime - startTime) / 1000_1000.0); // nano to milli

            int responseCode = httpURLConnection.getResponseCode();
            healthCheckResultItem.setResponseCode(responseCode);
            healthCheckResultItem.setResponseTime(resultTime);

            if (resultTime < criticalTimeout) {
                healthCheckResultItem.setResponseStatus(ResponseStatus.OK);
            } else if (resultTime < errorTimeout) {
                healthCheckResultItem.setResponseStatus(ResponseStatus.WARNING);
            } else {
                healthCheckResultItem.setResponseStatus(ResponseStatus.CRITICAL);
            }


        } catch (IOException e) {
            // todo remove stack trace
            e.printStackTrace();
            healthCheckResultItem.setResponseStatus(ResponseStatus.CRITICAL);
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
        return healthCheckResultItem;
    }
}
