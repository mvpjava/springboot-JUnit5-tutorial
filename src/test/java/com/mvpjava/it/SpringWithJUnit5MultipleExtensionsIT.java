/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvpjava.it;

import com.mvpjava.Company;
import com.mvpjava.Employee;
import com.mvpjava.extensions.MockitoExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(JUnitPlatform.class)
@SpringBootTest
@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)

public class SpringWithJUnit5MultipleExtensionsIT {

    @Test
    @DisplayName("Checking if ParameterResolver works for @Autowired and @Mock")
    void checkMultipleParameterResolvers(
            @Autowired Company company,
            @Mock Employee newHire) {
        assertTrue(company.addEmployee(newHire));
    }
}
