package com.plm.platform.batch.job;

import com.plm.platform.batch.entity.TestData;
import com.plm.platform.batch.processor.TestDataTransformItemProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author crystal
 */
@Component
@RequiredArgsConstructor
public class TestDataTransformItemProcessorDemo {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final ListItemReader<TestData> simpleReader;
    private final TestDataTransformItemProcessor testDataTransformItemProcessor;

    @Bean
    public Job testDataTransformItemProcessorJob() {
        return jobBuilderFactory.get("testDataTransformItemProcessorJob")
                .start(step())
                .build();
    }

    private Step step() {
        return stepBuilderFactory.get("step")
                .<TestData, TestData>chunk(2)
                .reader(simpleReader)
                .processor(testDataTransformItemProcessor)
                .writer(list -> list.forEach(System.out::println))
                .build();
    }
}
