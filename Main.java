import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {
        String country = "USA";
        //HttpClient.specificDataForCountry("USA",""); // 2020-03-15
        //HttpClient.golbalStats("",""); // 2020-02-15, 2020-04-01
        //HttpClient.timeSeriesGolbalStats("USA","2020-02-15","2020-04-01"); // USA, 2020-02-15, 2020-04-01
        //String filename = "ISO.txt";
        //Path path = Path.of(ClassLoader.getSystemResource(filename).getFile());


        try {
            CountryStats myCountry = new CountryStats(country);
            Map<String, JSONObject> myMap = myCountry.getCovidStatsByDateMap();

            // This print statement will be displayed for the user
            System.out.println("Please enter date in the format year-month-day ----> 2020-02-28");
            CovidStats cs = new CovidStats(myMap);
            cs.getStatsForDate("2020-01-22");

        } catch (ParseException e) {
            System.out.println("Not a valid country name");
        }


    }
}
