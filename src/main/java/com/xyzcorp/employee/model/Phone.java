package com.xyzcorp.employee.model;

import com.couchbase.client.core.deps.com.fasterxml.jackson.annotation.JsonAlias;
import com.couchbase.client.core.deps.com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

@Data
@JsonAutoDetect
public class Phone {
    @JsonAlias("type")
    private String type;
    @JsonAlias("value")
    private String value;
}
