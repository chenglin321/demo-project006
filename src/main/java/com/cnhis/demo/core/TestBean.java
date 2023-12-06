package com.cnhis.demo.core;

//import org.crac.Context;
//import org.crac.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component
public class TestBean implements InitializingBean, DisposableBean {

    public static final Logger LOGGER = LoggerFactory.getLogger(TestBean.class);

    @Autowired
    DataSource dataSource;

    private Connection connection;

    @Override
    public void destroy() throws Exception {
        LOGGER.info("========================destroy");
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            LOGGER.error("", e);
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        LOGGER.info("=========================afterPropertiesSet");
        try {
            connection = dataSource.getConnection();
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            LOGGER.error("", e);
        }
    }

//    @Override
//    public void beforeCheckpoint(Context<? extends Resource> context) throws Exception {
//        if (connection != null && !connection.isClosed()) {
//            connection.close();
//        }
//    }
//
//    @Override
//    public void afterRestore(Context<? extends Resource> context) throws Exception {
//        connection = dataSource.getConnection();
//        if (connection != null && !connection.isClosed()) {
//            connection.close();
//        }
//    }
}
