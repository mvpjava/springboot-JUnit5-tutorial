/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvpjava.unit;

import com.mvpjava.Employee;
import com.mvpjava.Role;
import com.mvpjava.it.*;
import com.mvpjava.extensions.MockitoExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import static org.junit.jupiter.api.Assertions.*;

/*
 * A simple JUnit 5 Unit Test to demo the MockitoExtension.class
 * which allows us to use a Paramter Resolver for Mocks
 */
@RunWith(JUnitPlatform.class)
@ContextConfiguration(classes = {TestConfig.class})
@ExtendWith(MockitoExtension.class)

@DisplayName("Playing with JUnit 5 Tests and Mockito")
public class MockitoResolverUnitTest {

    @Test
    @DisplayName("Checking @Mock Parameter is properly Resolved")
    void ensureDefaultRoleSetForNewEmployee(@Mock Role role) {
        assertNotNull(role);
        Employee employee = new Employee("anyone", role);
        assertEquals("anyone", employee.getName());

    }
}
