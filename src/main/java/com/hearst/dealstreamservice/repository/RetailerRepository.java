package com.hearst.dealstreamservice.repository;

import com.hearst.dealstreamservice.model.Retailer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Zesheng Cai EMAIL:CAIZSHENG@GMAIL.COM
 * @create 2023-03-20 10:22 PM
 */
public class RetailerRepository {
    private List<Retailer> retailers;

    public RetailerRepository() {
        this.retailers = new ArrayList<>();
    }

    public void save(Retailer retailer) {
        this.retailers.add(retailer);
    }

    public Optional<Retailer> getRetailerByName(String name){
        //"select id, name from tblRetailer where name =  {name}"
        return retailers.stream()
                .filter(r -> r.getName().equals(name))
                .findFirst();
    }

    public Optional<Retailer> getRetailerById(int id){
        //"select id, name from tblRetailer where id =  {id}"
        return retailers.stream()
                .filter(r -> r.getId() == id)
                .findFirst();
    }
}
