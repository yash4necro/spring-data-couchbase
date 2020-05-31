package com.xyzcorp.employee.model;

import com.couchbase.client.core.deps.com.fasterxml.jackson.annotation.JsonAlias;
import com.couchbase.client.core.deps.com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

import java.util.List;

@Data
@JsonAutoDetect
public class Employee {
    @JsonAlias("employeeId")
    private String employeeId;
    @JsonAlias("employeeName")
    private String employeeName;
    @JsonAlias("department")
    private String department;
    @JsonAlias("phone")
    private List<Phone> phone;
    @JsonAlias("address")
    private List<Address> address;
}
