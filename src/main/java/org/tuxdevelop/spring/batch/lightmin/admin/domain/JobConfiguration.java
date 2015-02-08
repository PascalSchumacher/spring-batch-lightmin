package org.tuxdevelop.spring.batch.lightmin.admin.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

@Data
public class JobConfiguration extends AbstractConfiguration implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long jobConfigurationId;
    private String jobName;
    private JobSchedulerConfiguration jobSchedulerConfiguration;
    private Map<String, Object> jobParameters;
    private JobIncrementer jobIncrementer;

    public void validateForSave() {
        if (jobConfigurationId != null) {
            throwExceptionAndLogError("jobConfigurationId must not be set for save");
        }
        validateCommon();
    }

    public void validateForUpdate() {
        if (jobConfigurationId == null) {
            throwExceptionAndLogError("jobConfigurationId must not be null for update");
        }
        validateCommon();
    }

    private void validateCommon() {
        if (jobName == null) {
            throwExceptionAndLogError("jobName must not be null");
        }
        if (jobSchedulerConfiguration == null) {
            throwExceptionAndLogError("jobSchedulerConfiguration must not be null");
        } else {
            jobSchedulerConfiguration.validate();
        }
    }


}