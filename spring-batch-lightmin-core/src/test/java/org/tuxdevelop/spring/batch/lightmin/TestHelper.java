package org.tuxdevelop.spring.batch.lightmin;

import org.springframework.batch.core.*;
import org.tuxdevelop.spring.batch.lightmin.admin.domain.*;
import org.tuxdevelop.spring.batch.lightmin.api.resource.common.JobParameters;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class TestHelper {

    public static Job createJob(final String jobName) {
        return new Job() {
            @Override
            public boolean isRestartable() {
                return false;
            }

            @Override
            public String getName() {
                return jobName;
            }

            @Override
            public JobParametersValidator getJobParametersValidator() {
                return null;
            }

            @Override
            public JobParametersIncrementer getJobParametersIncrementer() {
                return null;
            }

            @Override
            public void execute(final JobExecution execution) {
            }
        };
    }

    public static List<JobInstance> createJobInstances(final long count, final String jobName) {
        final List<JobInstance> jobInstances = new LinkedList<>();
        for (long i = 1; i <= count; i++) {
            final JobInstance jobInstance = new JobInstance(i, jobName);
            jobInstances.add(jobInstance);
        }
        return jobInstances;
    }

    public static JobInstance createJobInstance(final Long id, final String jobName) {
        return new JobInstance(id, jobName);
    }

    public static List<JobExecution> createJobExecutions(final long count) {
        final List<JobExecution> jobExecutions = new LinkedList<>();
        for (long i = 1; i <= count; i++) {
            final JobExecution jobExecution = createJobExecution(i);
            jobExecutions.add(jobExecution);
        }
        return jobExecutions;
    }

    public static JobExecution createJobExecution(final Long jobExecutionId) {
        return new JobExecution(jobExecutionId);
    }

    public static StepExecution createStepExecution(final String stepName, final JobExecution jobExecution) {
        return new StepExecution(stepName, jobExecution);
    }

    public static JobConfiguration createJobConfiguration(final JobListenerConfiguration jobListenerConfiguration) {
        final JobConfiguration jobConfiguration = createJobConfiguration();
        jobConfiguration.setJobListenerConfiguration(jobListenerConfiguration);
        return jobConfiguration;
    }

    public static JobConfiguration createJobConfiguration(final JobSchedulerConfiguration jobSchedulerConfiguration) {
        final JobConfiguration jobConfiguration = createJobConfiguration();
        jobConfiguration.setJobSchedulerConfiguration(jobSchedulerConfiguration);
        return jobConfiguration;
    }

    private static JobConfiguration createJobConfiguration() {
        final JobConfiguration jobConfiguration = new JobConfiguration();
        jobConfiguration.setJobName("sampleJob");
        jobConfiguration.setJobIncrementer(JobIncrementer.DATE);
        jobConfiguration.setJobParameters(new HashMap<>());
        return jobConfiguration;
    }

    public static JobSchedulerConfiguration createJobSchedulerConfiguration(final String cronExpression,
                                                                            final Long fixedDelay, final Long initialDelay, final JobSchedulerType jobSchedulerType) {
        final JobSchedulerConfiguration jobSchedulerConfiguration = new JobSchedulerConfiguration();
        jobSchedulerConfiguration.setCronExpression(cronExpression);
        jobSchedulerConfiguration.setFixedDelay(fixedDelay);
        jobSchedulerConfiguration.setInitialDelay(initialDelay);
        jobSchedulerConfiguration.setJobSchedulerType(jobSchedulerType);
        jobSchedulerConfiguration.setTaskExecutorType(TaskExecutorType.SYNCHRONOUS);
        jobSchedulerConfiguration.setSchedulerStatus(SchedulerStatus.INITIALIZED);
        return jobSchedulerConfiguration;
    }

    public static JobListenerConfiguration createJobListenerConfiguration(final String sourceFolder,
                                                                          final String pattern,
                                                                          final JobListenerType jobListenerType) {
        final JobListenerConfiguration jobListenerConfiguration = new JobListenerConfiguration();
        jobListenerConfiguration.setJobListenerType(jobListenerType);
        jobListenerConfiguration.setTaskExecutorType(TaskExecutorType.SYNCHRONOUS);
        jobListenerConfiguration.setSourceFolder(sourceFolder);
        jobListenerConfiguration.setFilePattern(pattern);
        jobListenerConfiguration.setPollerPeriod(1000L);
        jobListenerConfiguration.setListenerStatus(ListenerStatus.STOPPED);
        return jobListenerConfiguration;
    }

    public static org.tuxdevelop.spring.batch.lightmin.api.resource.admin.JobConfiguration createJobConfiguration
            (final org.tuxdevelop.spring.batch.lightmin.api.resource.admin.JobSchedulerConfiguration jobSchedulerConfiguration) {
        final org.tuxdevelop.spring.batch.lightmin.api.resource.admin.JobConfiguration jobConfiguration =
                createJobConfigurationApi();
        jobConfiguration.setJobSchedulerConfiguration(jobSchedulerConfiguration);
        return jobConfiguration;
    }

    public static org.tuxdevelop.spring.batch.lightmin.api.resource.admin.JobConfiguration createJobConfiguration
            (final org.tuxdevelop.spring.batch.lightmin.api.resource.admin.JobListenerConfiguration jobListenerConfiguration) {
        final org.tuxdevelop.spring.batch.lightmin.api.resource.admin.JobConfiguration jobConfiguration =
                createJobConfigurationApi();
        jobConfiguration.setJobListenerConfiguration(jobListenerConfiguration);
        return jobConfiguration;
    }

    private static org.tuxdevelop.spring.batch.lightmin.api.resource.admin.JobConfiguration createJobConfigurationApi
            () {
        final org.tuxdevelop.spring.batch.lightmin.api.resource.admin.JobConfiguration jobConfiguration = new org.tuxdevelop.spring.batch.lightmin.api.resource.admin.JobConfiguration();
        jobConfiguration.setJobName("sampleJob");
        jobConfiguration.setJobIncrementer(org.tuxdevelop.spring.batch.lightmin.api.resource.admin.JobIncrementer.DATE);
        jobConfiguration.setJobParameters(new JobParameters());
        return jobConfiguration;
    }


    public static org.tuxdevelop.spring.batch.lightmin.api.resource.admin.JobSchedulerConfiguration createJobSchedulerConfiguration(final String cronExpression,
                                                                                                                                    final Long fixedDelay,
                                                                                                                                    final Long initialDelay,
                                                                                                                                    final org.tuxdevelop.spring.batch.lightmin.api.resource.admin.JobSchedulerType jobSchedulerType) {
        final org.tuxdevelop.spring.batch.lightmin.api.resource.admin.JobSchedulerConfiguration jobSchedulerConfiguration = new org.tuxdevelop.spring.batch.lightmin.api.resource.admin.JobSchedulerConfiguration();
        jobSchedulerConfiguration.setCronExpression(cronExpression);
        jobSchedulerConfiguration.setFixedDelay(fixedDelay);
        jobSchedulerConfiguration.setInitialDelay(initialDelay);
        jobSchedulerConfiguration.setJobSchedulerType(jobSchedulerType);
        jobSchedulerConfiguration.setTaskExecutorType(org.tuxdevelop.spring.batch.lightmin.api.resource.admin.TaskExecutorType.SYNCHRONOUS);
        jobSchedulerConfiguration.setSchedulerStatus(org.tuxdevelop.spring.batch.lightmin.api.resource.admin.SchedulerStatus.INITIALIZED);
        return jobSchedulerConfiguration;
    }

    public static org.tuxdevelop.spring.batch.lightmin.api.resource.admin.JobListenerConfiguration createJobListenerConfiguration(final String sourceFolder,
                                                                                                                                  final String pattern,
                                                                                                                                  final org.tuxdevelop.spring.batch.lightmin.api.resource.admin.JobListenerType jobListenerType) {
        final org.tuxdevelop.spring.batch.lightmin.api.resource.admin.JobListenerConfiguration jobListenerConfiguration
                = new org.tuxdevelop.spring.batch.lightmin.api.resource.admin.JobListenerConfiguration();
        jobListenerConfiguration.setJobListenerType(jobListenerType);
        jobListenerConfiguration.setTaskExecutorType(org.tuxdevelop.spring.batch.lightmin.api.resource.admin.TaskExecutorType.SYNCHRONOUS);
        jobListenerConfiguration.setSourceFolder(sourceFolder);
        jobListenerConfiguration.setFilePattern(pattern);
        jobListenerConfiguration.setPollerPeriod(1000L);
        jobListenerConfiguration.setListenerStatus(org.tuxdevelop.spring.batch.lightmin.api.resource.admin.ListenerStatus.STOPPED);
        return jobListenerConfiguration;
    }
}
