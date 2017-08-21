/*
*          ┌─┐       ┌─┐
*       ┌──┘ ┴───────┘ ┴──┐
*       │                 │
*       │       ───       │
*       │  ─┬┘       └┬─  │
*       │                 │
*       │       ─┴─       │
*       │                 │
*       └───┐         ┌───┘
*           │         │
*           │         │
*           │         │
*           │         └──────────────┐
*           │                        │
*           │                        ├─┐
*           │                        ┌─┘    
*           │                        │
*           └─┐  ┐  ┌───────┬──┐  ┌──┘         
*             │ ─┤ ─┤       │ ─┤ ─┤         
*             └──┴──┘       └──┴──┘ 
*                 神兽保佑 
*                 代码无BUG! 
*/

package com.sunday.learn.config.datasource;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @Author : Sunday
 * @Description : 配置数据源
 * @Date : 11:12 2017/8/21
 * @Modified By :
 */
@Configuration
@MapperScan(basePackages = DataSourceCfg.PACKAGE, sqlSessionFactoryRef = "sqlSessionFactory")
public class DataSourceCfg {

    protected static final String PACKAGE = "com.sunday.learn.mapper";
    protected static final String MAPPER_LOCATION = "classpath:mapper/*.xml";

    @Autowired
    private Environment env;

    @Bean("dataSource")
    @Primary
    public DataSource dataSource() {
        Properties properties = new Properties();
        properties.put("driverClassName", env.getProperty("spring.datasource.driver"));
        properties.put("url", env.getProperty("spring.datasource.url"));
        properties.put("username", env.getProperty("spring.datasource.username"));
        properties.put("password", env.getProperty("spring.datasource.password"));
        properties.put("filters", env.getProperty("spring.datasource.filters"));
        DataSource dataSource = null;
        try {
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;
    }


    @Bean("TransactionManager")
    @Primary
    public DataSourceTransactionManager TransactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean("sqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        //分页
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("dialect", "mysql");
        properties.setProperty("reasonable", "false");
        properties.setProperty("pageSizeZero", "true");
        pageHelper.setProperties(properties);
        sqlSessionFactoryBean.setPlugins(new Interceptor[]{pageHelper});

        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(DataSourceCfg.MAPPER_LOCATION));
        return sqlSessionFactoryBean.getObject();
    }

}
