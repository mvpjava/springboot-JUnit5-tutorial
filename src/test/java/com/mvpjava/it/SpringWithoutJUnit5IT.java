/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvpjava.it;

import com.mvpjava.Employee;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Example of what we do not get iI JUnit 4 with Spring (Parameterized Tests)
 An example of how we can't use Parameterized Tests with just JUnit 4 with Spring
 */
@RunWith(SpringRunner.class) //alias for SpringJUnit4ClassRunner
@SpringBootTest
public class SpringWithoutJUnit5IT {
    
    @Autowired Employee employee;
    
    @org.junit.Test
    public void junit4TestWithoutParameters() {
        org.junit.Assert.assertNotNull(employee);
    }
       
    // Wont even run because signature not supported, you'll get an
    // InitializationError with message "Should have no parameters"
    //can't even @Ignore. Uncomment to see the result.
//    @org.junit.Test
//    public void junit4TestWithParameters(@Autowired Employee employeeViaParameter) {
//        org.junit.Assert.assertNotNull("JUnit 4 does not support DI in @Test input parameters with Spring!", employeeViaParameter);
//    }
}
