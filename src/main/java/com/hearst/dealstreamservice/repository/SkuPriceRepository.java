package com.hearst.dealstreamservice.repository;

import com.hearst.dealstreamservice.model.SkuPrice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * @author Zesheng Cai EMAIL:CAIZSHENG@GMAIL.COM
 * @create 2023-03-20 10:20 PM
 */
public class SkuPriceRepository {
    private List<SkuPrice> skuPrices;


    public SkuPriceRepository() {
        this.skuPrices = new ArrayList<>();
    }

    public void save(SkuPrice skuPrice) {
        //id should be auto incremented in prod
        skuPrice.setId(skuPrices.size()+1);
        this.skuPrices.add(skuPrice);
    }

    public Optional<SkuPrice> getBestPrice(int skuId) {
        //select top 1 * from tblSkuPrice where id = {skuId} order by price asc
        return skuPrices.stream().filter(s -> s.getSkuId() == skuId).min(Comparator.comparing(SkuPrice::getPrice));
    }
}
