package health.checker.springmvc.model.checker.entity.configuration;

import java.util.List;

/**
 * Contains all host to ping
 *
 * @see SingleServerHealthCheckTask
 */
public class OverallServerHealthCheckConfiguration {
    private List<SingleServerHealthCheckTask> singleServerHealthCheckTaskList;

    public List<SingleServerHealthCheckTask> getSingleServerHealthCheckTaskList() {
        return singleServerHealthCheckTaskList;
    }

    public void setSingleServerHealthCheckTaskList(List<SingleServerHealthCheckTask> singleServerHealthCheckTaskList) {
        this.singleServerHealthCheckTaskList = singleServerHealthCheckTaskList;
    }
}
