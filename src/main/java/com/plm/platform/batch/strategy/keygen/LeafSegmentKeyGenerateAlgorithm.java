package com.plm.platform.batch.strategy.keygen;

import com.google.common.base.Preconditions;
import com.plm.platform.batch.service.impl.SegmentService;
import lombok.Getter;
import lombok.Setter;
import org.apache.shardingsphere.sharding.spi.KeyGenerateAlgorithm;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Properties;

/**
 * @author crystal
 */
@Component
public final class LeafSegmentKeyGenerateAlgorithm implements KeyGenerateAlgorithm, ApplicationContextAware {

    private static SegmentService segmentService;

    private volatile String bizTag;

    @Getter
    @Setter
    private Properties properties = new Properties();

    @Override
    public String getType() {
        return "leafSegment";
    }

    @Override
    public synchronized Comparable<?> generateKey() {
        return segmentService.getId(bizTag).getId();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        segmentService = applicationContext.getBean(SegmentService.class);
    }

    @Override
    public void init() {
        bizTag = getProps().getProperty("biz-tag", "leaf-segment-test");
        Preconditions.checkArgument(!StringUtils.isEmpty(bizTag));
    }
}
