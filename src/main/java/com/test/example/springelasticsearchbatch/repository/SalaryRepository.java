package com.test.example.springelasticsearchbatch.repository;

import com.test.example.springelasticsearchbatch.entity.Salary;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * This class is a repository for the Salary entity.
 * Created by supritidan on 2017/05/11.
 */

public interface SalaryRepository extends ElasticsearchRepository<Salary, String> {
}
