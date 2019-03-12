package com.example.templates;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(DataMaskingDialect.class)
public class TemplatesConfig {
    @Bean
    @ConditionalOnMissingBean
    DataMaskingDialect dataMaskingDialect() {
        return new DataMaskingDialect();
    }
}
