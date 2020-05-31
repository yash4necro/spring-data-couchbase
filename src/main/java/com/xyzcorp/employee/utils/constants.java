package com.xyzcorp.employee.utils;

public class constants {
    public static final String BUCKET = "employee";
    public static final String CONNECTION_STRING = "127.0.0.1";
    public static final String USER_NAME = "Administrator";
    public static final String PASSWORD = "qwerty12345";
    public static final String GET_QUERY = "select * from `employee` where employeeId = $id";
    public static final String DELETE_QUERY = "delete from `employee` where employeeId = $id";
}
