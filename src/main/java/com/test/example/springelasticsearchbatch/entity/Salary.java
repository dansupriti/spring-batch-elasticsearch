package com.test.example.springelasticsearchbatch.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 *
 * This class represents a Salary entity.
 * Created by supritidan on 2017/05/11.
 */

@Data
@Document(indexName="salary", type="salary")
@Setter
public class Salary {

    @Id
    private String id;

    @Field(type = FieldType.String)
    private String name;

    @Field(type = FieldType.String)
    private String grade;

    @Field(type = FieldType.Integer)
    private int experience;

    @Field(type = FieldType.Integer)
    private int age;

    @Field(type = FieldType.Integer)
    private int salary;

    public Salary(String id, String name, String grade, int experience, int age, int salary) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.experience = experience;
        this.age = age;
        this.salary = salary;
    }
    public Salary(){}
}
