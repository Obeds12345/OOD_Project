package javaFx;

import data.CountryCovidStats;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;

import java.util.List;

public class GetMultiBarChart {
    public static VBox multiBar(List<CountryCovidStats> countries, String date) {
        // Our top 5 countries. Use this info to fill in the graphs
        final NumberAxis xAxis = new NumberAxis();
        final CategoryAxis yAxis = new CategoryAxis();
        final BarChart<Number, String> bc = new BarChart<Number, String>(xAxis, yAxis);
        bc.setCategoryGap(6.5);
        bc.setBarGap(1.0);

        bc.setTitle("Countries Summary as of " + date);
        xAxis.setLabel("Values");
        yAxis.setLabel("Country");

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Confirmed");

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Deaths");

        XYChart.Series series3 = new XYChart.Series();
        series3.setName("Recovered");

        for(CountryCovidStats country :  countries) {
            series1.getData().add(new XYChart.Data(country.getConfirmed(), country.getCountryName()));
            series2.getData().add(new XYChart.Data(country.getDeaths(), country.getCountryName()));
            series3.getData().add(new XYChart.Data(country.getRecovered(), country.getCountryName()));
        }

        bc.getData().addAll(series1, series2, series3);
        VBox vbox = new VBox(bc);
        vbox.setPrefWidth(700);
        vbox.setPrefHeight(400);
        vbox.setStyle("-fx-border-style: solid inside;" +
                "-fx-border-width: 0 0 1 0;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 0;" +
                "-fx-border-color: grey;");
        return vbox;

        // If our code doesn't parse correctly we will fill in with manual values
//        final String austria = "Austria";
//        final String brazil = "Brazil";
//        final String france = "France";
//        final String italy = "Italy";
//        final String usa = "USA";
//        final CategoryAxis xAxis = new CategoryAxis();
//        final NumberAxis yAxis = new NumberAxis();
//        final BarChart<String, Number> bc = new BarChart<String, Number>(xAxis, yAxis);
//        bc.setTitle("Country Summary");
//        xAxis.setLabel("Country");
//        yAxis.setLabel("Value");
//
//        XYChart.Series series1 = new XYChart.Series();
//        series1.setName("Confirmed");
//        series1.getData().add(new XYChart.Data(austria, 25601.34));
//        series1.getData().add(new XYChart.Data(brazil, 20148.82));
//        series1.getData().add(new XYChart.Data(france, 10000));
//        series1.getData().add(new XYChart.Data(italy, 35407.15));
//        series1.getData().add(new XYChart.Data(usa, 12000));
//
//        XYChart.Series series2 = new XYChart.Series();
//        series2.setName("Recovered");
//        series2.getData().add(new XYChart.Data(austria, 57401.85));
//        series2.getData().add(new XYChart.Data(brazil, 41941.19));
//        series2.getData().add(new XYChart.Data(france, 45263.37));
//        series2.getData().add(new XYChart.Data(italy, 117320.16));
//        series2.getData().add(new XYChart.Data(usa, 14845.27));
//
//        XYChart.Series series3 = new XYChart.Series();
//        series3.setName("Deaths");
//        series3.getData().add(new XYChart.Data(austria, 45000.65));
//        series3.getData().add(new XYChart.Data(brazil, 44835.76));
//        series3.getData().add(new XYChart.Data(france, 18722.18));
//        series3.getData().add(new XYChart.Data(italy, 17557.31));
//        series3.getData().add(new XYChart.Data(usa, 92633.68));
//
//        bc.getData().addAll(series1, series2, series3);
//        VBox vbox = new VBox(bc);
//        vbox.setPrefWidth(400);
//        vbox.setPrefHeight(400);
//
//        return vbox;
    }
}
