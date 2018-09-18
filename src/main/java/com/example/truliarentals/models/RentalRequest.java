package com.example.truliarentals.models;

/**
 * Created by Yamini on 9/16/18.
 */
public class RentalRequest {

    private String bedRooms;
    private String bathRooms;
    private String squareFeet;

    public RentalRequest(String bedRooms, String bathRooms, String squareFeet){
        this.bedRooms = bedRooms;
        this.bathRooms = bathRooms;
        this.squareFeet = squareFeet;
    }

    public String getBedRooms() {
        return bedRooms;
    }

    public String getBathRooms() {
        return bathRooms;
    }

    public String getSquareFeet() {
        return squareFeet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RentalRequest that = (RentalRequest) o;

        if (bedRooms != null ? !bedRooms.equals(that.bedRooms) : that.bedRooms != null) return false;
        if (bathRooms != null ? !bathRooms.equals(that.bathRooms) : that.bathRooms != null) return false;
        return squareFeet != null ? squareFeet.equals(that.squareFeet) : that.squareFeet == null;

    }

    @Override
    public int hashCode() {
        int result = bedRooms != null ? bedRooms.hashCode() : 0;
        result = 31 * result + (bathRooms != null ? bathRooms.hashCode() : 0);
        result = 31 * result + (squareFeet != null ? squareFeet.hashCode() : 0);
        return result;
    }
}
