package com.hearst.dealstreamservice.repository;

import com.hearst.dealstreamservice.model.Sku;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Zesheng Cai EMAIL:CAIZSHENG@GMAIL.COM
 * @create 2023-03-20 10:11 PM
 */
public class SkuRepository {
    List<Sku> skus;
    public SkuRepository() {
        skus = new ArrayList<>();
    }

    public void save(Sku sku) {
        skus.add(sku);
    }

    public Optional<Sku> getSkuBySkuName(String skuName) {
        //"select id, sku from tblSku where sku =  {skuName}"
        return skus.stream()
                .filter(s -> s.getSkuName().equals(skuName))
                .findFirst();
    }

}
