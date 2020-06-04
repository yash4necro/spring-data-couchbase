# spring-data-couchbase

This is a spring-boot project which creates an API to communicate with couchbase database for basis CRUD operations by using `spring-boot-starter-data-couchbase` implementation.

# Setting up couchbase

The easiest way to set up couchbase is by pulling it from Docker https://hub.docker.com/_/couchbase. 

Run Couchbase Server docker container
`docker run -d --name db -p 8091-8094:8091-8094 -p 11210:11210 couchbase`

We have to run this command to index our bucket
```
create primary index on `employee`
```


# Employee entity

This project aims for a use case to operate on Employees of an organization. Here is a sample Employee Document which we store on the couchbase bucket.
```
{
  "employeeId": 11,
  "employeeName": "Mr Y",
  "department": "Finance",
  "phone": [
    {
      "type": "personal",
      "value": "5678901234"
    },
    {
      "type": "home",
      "value": "8901234567"
    }
  ],
  "address": [
    {
      "type": "temporary",
      "line": "123 main street",
      "city": "abc",
      "state": "def",
      "zipCode": "123-456"
    },
    {
      "type": "permanent",
      "line": "789 main street",
      "city": "xyz",
      "state": "uvw",
      "zipCode": "246-801"
    }
  ]
}
```

