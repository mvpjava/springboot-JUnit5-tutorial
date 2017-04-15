package com.mvpjava;

public class Role {

    String roleName ;

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public Role() {
        this("minion");
    }
    
    public String getRoleName() {
        return roleName;
    }
}