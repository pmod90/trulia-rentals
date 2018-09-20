package com.example.truliarentals.impl;


import org.junit.Test;

import javax.ws.rs.InternalServerErrorException;

/**
 * Created by Yamini on 9/18/18.
 */
public class OptimalPriceRetrieverImplTest {

    @Test(expected = InternalServerErrorException.class)
    public void testNullCriteria(){
        OptimalPriceRetrieverImpl retriever = new OptimalPriceRetrieverImpl();
        retriever.getOptimalPrice(null);
    }

}
