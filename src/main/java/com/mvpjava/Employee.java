package com.mvpjava;

import java.math.BigDecimal;
import java.util.Objects;

public class Employee {

    private String name;
    Role role;
    float salary; //yes, I know I should use BigDecimal!

    public Employee(String name) {
        this.name = name;
    }

    public Employee(String name, Role role) {
        this(name);
        this.role = role;
    }

    public Employee() {
        this("not-set");
    }

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + Objects.hashCode(this.role);
        hash = 29 * hash + Float.floatToIntBits(this.salary);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;
        if (Float.floatToIntBits(this.salary) != Float.floatToIntBits(other.salary)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.role, other.role)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Employee{" + "name=" + name + ", role=" + role + ", salary=" + salary + '}';
    }
    
    

}
