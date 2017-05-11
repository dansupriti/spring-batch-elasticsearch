package com.test.example.springelasticsearchbatch.configuration;

import com.test.example.springelasticsearchbatch.job.listener.EmployeeCreatorListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * This class is the configuration class for our EmployeeSalary job.
 *
 * Created by supritidan on 2017/05/11.
 */
@Configuration
@EnableBatchProcessing
@EnableScheduling
public class EmployeeSalaryJobConfiguration {

    @Bean
    public Job employeeSalaryJob(JobBuilderFactory jobs, Step createSalaryStep, EmployeeCreatorListener employeeCreatorListener) {
        return jobs.get("employeeSalaryJob")
                .incrementer(new RunIdIncrementer())
                .listener(employeeCreatorListener)
                .flow(createSalaryStep)
                .end()
                .build();
    }

}
