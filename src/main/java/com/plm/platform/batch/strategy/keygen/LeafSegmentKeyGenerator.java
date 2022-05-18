package com.plm.platform.batch.strategy.keygen;

import com.google.common.base.Preconditions;
import com.plm.platform.batch.service.impl.SegmentService;
import lombok.Getter;
import lombok.Setter;
import org.apache.shardingsphere.spi.keygen.ShardingKeyGenerator;
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
public final class LeafSegmentKeyGenerator implements ShardingKeyGenerator, ApplicationContextAware {

    private static SegmentService segmentService;

    @Getter
    @Setter
    private Properties properties = new Properties();

    @Override
    public String getType() {
        return "leafSegment";
    }

    @Override
    public synchronized Comparable<?> generateKey() {
        return segmentService.getId(getBizTag()).getId();
    }

    private String getBizTag() {
        String result = properties.getProperty("biz-tag", "leaf-segment-test");
        Preconditions.checkArgument(!StringUtils.isEmpty(result));
        return result;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        segmentService = applicationContext.getBean(SegmentService.class);
    }
}
