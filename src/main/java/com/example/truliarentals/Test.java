package com.example.truliarentals;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.PathParam;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

@RestController
public class Test {
    private static final String PATH = "./challenge_data.csv";
    private static final Map<String, List<Double>> map = new HashMap<String, List<Double>>();
    private static final Map<String, Double> lookUpMap = new HashMap<String, Double>();
    @RequestMapping(value = "/test", method = RequestMethod.GET, produces ={"application/json"})
    public Double test(@PathParam("name")String name, @PathParam("bedrooms")String bedrooms, @PathParam("bathrooms")String bathrooms, @PathParam("squarefeet")String squarefeet) throws IOException{

        System.out.println(name);
        System.out.println(bedrooms);
        System.out.println(bathrooms);
        System.out.println(squarefeet);


        Reader reader = Files.newBufferedReader(Paths.get(PATH));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader("Price", "Bedrooms", "Bathrooms","square-foot")
                .withIgnoreHeaderCase().withTrim());
        for(CSVRecord cvsRecord: csvParser){
            if ("price".equals(cvsRecord.get("Price"))){
                continue;
            }
            //System.out.println("Price : "+ cvsRecord.get("Price"));
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
            //System.out.println(key + ":" + map.get(key).size());
            lookUpMap.put(key, map.get(key).get(map.get(key).size()/2));

            //System.out.println(map.size());
        }

        String lookupKey = bedrooms + "_" + bathrooms;
        if(lookUpMap.containsKey(lookupKey))
        {
            return lookUpMap.get(lookupKey) * Double.parseDouble(squarefeet);
        }
        else
            return 0.0;
    }


}
