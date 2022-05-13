package com.plm.platform.batch.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author crystal
 */
@Component
public class FirstJobDemo {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job firstJob() {
        return jobBuilderFactory.get("firstJob6")
                .start(step())
                .build();
    }

    private Step step() {
        return stepBuilderFactory.get("step")
                .tasklet((contribution, chunkContext) -> {
                    System.out.println("firstJob执行步骤step....");
                    return RepeatStatus.FINISHED;
                })
                //每次项目重新启动都将执行这个Step
                //.allowStartIfComplete(true)
                //仅仅运行一次
                //.startLimit(1)
                .build();
    }
}
