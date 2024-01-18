package com.example.hibernate.config;

import com.example.hibernate.listener.QueryExecutionListenerImpl;
import lombok.extern.slf4j.Slf4j;
import net.ttddyy.dsproxy.support.ProxyDataSourceBuilder;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Slf4j
@Configuration
public class DataSourceConfig {
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:h2:tcp://localhost/~/test")
                .username("sa")
                .build();
    }
    @Primary
    @Bean("dataSource")
    public DataSource proxyDataSource() {
        log.info("proxyDataSource building...");
        return ProxyDataSourceBuilder
                .create(dataSource())
                .proxyResultSet()
                .listener(new QueryExecutionListenerImpl())
                .build();
    }
}

