package com.plm.platform.batch.strategy.keygen;

import com.plm.platform.batch.service.impl.SnowflakeService;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.apache.shardingsphere.sharding.spi.KeyGenerateAlgorithm;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Properties;

/**
 * @author crystal
 */
public final class LeafSnowflakeKeyGenerateAlgorithm implements KeyGenerateAlgorithm, ApplicationContextAware {

    @Getter
    @Setter
    private Properties props = new Properties();

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

    @Override
    public void init() {

    }
}
