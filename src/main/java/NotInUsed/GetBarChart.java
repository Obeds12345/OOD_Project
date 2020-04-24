package NotInUsed;

import data.CountryCovidStats;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;

import java.util.List;

public class GetBarChart {
    public static VBox bar(List<CountryCovidStats> countries) {
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Countries");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Values");

        BarChart barChart = new BarChart(xAxis, yAxis);
        barChart.setTitle("Deaths per Country");

        XYChart.Series dataSeries1 = new XYChart.Series();
        dataSeries1.setName("Deaths");

        for (CountryCovidStats currentCountry : countries) {
            dataSeries1.getData().add(new XYChart.Data(currentCountry.getCountryName(), currentCountry.getDeaths()));
        }


        barChart.getData().add(dataSeries1);

        VBox vbox = new VBox(barChart);
        vbox.setStyle("-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");
        vbox.setPrefWidth(1200);
        vbox.setPrefHeight(800);
        return vbox;
    }

}
