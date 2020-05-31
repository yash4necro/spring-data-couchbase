package com.xyzcorp.employee.controller;

import com.couchbase.client.core.deps.com.fasterxml.jackson.core.JsonProcessingException;
import com.couchbase.client.core.deps.com.fasterxml.jackson.databind.ObjectMapper;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.Collection;
import com.couchbase.client.java.json.JsonObject;
import com.couchbase.client.java.query.QueryResult;
import com.xyzcorp.employee.configuration.CouchbaseConfiguration;
import com.xyzcorp.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.couchbase.client.java.query.QueryOptions.queryOptions;
import static com.xyzcorp.employee.utils.constants.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private CouchbaseConfiguration couchbaseConfiguration;

    private Collection collection;
    private Cluster cluster;
    ObjectMapper mapper = new ObjectMapper();

    /*
        gets the employee with a particular employee id
    */
    @GetMapping
    @RequestMapping("{id}")
    public Employee get(@PathVariable String id) {
        cluster = couchbaseConfiguration.getCluster();
        QueryResult result = cluster.query(GET_QUERY,
                queryOptions().parameters(JsonObject.create().put("id", id)));
        Object jsonObject = result.rowsAsObject().get(0).getObject(BUCKET).toMap();
        return mapper.convertValue(jsonObject, Employee.class);
    }

    /*
        creates the employee document
     */
    @PostMapping
    public void create(@RequestBody Employee employee) throws JsonProcessingException {
        collection = couchbaseConfiguration.getCollection();
        JsonObject json = JsonObject.fromJson(mapper.writeValueAsString(employee));
        collection.insert(String.valueOf(UUID.randomUUID()), json);
    }

    /*
        deletes the employee based on their employee id
     */
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id) {
        cluster = couchbaseConfiguration.getCluster();
        cluster.query(DELETE_QUERY,
                queryOptions().parameters(JsonObject.create().put("id", id)));
    }

    /*
        update the document based on its document id stored in the couchbase
     */
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public void update(@PathVariable String id, @RequestBody Employee employee) {
        collection = couchbaseConfiguration.getCollection();
        try {
            JsonObject jsonNew = JsonObject.fromJson(mapper.writeValueAsString(employee));
            collection.upsert(id, jsonNew);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
