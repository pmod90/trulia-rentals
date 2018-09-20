package com.example.truliarentals.impl;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

/**
 * Junit test class for {@link ParserHelper}
 */
public class ParserHelperTest {

    @Test
    public void testParserHelperReturnsOptimalPriceForKey2_2(){
        Double expectedPricePerSquareFt = 2.2892441860465116; // According to the data provided and the algorithm for calculating price per square feet.
        ParserHelper helper = new ParserHelper();
        Map<String, Double> map = helper.loadResourceMap();
        Assert.assertEquals(expectedPricePerSquareFt, map.get("2_2"));
    }

    @Test
    public void testParserHelperReturnsOptimalPriceForKey2_1(){
        Double expectedPricePerSquareFt = 1.11875; // According to the data provided and the algorithm for calculating price per square feet.
        ParserHelper helper = new ParserHelper();
        Map<String, Double> map = helper.loadResourceMap();
        Assert.assertEquals(expectedPricePerSquareFt, map.get("2_1"));
    }

    @Test
    public void testParserHelperReturnsOptimalPriceForKey1_1(){
        Double expectedPricePerSquareFt = 2.7883781439722464; // According to the data provided and the algorithm for calculating price per square feet.
        ParserHelper helper = new ParserHelper();
        Map<String, Double> map = helper.loadResourceMap();
        Assert.assertEquals(expectedPricePerSquareFt, map.get("1_1"));
    }

    @Test
    public void testParserHelperReturnsOptimalPriceForKey2_3(){
        Double expectedPricePerSquareFt = 1.9542994588093807; // According to the data provided and the algorithm for calculating price per square feet.
        ParserHelper helper = new ParserHelper();
        Map<String, Double> map = helper.loadResourceMap();
        Assert.assertEquals(expectedPricePerSquareFt, map.get("2_3"));
    }

}
