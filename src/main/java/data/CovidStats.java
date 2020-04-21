package data;// A class to handle the data for our map effectively

import org.json.simple.JSONObject;

import java.util.Iterator;
import java.util.Map;

public class CovidStats {
    private Map<String, JSONObject> covidStatsByDate;

    public CovidStats(Map<String, JSONObject> covidStatsByDate) {
        this.covidStatsByDate = covidStatsByDate;
    }

    // Get info on a specific date
    public void getStatsForDate(String date) {
        if (this.covidStatsByDate.get(date) == null) {
            System.out.println("Not a valid date");
            return;
        }

        Map info = this.covidStatsByDate.get(date);

        // Iterate and add all values to our own hashmap
        Iterator iter = info.entrySet().iterator();

        while (iter.hasNext()) {
            Map.Entry mapElement = (Map.Entry) iter.next();
            System.out.println(mapElement.getKey().toString() + " : " + mapElement.getValue());
        }
    }
}
