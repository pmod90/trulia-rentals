package com.example.truliarentals.impl;

import com.example.truliarentals.models.OptimalPriceRetriever;
import com.example.truliarentals.models.RentalRequest;
import com.example.truliarentals.models.Response;
import org.springframework.stereotype.Component;

import javax.ws.rs.InternalServerErrorException;
import java.util.Map;

/**
 * Implementation class for {@link OptimalPriceRetriever}
 */
@Component
public class OptimalPriceRetrieverImpl implements OptimalPriceRetriever {
    private  ParserHelper helper;
    private Response response;


    public OptimalPriceRetrieverImpl(){
        helper=new ParserHelper();
        response= new Response();
    }

    @Override
    public Response getOptimalPrice(RentalRequest criteria)
    {
        if(null == criteria)
        {
            throw new InternalServerErrorException();
        }
        Map<String, Double> lookUpMap = helper.loadResourceMap();
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
