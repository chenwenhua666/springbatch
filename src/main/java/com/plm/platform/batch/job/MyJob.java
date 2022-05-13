package com.plm.platform.batch.job;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author crystal
 */
@Component
@RequiredArgsConstructor
public class MyJob {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job job(){
        return jobBuilderFactory.get("job")
                .start(step())
                .build();
    }

    private Step step(){
        return stepBuilderFactory.get("step")
                .tasklet((stepContribution, chunkContext) -> {
                    StepExecution stepExecution = chunkContext.getStepContext().getStepExecution();
                    Map<String, JobParameter> parameters = stepExecution.getJobParameters().getParameters();
                    if (parameters.containsKey("message")) {
                        System.out.println(parameters.get("message").getValue());
                    }
                    return RepeatStatus.FINISHED;
                })
                .listener(this)
                .build();
    }
}
