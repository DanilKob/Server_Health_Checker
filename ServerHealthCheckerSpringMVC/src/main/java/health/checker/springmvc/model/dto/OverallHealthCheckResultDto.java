package health.checker.springmvc.model.dto;

public class OverallHealthCheckResultDto {
    //private List<HealthCheckFromAgentResult> healthCheckFromAgentResultList;
    String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
