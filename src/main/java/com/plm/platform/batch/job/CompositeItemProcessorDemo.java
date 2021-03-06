package com.plm.platform.batch.job;

import com.plm.platform.batch.entity.TestData;
import com.plm.platform.batch.processor.TestDataFilterItemProcessor;
import com.plm.platform.batch.processor.TestDataTransformItemProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.support.CompositeItemProcessor;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author crystal
 */
@Component
@RequiredArgsConstructor
public class CompositeItemProcessorDemo {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final ListItemReader<TestData> simpleReader;
    private final TestDataFilterItemProcessor testDataFilterItemProcessor;
    private final TestDataTransformItemProcessor testDataTransformItemProcessor;

    @Bean
    public Job compositeItemProcessorJob() {
        return jobBuilderFactory.get("compositeItemProcessorJob")
                .start(step())
                .build();
    }

    private Step step() {
        return stepBuilderFactory.get("step")
                .<TestData, TestData>chunk(2)
                .reader(simpleReader)
                .processor(compositeItemProcessor())
                .writer(list -> list.forEach(System.out::println))
                .build();
    }

    // CompositeItemProcessor组合多种中间处理器
    private CompositeItemProcessor<TestData, TestData> compositeItemProcessor() {
        CompositeItemProcessor<TestData, TestData> processor = new CompositeItemProcessor<>();
        List<ItemProcessor<TestData, TestData>> processors =
                Arrays.asList(testDataFilterItemProcessor, testDataTransformItemProcessor);
        // 代理两个processor
        processor.setDelegates(processors);
        return processor;
    }
}
