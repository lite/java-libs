package org.fssle.sample.model;

import com.google.common.base.Joiner;

public class Product {
    private String name;
    private String id;

    public Product(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return Joiner.on("-").join("product", id);
    }
}
