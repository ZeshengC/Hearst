package com.hearst.dealstreamservice.model;

import java.time.LocalDateTime;

/**
 * @author Zesheng Cai EMAIL:CAIZSHENG@GMAIL.COM
 * @create 2023-03-20 4:23 PM
 */
public class SkuPrice {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRetailerId() {
        return retailerId;
    }

    public void setRetailerId(int retailerId) {
        this.retailerId = retailerId;
    }

    public int getSkuId() {
        return skuId;
    }

    public void setSkuId(int skuId) {
        this.skuId = skuId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //should be annotated as an identifer. auto increment.
    private int id;
    private int retailerId;
    private int skuId;
    private double price;
    private LocalDateTime updatedTime;
    private String url;

    public SkuPrice(int retailerId, int skuId, double price, LocalDateTime updatedTime, String url) {
        this.retailerId = retailerId;
        this.skuId = skuId;
        this.price = price;
        this.updatedTime = updatedTime;
        this.url = url;
    }
}
