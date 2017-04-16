/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvpjava.it;

import com.mvpjava.Company;
import com.mvpjava.Employee;
import com.mvpjava.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class TestConfig {

    @Bean
    @Primary
    Employee employee() {
        Employee homer = new Employee("homer", new Role("Doh!"));
        homer.setSalary(50000F);
        return homer;
    }

    @Bean
    Employee mvpjava() {
        Employee andy = new Employee("andy", new Role("developer"));
        andy.setSalary(100000F);
        return andy;
    }

    @Bean
    Company company() {
        return new Company("Tesla");
    }

}
