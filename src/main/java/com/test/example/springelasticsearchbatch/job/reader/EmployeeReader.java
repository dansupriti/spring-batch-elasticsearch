package com.test.example.springelasticsearchbatch.job.reader;

import com.test.example.springelasticsearchbatch.entity.Employee;
import com.test.example.springelasticsearchbatch.repository.EmployeeRepository;
import org.springframework.batch.item.data.AbstractPaginatedDataItemReader;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Iterator;

import static org.springframework.util.ClassUtils.getShortName;

/**
 * This class reads Employee data from the elasticsearch database
 * and returns them. The doPageRead method is called several times until it returns null.
 *
 * Created by supritidan on 2017/05/11.
 */
@Component
public class EmployeeReader extends AbstractPaginatedDataItemReader<Employee> implements InitializingBean {

    private Pageable carPageable;

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostConstruct
    public void init() {
        setName(getShortName(getClass()));
        // by default 100 Employees are returned on each call
        this.carPageable = new PageRequest(0,100);
    }

    @Override
    protected Iterator<Employee> doPageRead() {

        Page<Employee> cars = employeeRepository.findAll(this.carPageable);
        carPageable = carPageable.next();
        return cars.iterator();

    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
