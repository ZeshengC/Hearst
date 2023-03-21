package com.hearst.dealstreamservice.model;

/**
 * @author Zesheng Cai EMAIL:CAIZSHENG@GMAIL.COM
 * @create 2023-03-20 11:02 PM
 */
public class SkuBestPrice {
    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public String getRetailerName() {
        return retailerName;
    }

    public void setRetailerName(String retailerName) {
        this.retailerName = retailerName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String skuName;
    private String retailerName;
    private double price;
    private String url;

    public SkuBestPrice(String skuName, String retailerName, double price, String url) {
        this.skuName = skuName;
        this.retailerName = retailerName;
        this.price = price;
        this.url = url;
    }
}
