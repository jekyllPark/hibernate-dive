package com.example.hibernate.config;

import com.example.hibernate.interceptor.HibernateStatementInspectorImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class HibernateConfig implements HibernatePropertiesCustomizer {
    @Override
    public void customize(Map<String, Object> hibernateProperties) {
        log.info("hibernate config registered.. > [{}]", this.getClass().getName());
        hibernateProperties.put(AvailableSettings.STATEMENT_INSPECTOR, HibernateStatementInspectorImpl.class);
    }
}
