import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CountryStatsAllDates {
    private String countryName;
    private Long numberOfEntries;
    private Map<String, JSONObject> covidStatsByDateMap;

    public CountryStatsAllDates(String countryName) throws ParseException {
        this.countryName = countryName;
        HttpClient.specificDataForCountry(countryName,"");
        this.covidStatsByDateMap = this.createMap();
    }

    public String getCountryName() {
        return countryName;
    }

    public Long getNumberOfEntries() {
        return numberOfEntries;
    }

    public Map<String, JSONObject> getCovidStatsByDateMap() {
        return covidStatsByDateMap;
    }

    private Map<String, JSONObject> createMap() throws ParseException {
        Map<String, JSONObject> covidStatsByDateMap = new HashMap<>();

        try {
            // Check if file exists. Should be named "output.json"
            Object obj = new JSONParser().parse(new FileReader("output" + File.separator + "output.json"));

            // typecasting obj to JSONObject
            JSONObject jo = (JSONObject) obj;

            // getting count of entries and all results
            this.numberOfEntries = (Long) jo.get("count");

            // Get all results and transform them into our own HashMap<String, JsonObject>
            HashMap results = (HashMap) jo.get("result");

            // Iterate and add all values to our own hashmap
            Iterator iter = results.entrySet().iterator();

            while (iter.hasNext()) {
                Map.Entry mapElement = (Map.Entry) iter.next();
                covidStatsByDateMap.put(mapElement.getKey().toString(), (JSONObject) mapElement.getValue());

            }

            return covidStatsByDateMap;
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist. Should be named output.json");
        } catch (IOException e) {
            System.out.println("IO exception");
        }

        return null;
    }

}
