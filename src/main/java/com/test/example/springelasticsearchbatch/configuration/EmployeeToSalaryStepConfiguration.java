package com.test.example.springelasticsearchbatch.configuration;

import com.test.example.springelasticsearchbatch.entity.Employee;
import com.test.example.springelasticsearchbatch.entity.Salary;
import com.test.example.springelasticsearchbatch.job.processer.SalaryProcessor;
import com.test.example.springelasticsearchbatch.job.reader.EmployeeReader;
import com.test.example.springelasticsearchbatch.job.writer.SalaryWriter;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This class is the configuration for the "createSalary" step. It puts together the reader,
 * the processor and the writer.
 *
 * Created by supritidan on 2017/05/11.
 */
@Configuration
@EnableBatchProcessing
public class EmployeeToSalaryStepConfiguration {

    @Bean
    public Step createOffersStep(
            StepBuilderFactory stepBuilderFactory,
            @Qualifier("employeeReader") ItemReader<Employee> employeeReader,
            @Qualifier("salaryProcessor") ItemProcessor<Employee, Salary> salaryProcessor,
            @Qualifier("salaryWriter") SalaryWriter salaryWriter) {

        return stepBuilderFactory.get("createSalaryStep")
                .<Employee, Salary> chunk(10)
                .reader(employeeReader)
                .processor(salaryProcessor)
                .writer(salaryWriter)
                .build();
    }

    @Bean(name = "employeeReader")
    public ItemReader<Employee> employeeReader() {
        return new EmployeeReader();
    }

    @Bean(name = "salaryProcessor")
    public ItemProcessor<Employee, Salary> salaryProcessor() {
        return new SalaryProcessor();
    }

    @Bean(name = "salaryWriter")
    public SalaryWriter salaryWriter() {
        return new SalaryWriter();
    }


}
