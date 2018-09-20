package com.example.truliarentals.impl;


import com.example.truliarentals.models.RentalRequest;
import com.example.truliarentals.models.Response;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

/**
 * Created by Yamini on 9/18/18.
 */
public class OptimalPriceRetrieverImplTest {

    @Test(expected = RuntimeException.class)
    public void testNullCriteria(){
        OptimalPriceRetrieverImpl retriever = new OptimalPriceRetrieverImpl();
        retriever.getOptimalPrice(null);
    }

    @Test(expected = RuntimeException.class)
    public void testgetOptimalthrowsException() throws Exception{
        OptimalPriceRetrieverImpl retriever = new OptimalPriceRetrieverImpl();
        Map<String, Double> lookUpMap =  new HashMap<>();
        ParserHelper parser = Mockito.mock(ParserHelper.class);
        Field f1 = retriever.getClass().getDeclaredField("helper");
        f1.setAccessible(true);
        f1.set(retriever, parser);
        when(parser.loadResourceMap()).thenReturn(lookUpMap);
        RentalRequest request = new RentalRequest("2","2","1200");
        Response response =retriever.getOptimalPrice(request);
    }

    @Test
    public void testgetOptimalReturnsResponseFor2_2() throws Exception{
        OptimalPriceRetrieverImpl retriever = new OptimalPriceRetrieverImpl();
        Map<String, Double> lookUpMap =  new HashMap<>();
        lookUpMap.put("2_2", 2454.0);
        lookUpMap.put("2_1", 2100.0);
        ParserHelper parser = Mockito.mock(ParserHelper.class);

        Field f1 = retriever.getClass().getDeclaredField("helper");
        f1.setAccessible(true);
        f1.set(retriever, parser);

        when(parser.loadResourceMap()).thenReturn(lookUpMap);
        RentalRequest request = new RentalRequest("2","2","1200");

        Mockito.verify(parser, times(1)).loadResourceMap();
        Response response =retriever.getOptimalPrice(request);
        response.getOptimalPrice().equals(2454.0);
    }

    @Test
    public void testgetOptimalReturnsResponseFor2_1() throws Exception{
        OptimalPriceRetrieverImpl retriever = new OptimalPriceRetrieverImpl();
        Map<String, Double> lookUpMap =  new HashMap<>();
        lookUpMap.put("2_2", 2454.0);
        lookUpMap.put("2_1", 2100.0);
        ParserHelper parser = Mockito.mock(ParserHelper.class);

        Field f1 = retriever.getClass().getDeclaredField("helper");
        f1.setAccessible(true);
        f1.set(retriever, parser);

        when(parser.loadResourceMap()).thenReturn(lookUpMap);
        RentalRequest request = new RentalRequest("2","2","1200");

        Mockito.verify(parser, times(1)).loadResourceMap();
        Response response =retriever.getOptimalPrice(request);
        response.getOptimalPrice().equals(2100.0);
    }


    @Test
    public void testgetOptimalReturnsResponseFor1_1() throws Exception{
        OptimalPriceRetrieverImpl retriever = new OptimalPriceRetrieverImpl();
        Map<String, Double> lookUpMap =  new HashMap<>();
        lookUpMap.put("2_2", 2454.0);
        lookUpMap.put("2_1", 2100.0);
        lookUpMap.put("1_1", 1000.0);
        ParserHelper parser = Mockito.mock(ParserHelper.class);

        Field f1 = retriever.getClass().getDeclaredField("helper");
        f1.setAccessible(true);
        f1.set(retriever, parser);

        when(parser.loadResourceMap()).thenReturn(lookUpMap);
        RentalRequest request = new RentalRequest("2","2","1200");

        Mockito.verify(parser, times(1)).loadResourceMap();
        Response response =retriever.getOptimalPrice(request);
        response.getOptimalPrice().equals(1000.0);
    }

}
