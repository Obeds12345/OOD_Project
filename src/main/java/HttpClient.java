import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClient {
    public static String apiUrl = "https://covidapi.info/api/v1/";

    public static void specificDataForCountry(String country, String date) {
        String url = date == "" ? apiUrl + "country/" + country : apiUrl + "country/" + country + "/" + date;
        System.out.println(url);
        HttpGet(url);
    }

    public static void golbalStats(String date1, String date2) {
        String url;
        if (date1 == "") {
            url = apiUrl + "global";
        } else if (date2 == "") {
            url = apiUrl + "global/" + date1;
        } else {
            url = apiUrl + "global/" + date1 + "/" + date2;
        }
        System.out.println(url);
        HttpGet(url);
    }

    public static void timeSeriesGolbalStats(String country, String date1, String date2) {
        String url = country == "" ? apiUrl + "global/timeseries/" + date1 + "/" + date2 : apiUrl + "country/" + country + "/timeseries/" + date1 + "/" + date2;
        System.out.println(url);
        HttpGet(url);
    }

    public static void HttpGet(String url) {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet(url);
        CloseableHttpResponse resp = null;
        try {
            resp = client.execute(get);
            HttpEntity entity = resp.getEntity();
            System.out.println("Json response");
            System.out.println(EntityUtils.toString(entity));

        } catch (IOException ioe) {
            System.err.println("Something went wrong getting the weather: ");
            ioe.printStackTrace();
        } catch (Exception e) {
            System.err.println("Unknown error: ");
            e.printStackTrace();
        }
    }
}
