package com.hearst.dealstreamservice.service;

import com.hearst.dealstreamservice.model.SkuBestPrice;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Zesheng Cai EMAIL:CAIZSHENG@GMAIL.COM
 * @create 2023-03-21 10:45 AM
 */
public class CacheServiceTests {
    private CacheService classToTest;

    @Before
    public void setUp() {
        Map<Integer, SkuBestPrice> cache = new HashMap<>();
        cache.put(1, new SkuBestPrice("abc123", "rn123", 12.4, "https://url1.com"));
        classToTest = new CacheService(cache);

    }

    @Test
    public void testSetCache() {
        classToTest.set(2, new SkuBestPrice("abc231", "rn234", 43.2, "https://url2.com"));
        assertEquals(classToTest.get(2).getPrice(), 43.2, 0.1);
        assertEquals(classToTest.get(2).getRetailerName(), "rn234");
        assertEquals(classToTest.get(2).getSkuName(), "abc231");
        assertEquals(classToTest.get(2).getUrl(), "https://url2.com");

    }

    @Test
    public void testgetCache() {

        assertEquals(classToTest.get(1).getPrice(), 12.4, 0.1);
        assertEquals(classToTest.get(1).getRetailerName(), "rn123");
        assertEquals(classToTest.get(1).getSkuName(), "abc123");
        assertEquals(classToTest.get(1).getUrl(), "https://url1.com");

    }
}
