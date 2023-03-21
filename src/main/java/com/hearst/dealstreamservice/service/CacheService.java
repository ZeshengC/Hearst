package com.hearst.dealstreamservice.service;

import com.hearst.dealstreamservice.model.SkuBestPrice;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author Zesheng Cai EMAIL:CAIZSHENG@GMAIL.COM
 * @create 2023-03-20 11:00 PM
 */
public class CacheService {
    private Map<Integer, SkuBestPrice> cache;


    public CacheService(Map<Integer, SkuBestPrice> cache) {
        this.cache = cache;
    }

    public void set(int skuId, SkuBestPrice skuBestPrice) {
        cache.put(skuId, skuBestPrice);
    }

    public SkuBestPrice get(int skuId) {
        if(!cache.containsKey(skuId)) return null;
        return cache.get(skuId);
    }

    public void delete(int skuId) {
        cache.remove(skuId);
    }
}
