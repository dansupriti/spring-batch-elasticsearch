package com.test.example.springelasticsearchbatch.job.writer;

import com.test.example.springelasticsearchbatch.entity.Salary;
import com.test.example.springelasticsearchbatch.repository.SalaryRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * This class writes a list of Salary into the Elasticsearch database.
 *
 * Created by supritidan on 2017/05/11.
 */

public class SalaryWriter implements ItemWriter<Salary>, InitializingBean {

    @Autowired
    private SalaryRepository salaryRepository;

    @Override
    public void afterPropertiesSet() throws Exception {}

    @Override
    public void write(List<? extends Salary> list) throws Exception {
        salaryRepository.save(list);
    }

}
