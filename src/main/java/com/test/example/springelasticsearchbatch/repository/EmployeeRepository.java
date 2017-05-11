package com.test.example.springelasticsearchbatch.repository;

import com.test.example.springelasticsearchbatch.entity.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * This class is a repository for the Employee entity.
 * Created by supritidan on 2017/05/11.
 */
@Repository
public interface EmployeeRepository extends ElasticsearchRepository<Employee, String> {
}
