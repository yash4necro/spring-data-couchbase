package com.xyzcorp.employee.configuration;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.Collection;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;

import static com.xyzcorp.employee.utils.constants.*;

@Configuration
public class CouchbaseConfiguration extends AbstractCouchbaseConfiguration {
    Cluster cluster = Cluster.connect(getConnectionString(), getUserName(), getPassword());
    Bucket bucket = cluster.bucket(getBucketName());
    Collection collection = bucket.defaultCollection();

    public Cluster getCluster() {
        return cluster;
    }

    public Bucket getBucket() {
        return bucket;
    }

    public Collection getCollection() {
        return collection;
    }
    @Override
    public String getConnectionString() {
        return CONNECTION_STRING;
    }

    @Override
    public String getUserName() {
        return USER_NAME;
    }

    @Override
    public String getPassword() {
        return PASSWORD;
    }

    @Override
    public String getBucketName() {
        return BUCKET;
    }
}
