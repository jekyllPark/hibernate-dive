package com.example.hibernate.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.resource.jdbc.spi.StatementInspector;
import org.springframework.stereotype.Component;

@Slf4j
public class HibernateStatementInspectorImpl implements StatementInspector {
    @Override
    public String inspect(String sql) {
        log.info("sql is [{}]", sql);
        return sql;
    }
}
