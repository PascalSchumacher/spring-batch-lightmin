package org.tuxdevelop.spring.batch.lightmin.server.configuration;

import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.tuxdevelop.spring.batch.lightmin.client.configuration.LightminClientProperties;
import org.tuxdevelop.spring.batch.lightmin.client.configuration.LightminProperties;
import org.tuxdevelop.spring.batch.lightmin.configuration.CommonSpringBatchLightminConfiguration;
import org.tuxdevelop.spring.batch.lightmin.server.admin.AdminServerService;
import org.tuxdevelop.spring.batch.lightmin.server.admin.EmbeddedAdminServerServiceBean;
import org.tuxdevelop.spring.batch.lightmin.server.event.listener.OnApplicationReadyEventEmbeddedListener;
import org.tuxdevelop.spring.batch.lightmin.server.job.EmbeddedJobServerService;
import org.tuxdevelop.spring.batch.lightmin.server.job.JobServerService;
import org.tuxdevelop.spring.batch.lightmin.server.support.RegistrationBean;
import org.tuxdevelop.spring.batch.lightmin.support.ServiceEntry;

@Configuration
@EnableConfigurationProperties(value = {LightminClientProperties.class, LightminProperties.class})
@Import(value = {CommonServerConfiguration.class, CommonSpringBatchLightminConfiguration.class})
public class EmbeddedServerConfiguration {

    @Bean
    public AdminServerService adminServerService(final ServiceEntry serviceEntry) {
        return new EmbeddedAdminServerServiceBean(serviceEntry);
    }

    @Bean
    public JobServerService jobServerService(final ServiceEntry serviceEntry) {
        return new EmbeddedJobServerService(serviceEntry);
    }

    @Bean
    public OnApplicationReadyEventEmbeddedListener onApplicationReadyEventEmbeddedListener(final RegistrationBean registrationBean,
                                                                                           final JobRegistry jobRegistry,
                                                                                           final LightminClientProperties lightminClientProperties) {
        return new OnApplicationReadyEventEmbeddedListener(registrationBean, jobRegistry, lightminClientProperties);
    }

}
