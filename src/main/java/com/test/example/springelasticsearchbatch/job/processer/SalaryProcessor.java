package com.test.example.springelasticsearchbatch.job.processer;

import com.test.example.springelasticsearchbatch.entity.Employee;
import com.test.example.springelasticsearchbatch.entity.Salary;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.batch.item.ItemProcessor;


import static org.slf4j.LoggerFactory.getLogger;

/**
 * This class is a processor, it takes a Employee object then process the Employee
 * object and return salary object.
 *
 * Created by supritidan on 2017/05/11.
 */

public class SalaryProcessor implements ItemProcessor<Employee, Salary> {

    private Logger logger = getLogger(getClass());
    @Override
    public Salary process(Employee employee) throws Exception {

        Salary salary = new Salary();

//        offer.setId(car.getId());
//        offer.setAge(car.getAge());
//        offer.setMilesNumber(car.getMilesNumber());
//        offer.setModel(car.getModel());
//        offer.setPrice(car.getAge() * 100000 - car.getMilesNumber());

        logger.info("Converting : " + employee.toString() + " to " + salary.toString());

        return salary;
    }

}
