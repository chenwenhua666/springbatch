package com.plm.platform.batch.strategy.keygen;

import com.plm.platform.batch.service.impl.SnowflakeService;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.apache.shardingsphere.spi.keygen.ShardingKeyGenerator;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * @author crystal
 */
@Component
public final class LeafSnowflakeKeyGenerator implements ShardingKeyGenerator, ApplicationContextAware {

    @Getter
    @Setter
    private Properties properties = new Properties();

    private static SnowflakeService snowflakeService;

    @Override
    public String getType() {
        return "leafSnowflake";
    }

    @SneakyThrows
    @Override
    public synchronized Comparable<?> generateKey() {
        return snowflakeService.getId("leafSnowflake").getId();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        snowflakeService = applicationContext.getBean(SnowflakeService.class);
    }
}
