package com.example.truliarentals.models;

/**
 * Created by Yamini on 9/16/18.
 */
public class Response {

    private Double optimalPrice;

    public void setOptimalPrice(Double optimalPrice) {
        this.optimalPrice = optimalPrice;
    }

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
