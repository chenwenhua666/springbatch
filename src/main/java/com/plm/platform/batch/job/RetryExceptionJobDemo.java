package com.plm.platform.batch.job;

import com.plm.platform.batch.exception.MyJobExecutionException;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

import java.util.ArrayList;
import java.util.stream.IntStream;

/**
 * @author crystal
 */
@Component
@RequiredArgsConstructor
public class RetryExceptionJobDemo {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job retryExceptionJob() {
        return jobBuilderFactory.get("retryExceptionJob")
                .start(step())
                .build();
    }

    private Step step() {
        DefaultTransactionAttribute attribute = new DefaultTransactionAttribute();
        attribute.setPropagationBehavior(Propagation.REQUIRED.value());
        attribute.setIsolationLevel(Isolation.DEFAULT.value());
        attribute.setTimeout(30);
        return stepBuilderFactory.get("step")
                .<String, String>chunk(2)
                .reader(listItemReader())
                .processor(myProcessor())
                .writer(list -> list.forEach(System.out::println))
                .faultTolerant() // 配置错误容忍
                .retry(MyJobExecutionException.class) // 配置重试的异常类型
                .retryLimit(3) // 重试3次，三次过后还是异常的话，则任务会结束，
                // 异常的次数为reader，processor和writer中的总数，这里仅在processor里演示异常重试
                //.readerIsTransactionalQueue() //消息队列数据重读
                .transactionAttribute(attribute) //手动配置事务属性
                .build();
    }

    private ListItemReader<String> listItemReader() {
        ArrayList<String> datas = new ArrayList<>();
        IntStream.range(0, 5).forEach(i -> datas.add(String.valueOf(i)));
        return new ListItemReader<>(datas);
    }

    private ItemProcessor<String, String> myProcessor() {
        return new ItemProcessor<String, String>() {
            private int count;
            @Override
            public String process(String item) throws Exception {
                System.out.println("当前处理的数据：" + item);
                if (count >= 2) {
                    return item;
                } else {
                    count++;
                    throw new MyJobExecutionException("任务处理出错");
                }
            }
        };
    }

}
