package com.hearst.dealstreamservice.controller;

import com.hearst.dealstreamservice.repository.RetailerRepository;
import com.hearst.dealstreamservice.repository.SkuPriceRepository;
import com.hearst.dealstreamservice.repository.SkuRepository;
import com.hearst.dealstreamservice.model.SkuBestPrice;
import com.hearst.dealstreamservice.model.SkuPriceUpdate;
import com.hearst.dealstreamservice.service.CacheService;
import com.hearst.dealstreamservice.service.SkuService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @author Zesheng Cai EMAIL:CAIZSHENG@GMAIL.COM
 * @create 2023-03-20 4:35 PM
 */
@RestController
@RequestMapping("/sku-price")
public class SkuController {
    private SkuService skuService;

    public SkuController() {
        skuService = new SkuService(new SkuPriceRepository(), new SkuRepository(), new RetailerRepository(), new CacheService(new HashMap<>()));
    }

    @GetMapping("/{skuName}")
    public ResponseEntity<SkuBestPrice> getBestPrice(@PathVariable String skuName) {
        SkuBestPrice skuBestPrice = skuService.getBestPrice(skuName);
        return ResponseEntity.ok(skuBestPrice);
    }

    @PostMapping("/")
    public ResponseEntity<Void> updatePrice(@RequestBody SkuPriceUpdate skuPriceUpdate) {
        skuService.updateSkuPrice(skuPriceUpdate.skuName, skuPriceUpdate.price, skuPriceUpdate.retailerName, skuPriceUpdate.url);
        return ResponseEntity.ok().build();
    }

}
