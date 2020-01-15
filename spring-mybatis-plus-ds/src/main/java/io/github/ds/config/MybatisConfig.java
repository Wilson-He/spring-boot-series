package io.github.ds.config;


import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.google.common.collect.Maps;
import com.mysql.cj.jdbc.MysqlDataSource;
import io.github.ds.ds.DataSourceType;
import io.github.ds.ds.DynamicDataSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Map;

/**
 * MybatisPlus 配置
 *
 * @author mq
 */
@EnableTransactionManagement
@Configuration
public class MybatisConfig {

    /**
     * 数据源1
     *
     * @return 默认数据源
     */
    @Bean(name = "db1")
    @ConfigurationProperties(prefix = "spring.datasource.db1")
    public DataSource db1() {
        return new MysqlDataSource();
    }

    /**
     * 数据源1
     *
     * @return 默认数据源
     */
    @Bean(name = "db2")
    @ConfigurationProperties(prefix = "spring.datasource.db2")
    public DataSource db2() {
        return new MysqlDataSource();
    }

    /**
     * 数据源1
     *
     * @return 默认数据源
     */
    @Bean(name = "db3")
    @ConfigurationProperties(prefix = "spring.datasource.db3")
    public DataSource db3() {
        return new MysqlDataSource();
    }

    /**
     * 动态数据源配置
     *
     * @return 自定义数据源
     */
    @Bean
    public DynamicDataSource dynamicDataSource(@Qualifier("db1") DataSource db1, @Qualifier("db2") DataSource db2, @Qualifier("db3") DataSource db3) {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        Map<Object, Object> targetDataSources = Maps.newHashMap();
        targetDataSources.put(DataSourceType.USER, db1);
        targetDataSources.put(DataSourceType.ORDER, db2);
        targetDataSources.put(DataSourceType.PARTY, db3);
        //添加数据源
        dynamicDataSource.setTargetDataSources(targetDataSources);
        //设置默认数据源
        dynamicDataSource.setDefaultTargetDataSource(db1);
        return dynamicDataSource;
    }

    /*   *//**
     * Mybatis 配置
     *
     * @return SqlSessionFactory
     * @throws Exception 异常
     *//*
    @Bean("sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(DynamicDataSource dynamicDataSource) throws Exception {
        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        bean.setDataSource(dynamicDataSource);
        bean.setGlobalConfig(globalConfig());
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*.xml"));
        bean.setPlugins(new Interceptor[]{paginationInterceptor(),performanceInterceptor()});
        return bean.getObject();
    }*/

    /**
     * Mybatis 配置
     *
     * @return SqlSessionFactory
     * @throws Exception 异常
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(DynamicDataSource dynamicDataSource) throws Exception {
        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        bean.setDataSource(dynamicDataSource);
        bean.setGlobalConfig(globalConfig());
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*.xml"));
        bean.setPlugins(new Interceptor[]{paginationInterceptor(), performanceInterceptor()});
        return bean.getObject();
    }

    /**
     * 分页插件
     */
    private PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    /**
     * 分页插件
     */
    private PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
    }


    public GlobalConfig globalConfig() {
        GlobalConfig.DbConfig dbConfig = new GlobalConfig.DbConfig()
                .setCapitalMode(true)
                .setIdType(IdType.AUTO)
                .setFieldStrategy(FieldStrategy.NOT_NULL);
        return new GlobalConfig()
                .setDbConfig(dbConfig);
    }
}
