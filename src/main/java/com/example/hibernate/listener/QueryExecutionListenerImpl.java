package com.example.hibernate.listener;

import com.zaxxer.hikari.pool.HikariProxyPreparedStatement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.ttddyy.dsproxy.ExecutionInfo;
import net.ttddyy.dsproxy.QueryInfo;
import net.ttddyy.dsproxy.listener.QueryExecutionListener;
import net.ttddyy.dsproxy.proxy.SimpleResultSetProxyLogic;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class QueryExecutionListenerImpl implements QueryExecutionListener {
    @Override
    public void beforeQuery(ExecutionInfo execInfo, List<QueryInfo> queryInfoList) {
    }

    @Override
    public void afterQuery(ExecutionInfo execInfo, List<QueryInfo> queryInfoList) {
        HikariProxyPreparedStatement core = (HikariProxyPreparedStatement) execInfo.getStatement();
        log.info("core -> {}", core);
    }
}