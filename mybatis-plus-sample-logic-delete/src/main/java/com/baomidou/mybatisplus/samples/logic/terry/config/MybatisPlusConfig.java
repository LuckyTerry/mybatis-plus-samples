package com.baomidou.mybatisplus.samples.logic.terry.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.samples.logic.terry.injector.CustomLogicSqlInjector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisPlusConfig {

    @Bean
    public ISqlInjector sqlInjector() {
        return new CustomLogicSqlInjector();
    }
}
