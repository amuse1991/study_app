package com.crlstudy.config;

// spring application 설정

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"com.crlstudy.dao","com.crlstudy.service"})
@Import({DBConfig.class})
public class ApplicationContext {

}
