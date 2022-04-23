package com.plm.platform.batch.configure;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author crystal
 */
@Configuration
@MapperScan("com.plm.platform.batch.mapper")
public class MybatisPlusConfigure {

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        PaginationInnerInterceptor paginationInterceptor = new PaginationInnerInterceptor();
        paginationInterceptor.setMaxLimit(500L);
        paginationInterceptor.setOverflow(false);
        paginationInterceptor.setOptimizeJoin(false);
        interceptor.addInnerInterceptor(paginationInterceptor);
        return interceptor;
    }
}
