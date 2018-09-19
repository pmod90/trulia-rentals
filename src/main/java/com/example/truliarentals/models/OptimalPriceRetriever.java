package com.example.truliarentals.models;


/**
 * Created by Yamini on 9/17/18.
 */


public interface OptimalPriceRetriever {

    Response getOptimalPrice(RentalRequest criteria);

}
