package com.example.truliarentals.models;

/**
 * Class containing the optimal price information.
 */
public class Response {

    private Double optimalPrice;

    /**
     * @param optimalPrice the optimal price to set.
     */
    public void setOptimalPrice(Double optimalPrice) {
        this.optimalPrice = optimalPrice;
    }

    /**
     * @return the optimal price as a Double.
     */
    public Double getOptimalPrice() {
        return optimalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Response response = (Response) o;

        return optimalPrice != null ? optimalPrice.equals(response.optimalPrice) : response.optimalPrice == null;

    }

    @Override
    public int hashCode() {
        return optimalPrice != null ? optimalPrice.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Response{" +
                "optimalPrice=" + optimalPrice +
                '}';
    }
}
