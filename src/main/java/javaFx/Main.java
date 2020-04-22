package javaFx;

import data.CountryCovidStats;
import data.IndividualStat;
import data.Tools;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class Main extends Application {
    Stage window;

    @Override
    public void start(Stage primaryStage) throws IOException {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, -1); // gets yesterdays date
            String date = dateFormat.format(cal.getTime());
            List<CountryCovidStats> myCountries = new ArrayList<>();
            myCountries.add(new CountryCovidStats("USA", date));
            myCountries.add(new CountryCovidStats("ITA", date));
            myCountries.add(new CountryCovidStats("ESP", date));
            myCountries.add(new CountryCovidStats("CHN", date));
            myCountries.add(new CountryCovidStats("JPN", date));

            window = primaryStage;
            window.setTitle("Project");
            Scene scene = new Scene(createBorderPane(myCountries, date), 1800, 700);
            window.setScene(scene);
            window.show();
        } catch (ParseException e) {
            System.out.println("Cannot parse json. Check date");
        }

    }

    public BorderPane createBorderPane(List<CountryCovidStats> countries, String date) throws IOException, ParseException {
        BorderPane borderPane = new BorderPane();
        BorderPane centerPane = new BorderPane();
        BorderPane centerPane2 = new BorderPane();

        centerPane2.setLeft(GetPieChart.pieChart(countries, IndividualStat.DEATHS));
        centerPane2.setCenter(GetPieChart.pieChart(countries, IndividualStat.CONFIRMED));
        centerPane2.setRight(GetPieChart.pieChart(countries, IndividualStat.RECOVERED));

        centerPane.setTop(GetMultiBarChart.multiBar(countries, date));
        centerPane.setCenter(centerPane2);

        borderPane.setTop(DetailedStats.DetailedBox());
        borderPane.setLeft(menuLeft(countries, date));
        borderPane.setCenter(centerPane);
        return borderPane;
    }

    public VBox menuLeft(List<CountryCovidStats> currentCountries, String date) throws IOException {
        VBox vbox = new VBox();
        Map<String, String> countries = Tools.createMap();
        ComboBox comboBox = new ComboBox(FXCollections.observableArrayList(countries.keySet()));
        comboBox.setValue("United States of America (the)");

        // Create action event
        // This part needs work. Do you know how to update the app when you select a country.
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                String countryAbbr = countries.get(comboBox.getValue());
                try{
                    CountryCovidStats newCountry = new CountryCovidStats(countryAbbr, date);
                    int lastIndex = currentCountries.size() - 1;
                    currentCountries.set(lastIndex, newCountry);

                } catch (ParseException error) {
                    System.out.println("Not a valid country or date");
                }
                System.out.println(comboBox.getValue() + " selected");
            }
        };

        comboBox.setOnAction(event);
//        String value = (String) comboBox.getValue();
        vbox.getChildren().addAll(comboBox);
        vbox.setStyle("-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");
        vbox.setPrefWidth(120);
        return vbox;
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
