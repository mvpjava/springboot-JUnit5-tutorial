/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvpjava.it;

import com.mvpjava.Company;
import com.mvpjava.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(JUnitPlatform.class)
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class SpringWithJUnit5IT {

    @Autowired Employee employee; 
    Company company;

    @Autowired
    SpringWithJUnit5IT(Company company) {
        this.company = company;
    }
    
    @BeforeEach
    void beforeEach( @Autowired Company company) {
        this.company = company;
    }   

    @Test
    @DisplayName("Checking if DI works with @Autowired on Constructor")
    void checkResolverForConstructor() {
        assertNotNull(company);
        assertTrue(company.getCompanyName().length() > 2);
    }

    @Test
    @DisplayName("Checking if DI works with @Autowired Parameter")
    void checkParamterReolverWithAutowired(@Autowired Employee awfulEmployee) {
        assertNotNull(awfulEmployee);
        assertEquals("homer", awfulEmployee.getName());
    }

    @Test
    @DisplayName("Checking if DI works with @Qualifier and @Value Parameters")
    void checkParamterReolverWithQualifierAndValue(
            @Qualifier("mvpjava") Employee qualifiedEmployee, 
            @Value("${employee.max.salary}") float maxSalary) {
        
        assertNotNull(qualifiedEmployee);
        assertAll("Validating new Employee properties",
                () -> assertTrue(qualifiedEmployee.getName().matches("^[a-zA-Z]+$")),
                () -> assertTrue(qualifiedEmployee.getSalary() <= maxSalary)
        );
    }

    @Test
    @DisplayName("Checking that normal field DI works")
    void checkNormalSpingDI() {
        assertNotNull(employee);
        assertEquals("homer", employee.getName());
    }
}
