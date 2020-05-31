package com.xyzcorp.employee.model;

import com.couchbase.client.core.deps.com.fasterxml.jackson.annotation.JsonAlias;
import com.couchbase.client.core.deps.com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

@Data
@JsonAutoDetect
public class Address {
    @JsonAlias("type")
    private String type;
    @JsonAlias("line")
    private String line;
    @JsonAlias("city")
    private String city;
    @JsonAlias("state")
    private String state;
    @JsonAlias("zipCode")
    private String zipCode;
}
