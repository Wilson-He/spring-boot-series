package io.wilson.sharding.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.mysql.cj.jdbc.Driver;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.config.masterslave.MasterSlaveRuleConfiguration;
import org.apache.shardingsphere.shardingjdbc.api.MasterSlaveDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author Wilson
 * @since 2020/1/14
 **/
@Configuration
@Slf4j
public class ShardingConfig {
    @PostConstruct
    public void init() {
        log.info("ShardingConfig init complete...");
    }

/*    @Bean
    @Lazy
    public MasterSlaveRuleConfiguration masterSlaveRuleConfiguration() {
        log.info("MasterSlaveRuleConfiguration init");
        return new MasterSlaveRuleConfiguration("ds1_master_slave", "ds1", Arrays.asList("ds1_slave"));
    }*/

/*    @Bean
    public DataSource dataSource() throws SQLException {
        // 配置真实数据源
        Map<String, DataSource> dataSourceMap = new HashMap<>();

        // 配置主库
        DruidDataSource masterDataSource = new DruidDataSource();
        masterDataSource.setDriverClassName(Driver.class.getCanonicalName());
        masterDataSource.setUrl("jdbc:mysql://localhost:3306/order_0");
        masterDataSource.setUsername("root");
        masterDataSource.setPassword("tiger");
        dataSourceMap.put("ds0_master", masterDataSource);

        DruidDataSource slaveDataSource1 = new DruidDataSource();
        masterDataSource.setDriverClassName(Driver.class.getCanonicalName());
        slaveDataSource1.setUrl("jdbc:mysql://localhost:3306/order_1");
        slaveDataSource1.setUsername("root");
        slaveDataSource1.setPassword("tiger");
        dataSourceMap.put("ds0_slave", slaveDataSource1);

        // 配置读写分离规则
        MasterSlaveRuleConfiguration masterSlaveRuleConfig = new MasterSlaveRuleConfiguration("ds_master_slave", "ds0_master", Arrays.asList("ds0_slave"));

        // 获取数据源对象
        Properties properties = new Properties();
        properties.put("sql.show", true);
        return MasterSlaveDataSourceFactory.createDataSource(dataSourceMap, masterSlaveRuleConfig, properties);
    }*/
}
