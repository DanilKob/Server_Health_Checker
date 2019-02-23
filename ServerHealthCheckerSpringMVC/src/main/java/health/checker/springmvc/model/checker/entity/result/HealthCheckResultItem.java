package health.checker.springmvc.model.checker.entity.result;

import health.checker.springmvc.model.checker.entity.configuration.SingleServerHealthCheckTask;

public class HealthCheckResultItem {
    private SingleServerHealthCheckTask singleServerHealthCheckTask;
    private double responseTime;
    private int responseCode;
    private ResponseStatus responseStatus;
    private String serverDescription;

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public SingleServerHealthCheckTask getSingleServerHealthCheckTask() {
        return singleServerHealthCheckTask;
    }

    public void setSingleServerHealthCheckTask(SingleServerHealthCheckTask singleServerHealthCheckTask) {
        this.singleServerHealthCheckTask = singleServerHealthCheckTask;
    }

    public double getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(double responseTime) {
        this.responseTime = responseTime;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getServerDescription() {
        return serverDescription;
    }

    public void setServerDescription(String serverDescription) {
        this.serverDescription = serverDescription;
    }
}
