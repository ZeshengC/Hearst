package com.hearst.dealstreamservice.model;

/**
 * @author Zesheng Cai EMAIL:CAIZSHENG@GMAIL.COM
 * @create 2023-03-20 10:04 PM
 */
public class Retailer {
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //should be annotated as an identifer. auto increment.
    private int id;
    private String name;

    public Retailer(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
