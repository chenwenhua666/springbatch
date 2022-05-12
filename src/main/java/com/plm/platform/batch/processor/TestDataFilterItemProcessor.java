package com.plm.platform.batch.processor;

import com.plm.platform.batch.entity.TestData;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author crystal
 */
@Component
public class TestDataFilterItemProcessor implements ItemProcessor<TestData, TestData> {
    @Override
    public TestData process(TestData item) throws Exception {
        if (StringUtils.isEmpty(item.getField3())) {
            return null;
        }
        return item;
    }
}
