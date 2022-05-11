package com.plm.platform.batch.job;

import com.plm.platform.batch.reader.MySimpleItemReader;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author crystal
 */
@Component
@RequiredArgsConstructor
public class MySimpleItemReaderDemo {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    @Bean
    public Job mySimpleItemReaderJob() {
        return jobBuilderFactory.get("mySimpleItemReaderJob")
                .start(step())
                .build();
    }

    private Step step() {
        return stepBuilderFactory.get("step")
                .<String, String>chunk(2)
                .reader(mySimpleItemReader())
                .writer(list -> list.forEach(System.out::println))
                .build();
    }

    private ItemReader<String> mySimpleItemReader() {
        List<String> data = Arrays.asList("java", "c++", "javascript", "python");
        return new MySimpleItemReader(data);
    }
}
