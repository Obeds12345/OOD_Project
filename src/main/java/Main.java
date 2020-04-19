import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws IOException {
        //HttpClient.specificDataForCountry("USA","2020-04-17"); // 2020-03-15
        //HttpClient.golbalStats("",""); // 2020-02-15, 2020-04-01
        //HttpClient.timeSeriesGolbalStats("GB","2020-02-15","2020-04-01"); // USA, 2020-02-15, 2020-04-01

        try {
            // OPTION 1
            // Ask user to enter country's 3-letter abbreviation
            String country = "USA";

            // If user cannot find correct 3-letter abbreviation then the following list can be printed to application
            CountryName cn = new CountryName("ISO.txt");
            // cn.displayCountryNameAndAbbreviation();  // Displays abbreviations

            // Below we get current date in correct format
            // NOTE: User can ask for specific date
            System.out.println("Please enter date in specific format yyyy-MM-dd"); // Tell user to enter date in specific format
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            // NOTE: CURRENT DATE IS NOT ALWAYS UPDATED ON WORLDOMETER WEBSITE. IF THAT IS THE CASE WE MUST
            // PROMPT USER TO ENTER ANOTHER DATE
            String currentDate = dateFormat.format(date); // Get's us current date

            RecoveredAndDeathRates rdr = new RecoveredAndDeathRates(country, "2020-04-18");

            // Display the info
            System.out.println("Country name: " + rdr.getCountryName());
            System.out.println("Confirmed cases on " + currentDate + ": " + rdr.getConfirmed());
            System.out.println("Percentage of deaths to confirmed cases: " + String.format("%.2f", rdr.getDeathRate()));
            System.out.println("Percentage of recovered to confirmed cases: " + String.format("%.2f", rdr.getRecoveredRate()));

            System.out.println();
            System.out.println("---------------------------------------------------");
            System.out.println();

            // OPTION 2
            String dateToBeCompared = "2020-04-10";
            RecoveredAndDeathRates countryOne = new RecoveredAndDeathRates("USA", dateToBeCompared);
            RecoveredAndDeathRates countryTwo = new RecoveredAndDeathRates("ESP", dateToBeCompared);

            // Stats for country one
            System.out.println("Country name: " + countryOne.getCountryName());
            System.out.println("Confirmed cases on " + dateToBeCompared + ": " + countryOne.getConfirmed());
            System.out.println("Percentage of deaths to confirmed cases: " + String.format("%.2f", countryOne.getDeathRate()));
            System.out.println("Percentage of recovered to confirmed cases: " + String.format("%.2f", countryOne.getRecoveredRate()));
            System.out.println();
            // Stats for country two
            System.out.println("Country name: " + countryTwo.getCountryName());
            System.out.println("Confirmed cases on " + dateToBeCompared + ": " + countryTwo.getConfirmed());
            System.out.println("Percentage of deaths to confirmed cases: " + String.format("%.2f", countryTwo.getDeathRate()));
            System.out.println("Percentage of recovered to confirmed cases: " + String.format("%.2f", countryTwo.getRecoveredRate()));


            // This print statement will be displayed for the user
//            System.out.println("Please enter date in the format year-month-day ----> 2020-02-28");
//            CovidStats cs = new CovidStats(myMap);
//            cs.getStatsForDate("2020-02-12");

        } catch (ParseException e) {
            System.out.println("Json file cannot be parsed. Check date used");
        }

        // TODO: Refactor code. Some code will be discarded.



    }
}
