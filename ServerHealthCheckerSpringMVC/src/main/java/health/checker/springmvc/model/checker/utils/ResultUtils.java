package health.checker.springmvc.model.checker.utils;

import health.checker.springmvc.model.checker.entity.configuration.ExaminerAgentConfiguration;
import health.checker.springmvc.model.checker.entity.configuration.SingleServerHealthCheckTask;
import health.checker.springmvc.model.checker.entity.result.HealthCheckFromAgentResult;
import health.checker.springmvc.model.checker.entity.result.HealthCheckResultItem;
import health.checker.springmvc.model.checker.entity.result.OverallHealthCheckResult;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ResultUtils {
    public JSONObject adaptToJson(OverallHealthCheckResult overallHealthCheckResult) {
        JSONObject jsonObject = new JSONObject();

        JSONArray jsonArray = new JSONArray();

        List<JSONObject> serverResults = overallHealthCheckResult.getHealthCheckFromAgentResultList()
                .stream()
                .map(this::serverResultToJson)
                .collect(Collectors.toList());

        jsonArray.addAll(serverResults);
        jsonObject.put(JsonResponseContants.RESULT, jsonArray);
        return jsonObject;
    }


    private JSONObject serverResultToJson(HealthCheckFromAgentResult healthCheckFromAgentResult) {
        List<JSONObject> jsonObjects = healthCheckFromAgentResult.getHealthCheckResultItemList()
                .stream()
                .map(this::serverResultItemToJson)
                .collect(Collectors.toList());

        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        ExaminerAgentConfiguration agentConfiguration = healthCheckFromAgentResult.getExaminerAgentConfiguration();
        String agentIp = agentConfiguration.getHost();

        jsonArray.addAll(jsonObjects);
        jsonObject.put(JsonResponseContants.AGENT_RESULTS, jsonArray);
        jsonObject.put(JsonResponseContants.AGENT_IP, agentIp);

        return jsonObject;
    }

    private JSONObject serverResultItemToJson(HealthCheckResultItem healthCheckResultItem) {
        SingleServerHealthCheckTask singleServerHealthCheckTask = healthCheckResultItem.getSingleServerHealthCheckTask();
        String url = singleServerHealthCheckTask.getUrl().toString();
        int criticalTimeout = singleServerHealthCheckTask.getCriticalTimeout();
        int errorTimeout = singleServerHealthCheckTask.getErrorTimeout();

        int responseCode = healthCheckResultItem.getResponseCode();
        double responseTime = healthCheckResultItem.getResponseTime();
        String status = healthCheckResultItem.getResponseStatus().toString();

        JSONObject jsonObject = new JSONObject();

        jsonObject.put(JsonResponseContants.URL, url);
        jsonObject.put(JsonResponseContants.CRITICAL_TIMEOUT, criticalTimeout);
        jsonObject.put(JsonResponseContants.ERROR_TIMEOUT, errorTimeout);
        jsonObject.put(JsonResponseContants.RESPONSE_CODE, responseCode);
        jsonObject.put(JsonResponseContants.RESPONSE_TIME, responseTime);
        jsonObject.put(JsonResponseContants.STATUS, status);

        return jsonObject;
    }
}
