package com.plm.platform.batch.job;

import com.plm.platform.batch.listener.*;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author crystal
 */
@Component
@RequiredArgsConstructor
public class ListenerTestJobDemo {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final MyJobExecutionListener myJobExecutionListener;
    private final MyStepExecutionListener myStepExecutionListener;
    private final MyChunkListener myChunkListener;
    private final MyItemReaderListener myItemReaderListener;
    private final MyItemProcessListener myItemProcessListener;
    private final MyItemWriterListener myItemWriterListener;

    @Bean
    public Job listenerTestJob() {
        return jobBuilderFactory.get("listenerTestJob")
                .start(step())
                .listener(myJobExecutionListener)
                .build();
    }

    private Step step() {
        return stepBuilderFactory.get("step")
                .listener(myStepExecutionListener)
                .<String, String>chunk(2)
                .faultTolerant()
                .listener(myChunkListener)
                .reader(reader())
                .listener(myItemReaderListener)
                .processor(processor())
                .listener(myItemProcessListener)
                .writer(list -> list.forEach(System.out::println))
                .listener(myItemWriterListener)
                .build();
    }

    private ItemReader<String> reader() {
        List<String> data = Arrays.asList("java", "c++", "javascript", "python");
        return new SimpleReader(data);
    }

    private ItemProcessor<String, String> processor() {
        return item -> item + " language";
    }

    class SimpleReader implements ItemReader<String> {
        private Iterator<String> iterator;

        public SimpleReader(List<String> data) {
            this.iterator = data.iterator();
        }

        @Override
        public String read() {
            return iterator.hasNext() ? iterator.next() : null;
        }
    }

}
