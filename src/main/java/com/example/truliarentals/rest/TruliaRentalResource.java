package com.example.truliarentals.rest;

import com.example.truliarentals.models.OptimalPriceRetriever;
import com.example.truliarentals.models.RentalRequest;
import com.example.truliarentals.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.ws.rs.PathParam;
import java.io.IOException;

/**
 * Resource for calculating the optimal price of a rental.
 */
@CrossOrigin
@RestController
public class TruliaRentalResource {

@Autowired
private OptimalPriceRetriever retriever;

    @RequestMapping(value = "/rentals/optimal-price", method = RequestMethod.GET, produces ={"application/json"})
    public Response getOptimalPrice(@PathParam("bedrooms")String bedrooms, @PathParam("bathrooms")String bathrooms, @PathParam("squarefeet")String squarefeet) throws IOException{
        return retriever.getOptimalPrice(new RentalRequest(bedrooms, bathrooms, squarefeet));
    }
}
