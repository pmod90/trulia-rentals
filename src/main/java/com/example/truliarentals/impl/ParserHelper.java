package com.example.truliarentals.impl;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import javax.ws.rs.InternalServerErrorException;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * Helper class for for loading the data from csv file into a map.
 */
public class ParserHelper {
    private static final String PATH = "./challenge_data.csv";
    private static final Map<String, List<Double>> map = new HashMap<>();
    private static final Map<String, Double> lookUpMap = new HashMap<>();

    /**
     * Loads the map keyed by String of number of bedrooms and bathrooms to the price per square feet.
     * @return map of number of bedrooms and bathrooms to the price per square feet.
     */
    public Map<String, Double> loadResourceMap(){
        if(lookUpMap.size() > 0){
            return lookUpMap;
        }
        CSVParser csvParser;
        try {
            Reader reader = Files.newBufferedReader(Paths.get(PATH));
            csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader()
                    .withIgnoreHeaderCase().withTrim());
        }
        catch (IOException ex){
            throw new InternalServerErrorException("Internal Server Error");
        }
        for(CSVRecord cvsRecord: csvParser){
            double price = Double.parseDouble(cvsRecord.get("Price"));
            int numberOfBedrooms = Integer.parseInt(cvsRecord.get("Bedrooms"));
            int numberOfBathrooms = Integer.parseInt(cvsRecord.get("Bathrooms"));
            double square_feet = Double.parseDouble(cvsRecord.get("square-foot"));

            double price_per_square_foot = price/square_feet;

            String key = String.valueOf(numberOfBedrooms) + "_" + String.valueOf(numberOfBathrooms);

            if(map.containsKey(key)){
                map.get(key).add(price_per_square_foot);
            }
            else{
                List<Double> list = new ArrayList();
                list.add(price_per_square_foot);
                map.put(key,list);
            }
        }
        for(String key : map.keySet())
        {
            Collections.sort(map.get(key));
            lookUpMap.put(key, map.get(key).get(map.get(key).size()/2));
        }
        return lookUpMap;
    }
}
