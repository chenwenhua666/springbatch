package com.plm.platform.batch.job;

import com.plm.platform.batch.entity.TestData;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

/**
 * @author crystal
 */
@Component
@RequiredArgsConstructor
public class FileItemReaderDemo {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job fileItemReaderJob() {
        return jobBuilderFactory.get("fileItemReaderJob2")
                .start(step())
                .build();
    }

    private Step step() {
        return stepBuilderFactory.get("step")
                .<TestData, TestData>chunk(2)
                .reader(fileItemReader())
                .writer(list -> list.forEach(System.out::println))
                .build();
    }

    private ItemReader<TestData> fileItemReader() {
        FlatFileItemReader<TestData> reader = new FlatFileItemReader<>();
        // 设置文件资源地址
        reader.setResource(new ClassPathResource("/static/file.txt"));
        // 忽略第一行
        reader.setLinesToSkip(1);

        // AbstractLineTokenizer的三个实现类之一，以固定分隔符处理行数据读取,
        // 使用默认构造器的时候，使用逗号作为分隔符，也可以通过有参构造器来指定分隔符
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();

        // 设置属性名，类似于表头
        tokenizer.setNames("id", "field1", "field2", "field3");

        // 将每行数据转换为TestData对象
        DefaultLineMapper<TestData> mapper = new DefaultLineMapper<>();
        // 设置LineTokenizer
        mapper.setLineTokenizer(tokenizer);

        // 设置映射方式，即读取到的文本怎么转换为对应的POJO
        mapper.setFieldSetMapper(fieldSet -> {
            TestData data = new TestData();
            data.setId(fieldSet.readInt("id"));
            data.setField1(fieldSet.readString("field1"));
            data.setField2(fieldSet.readString("field2"));
            data.setField3(fieldSet.readString("field3"));
            return data;
        });
        reader.setLineMapper(mapper);
        return reader;
    }
}
