package org.neworld.springbootmvc.config;

import org.neworld.springbootmvc.util.ConditionOnProduction;
import org.neworld.springbootmvc.util.RavenListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {

    @Bean
    @ConditionOnProduction
    public RavenListener ravenListener() {
        return new RavenListener();
    }

}
