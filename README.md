# Hearst
## This project used Spring Boot framework to expose two REST apis (update-price and get-best-price)
## Schemas:
### Sku
```
public class Sku {
    //should be annotated as an identifer. auto increment.
    private int id;
    private String skuName;
}
```

### Retailer
```
public class Retailer {
    //should be annotated as an identifer. auto increment.
    private int id;
    private String name;
}
```

### SkuPrice
```
public class SkuPrice {
    //should be annotated as an identifer. auto increment.
    private int id;
    private int retailerId;
    private int skuId;
    private double price;
    private LocalDateTime updatedTime;
    private String url;
}
```
### SkuPrice is append only
