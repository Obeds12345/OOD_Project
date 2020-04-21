package data;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main {

    public static void main(String[] args) throws IOException {
        //data.HttpClient.specificDataForCountry("USA","2020-04-17"); // 2020-03-15
        //data.HttpClient.golbalStats("",""); // 2020-02-15, 2020-04-01
        //data.HttpClient.timeSeriesGolbalStats("GB","2020-02-15","2020-04-01"); // USA, 2020-02-15, 2020-04-01

        try {
            // World stats for the top section of the application
            WorldStats ws = new WorldStats();
            System.out.println();
            System.out.println("These are the covid-19 stats for the whole world");
            System.out.println("Confirmed cases: " + ws.getConfirmed());
            System.out.println("Deaths: " + ws.getDeaths());
            System.out.println("Recovered: " + ws.getRecovered());
            System.out.println();

            spaceBetweenCountries();

            // Use this to display the different countries and their 3-letter abbreviations
            CountryName cn = new CountryName("ISO.txt");
            // cn.displayCountryNameAndAbbreviation();  // Displays abbreviations

            // I'm using yesterdays date because not all countries update their info at the same time.
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, -1); // gets yesterdays date
            String date = dateFormat.format(cal.getTime());

            // Our top 5 countries. Use this info to fill in the graphs
            CountryCovidStats country1 = new CountryCovidStats("USA", date);
            System.out.println("Country name: " + country1.getCountryName());
            System.out.println("Confirmed cases on " + date + ": " + country1.getConfirmed());
            System.out.println("Deaths: " + country1.getDeaths());
            System.out.println("Recovered: " + country1.getRecovered());

            spaceBetweenCountries();

            CountryCovidStats country2 = new CountryCovidStats("ITA", date);
            System.out.println("Country name: " + country2.getCountryName());
            System.out.println("Confirmed cases on " + date + ": " + country2.getConfirmed());
            System.out.println("Deaths: " + country2.getDeaths());
            System.out.println("Recovered: " + country2.getRecovered());

            spaceBetweenCountries();

            CountryCovidStats country3 = new CountryCovidStats("ESP", date);
            System.out.println("Country name: " + country3.getCountryName());
            System.out.println("Confirmed cases on " + date + ": " + country3.getConfirmed());
            System.out.println("Deaths: " + country3.getDeaths());
            System.out.println("Recovered: " + country3.getRecovered());

            spaceBetweenCountries();

            CountryCovidStats country4 = new CountryCovidStats("CHN", date);
            System.out.println("Country name: " + country4.getCountryName());
            System.out.println("Confirmed cases on " + date + ": " + country4.getConfirmed());
            System.out.println("Deaths: " + country4.getDeaths());
            System.out.println("Recovered: " + country4.getRecovered());

            spaceBetweenCountries();

            CountryCovidStats country5 = new CountryCovidStats("JPN", date);
            System.out.println("Country name: " + country5.getCountryName());
            System.out.println("Confirmed cases on " + date + ": " + country5.getConfirmed());
            System.out.println("Deaths: " + country5.getDeaths());
            System.out.println("Recovered: " + country5.getRecovered());

            //TODO: To add another country just have the user select a country and then do the same as one of the
            // instances above. If you have trouble let me know and i'll help out.

        } catch (ParseException e) {
            System.out.println("Json file cannot be parsed. Check date used");
        }
    }

    // For display purposes. DISCARD FOR FINAL CODE
    public static void spaceBetweenCountries() {
        System.out.println();
        System.out.println("---------------------------------------------------");
        System.out.println();
    }
}
