package com.crlstudy.config;

// spring jdbc 설정파일
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement //트랜잭션 관련 설정 수행
public class DBConfig implements TransactionManagementConfigurer {
    private String driverClassName = "com.mysql.jdbc.driver";
    private String url = "jdbc:mysql://localhost:3306/sampledb?useSSL=false";
    private String username = "jeffrey";
    private String password = "password";
    private String mapperLocations = "classpath:META-INF/mybatis/mapper/**/*.xml";

    // spring jdbc 사용을 위한 dataSource 등록
    @Bean
    public DataSource dataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);


        return dataSource;
    }

    //mybatis 세션 등록
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        //sessionFactoryBean.setConfigLocation(new ClassPathResource(mybatisConfigLocation)); //http://june0313.github.io/2018/08/11/read-resource-file-on-spring/
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocations));

        return sessionFactoryBean.getObject();
    }

    // mybatis spring 연동모듈의 핵심. 코드에서 sqlSession을 대신한다.
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
            return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return transactionManager();
    }

    @Bean
    public PlatformTransactionManager transactionManager(){
        return new DataSourceTransactionManager(dataSource());
    }
}
