package com.plm.platform.batch.job;

import com.plm.platform.batch.entity.TestData;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.json.JacksonJsonObjectMarshaller;
import org.springframework.batch.item.json.JsonFileItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author crystal
 */
@Component
@RequiredArgsConstructor
public class JsonFileItemWriterDemo {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final ListItemReader<TestData> simpleReader;

    @Bean
    public Job jsonFileItemWriterJob() throws Exception{
        return jobBuilderFactory.get("jsonFileItemWriterJob")
                .start(step())
                .build();
    }

    private Step step() throws Exception{
        return stepBuilderFactory.get("step")
                .<TestData, TestData>chunk(2)
                .reader(simpleReader)
                .writer(jsonFileItemWriter())
                .build();
    }

    private JsonFileItemWriter<TestData> jsonFileItemWriter() throws IOException {
        // 文件输出目标地址
        FileSystemResource file = new FileSystemResource("/data/file.json");
        Path path = Paths.get(file.getPath());
        if (!Files.exists(path)) {
            Files.createFile(path);
        }
        // 将对象转换为json
        JacksonJsonObjectMarshaller<TestData> marshaller = new JacksonJsonObjectMarshaller<>();
        JsonFileItemWriter<TestData> writer = new JsonFileItemWriter<>(file, marshaller);
        // 设置别名
        writer.setName("testDatasonFileItemWriter");
        return writer;
    }
}
