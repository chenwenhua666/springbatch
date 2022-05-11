package com.plm.platform.batch.job;

import com.plm.platform.batch.entity.TestData;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @author crystal
 */
@Component
@RequiredArgsConstructor
public class DataSourceItemWriterDemo {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final DataSource dataSource;
    private final ListItemReader<TestData> simpleReader;

    @Bean
    public Job datasourceItemWriterJob() {
        return jobBuilderFactory.get("datasourceItemWriterJob")
                .start(step())
                .build();
    }

    private Step step() {
        return stepBuilderFactory.get("step")
                .<TestData, TestData>chunk(2)
                .reader(simpleReader)
                .writer(dataSourceItemWriter())
                .build();
    }

    private ItemWriter<TestData> dataSourceItemWriter() {
        // ItemWriter的实现类之一，mysql数据库数据写入使用JdbcBatchItemWriter，
        JdbcBatchItemWriter<TestData> writer = new JdbcBatchItemWriter<>();
        // 设置数据源
        writer.setDataSource(dataSource);

        String sql = "insert into TEST(id,field1,field2,field3) values (:id,:field1,:field2,:field3)";
        // 设置插入sql脚本
        writer.setSql(sql);

        // 映射TestData对象属性到占位符中的属性
        BeanPropertyItemSqlParameterSourceProvider<TestData> provider = new BeanPropertyItemSqlParameterSourceProvider<>();
        writer.setItemSqlParameterSourceProvider(provider);
        // 设置一些额外属性
        writer.afterPropertiesSet();
        return writer;
    }

}
