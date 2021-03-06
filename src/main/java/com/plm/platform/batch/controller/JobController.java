package com.plm.platform.batch.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author crystal
 */
@RestController
@RequestMapping("job")
@RequiredArgsConstructor
public class JobController {

    private final Job job;
    private final JobLauncher jobLauncher;
    private final JobOperator jobOperator;

    @GetMapping("launcher/{message}")
    public String launcher(@PathVariable String message) throws Exception {
        JobParameters parameters = new JobParametersBuilder()
                .addString("message", message)
                .toJobParameters();
        // 将参数传递给任务
        jobLauncher.run(job, parameters);
        return "success";
    }

    @GetMapping("operator/{message}")
    public String operator(@PathVariable String message) throws Exception {
        // 传递任务名称，参数使用 kv方式
        jobOperator.start("job", "message=" + message);
        return "success";
    }

}
