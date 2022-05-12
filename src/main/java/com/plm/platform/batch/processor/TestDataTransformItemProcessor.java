package com.plm.platform.batch.processor;

import com.plm.platform.batch.entity.TestData;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

/**
 * @author crystal
 */
@Component
public class TestDataTransformItemProcessor implements ItemProcessor<TestData, TestData> {

    @Override
    public TestData process(TestData item) throws Exception {
        item.setField1(item.getField1() + " hello");
        return item;
    }
}
