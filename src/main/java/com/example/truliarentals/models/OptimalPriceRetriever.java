package com.example.truliarentals.models;

/**
 * Interface for retrieving the optimal price of a rental.
 */
public interface OptimalPriceRetriever {

    /**
     * Returns {@link Response} object with the optimal price for a rental.
     * @param criteria the {@link RentalRequest} object containing the requested
     *                 number of bathrooms, bedrooms and the squarefeet of the rental.
     * @return {@link Response} object.
     */
    Response getOptimalPrice(RentalRequest criteria);
}
