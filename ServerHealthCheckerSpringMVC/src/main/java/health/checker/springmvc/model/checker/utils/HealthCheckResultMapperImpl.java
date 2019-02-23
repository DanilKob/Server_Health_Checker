package health.checker.springmvc.model.checker.utils;

import health.checker.springmvc.model.checker.entity.result.OverallHealthCheckResult;
import health.checker.springmvc.model.dto.OverallHealthCheckResultDto;
import org.springframework.stereotype.Service;

@Service
public class HealthCheckResultMapperImpl implements HealthCheckResultMapper {
    @Override
    public OverallHealthCheckResultDto convertToDto(OverallHealthCheckResult overallHealthCheckResult) {
        OverallHealthCheckResultDto overallHealthCheckResultDto = new OverallHealthCheckResultDto();
        //todo remove mock
        overallHealthCheckResultDto.setStatus("Ok");
        return overallHealthCheckResultDto;
    }
}
