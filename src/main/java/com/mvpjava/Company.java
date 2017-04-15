package com.mvpjava;

import java.util.HashSet;
import java.util.Set;

public class Company {
   String companyName; 
   Set<Employee> employees = new HashSet<>();
   

    public Company(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public boolean addEmployee(Employee newHire){
        return employees.add(newHire);
    }

}
