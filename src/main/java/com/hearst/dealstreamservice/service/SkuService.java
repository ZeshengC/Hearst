package com.hearst.dealstreamservice.service;

import com.hearst.dealstreamservice.repository.RetailerRepository;
import com.hearst.dealstreamservice.repository.SkuPriceRepository;
import com.hearst.dealstreamservice.repository.SkuRepository;
import com.hearst.dealstreamservice.model.Retailer;
import com.hearst.dealstreamservice.model.Sku;
import com.hearst.dealstreamservice.model.SkuBestPrice;
import com.hearst.dealstreamservice.model.SkuPrice;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author Zesheng Cai EMAIL:CAIZSHENG@GMAIL.COM
 * @create 2023-03-20 10:10 PM
 */
public class SkuService {
    private SkuPriceRepository skuPriceRepository;
    private SkuRepository skuRepository;
    private RetailerRepository retailerRepository;
    private CacheService cacheService;


    public SkuService(SkuPriceRepository skuPriceRepository, SkuRepository skuRepository, RetailerRepository retailerRepository, CacheService cacheService) {
        this.skuPriceRepository = skuPriceRepository;
        this.skuRepository = skuRepository;
        this.retailerRepository = retailerRepository;
        this.cacheService = cacheService;
    }

    public void updateSkuPrice(String skuName, double price, String retailerName, String url) {
        Optional<Sku> optionalSku = skuRepository.getSkuBySkuName(skuName);
        if(!optionalSku.isPresent()) {
            throw new RuntimeException("Sku not found");
        }
        Sku sku = optionalSku.get();
        Optional<Retailer> optionalRetailer = retailerRepository.getRetailerByName(retailerName);
        if(!optionalRetailer.isPresent()){
            throw new RuntimeException("Retailer not found");
        }
        Retailer retailer = optionalRetailer.get();
        SkuPrice skuPrice = new SkuPrice(retailer.getId(), sku.getId(), price, LocalDateTime.now(), url);
        skuPriceRepository.save(skuPrice);
        cacheService.delete(sku.getId());
    }

    public SkuBestPrice getBestPrice(String skuName) {
        Optional<Sku> optionalSku = skuRepository.getSkuBySkuName(skuName);
        if(!optionalSku.isPresent()) {
            //todo: create a generic exception handler. and log the exception.
            throw new RuntimeException("Sku not found");
        }
        Sku sku = optionalSku.get();
        SkuBestPrice skuBestPrice = cacheService.get(sku.getId());
        if(skuBestPrice != null) {
            return skuBestPrice;
        }

        Optional<SkuPrice> optionalSkuPrice = skuPriceRepository.getBestPrice(sku.getId());
        if(!optionalSkuPrice.isPresent()) {
            throw new RuntimeException("Sku price not found");
        }
        SkuPrice skuPrice = optionalSkuPrice.get();

        Optional<Retailer> optionalRetailer = retailerRepository.getRetailerById(skuPrice.getRetailerId());
        if(!optionalRetailer.isPresent()){
            throw new RuntimeException("Retailer not found");
        }
        Retailer retailer = optionalRetailer.get();
        skuBestPrice = new SkuBestPrice(sku.getSkuName(), retailer.getName(),skuPrice.getPrice(), skuPrice.getUrl());
        cacheService.set(sku.getId(), skuBestPrice);
        return skuBestPrice;
    }


}
