package com.hearst.dealstreamservice.model;

/**
 * @author Zesheng Cai EMAIL:CAIZSHENG@GMAIL.COM
 * @create 2023-03-20 10:06 PM
 */
public class Sku {
    public Sku(int id, String sku) {
        this.id = id;
        this.skuName = sku;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = this.skuName;
    }

    //should be annotated as an identifer. auto increment.
    private int id;
    private String skuName;

}
