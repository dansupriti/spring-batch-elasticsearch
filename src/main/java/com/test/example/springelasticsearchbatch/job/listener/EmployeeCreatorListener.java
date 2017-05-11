package com.test.example.springelasticsearchbatch.job.listener;

import com.test.example.springelasticsearchbatch.entity.Employee;
import com.test.example.springelasticsearchbatch.repository.EmployeeRepository;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by supritidan on 2017/05/11.
 */
@Component
public class EmployeeCreatorListener  extends JobExecutionListenerSupport {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void beforeJob(JobExecution jobExecution) {

        employeeRepository.save(new Employee("1", "Employee1", "A", 10, 34));
        employeeRepository.save(new Employee("2", "Employee2", "A", 12, 36));

        employeeRepository.save(new Employee("3", "Employee3", "B", 5, 27));
        employeeRepository.save(new Employee("4", "Employee4", "A", 5, 27));
        employeeRepository.save(new Employee("5", "Employee5", "c", 5, 30));

    }

}

