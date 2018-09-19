package com.example.truliarentals.impl;

import com.example.truliarentals.models.OptimalPriceRetriever;
import com.example.truliarentals.models.RentalRequest;
import com.example.truliarentals.models.Response;
import org.springframework.stereotype.Component;

import javax.ws.rs.InternalServerErrorException;
import java.util.Map;

/**
 * Created by Yamini on 9/17/18.
 */
@Component
public class OptimalPriceRetrieverImpl implements OptimalPriceRetriever {

    @Override
    public Response getOptimalPrice(RentalRequest criteria)
    {
        if(null == criteria)
        {
            throw new InternalServerErrorException("Internal Server Error");
        }
        Response response = new Response();
        Map<String, Double> lookUpMap = ParserHelper.loadResourceMap();
        if(lookUpMap.size() == 0)
        {
            throw new InternalServerErrorException("Internal Server Error");
        }
        else
        {
            String lookupKey = criteria.getBedRooms() + "_" + criteria.getBathRooms();
            if(lookUpMap.containsKey(lookupKey))
            {
                response.setOptimalPrice(Math.floor(lookUpMap.get(lookupKey) * Double.parseDouble(criteria.getSquareFeet())));
            }
        }
        return response;
    }
}
