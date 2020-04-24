package javaFx;

import data.CountryCovidStats;
import data.IndividualStat;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.VBox;

import java.util.List;

public class GetPieRight {
    public static ObservableList<PieChart.Data> pieChartData;

    public static VBox pieChart(List<CountryCovidStats> countries, IndividualStat stat) {
        pieChartData = FXCollections.observableArrayList();

        for (CountryCovidStats country : countries) {
            double tempValue = stat.getValue(country);
            pieChartData.add(new javafx.scene.chart.PieChart.Data(country.getCountryName(), tempValue));
        }

        PieChart pieChart = new PieChart(pieChartData);
        pieChart.setTitle(stat.name());

        pieChart.getData().forEach(data -> {
            data.nameProperty().bind(
                    javafx.beans.binding.Bindings.concat(data.getName(), " ", data.getPieValue())
            );
        });

        pieChart.setLabelLineLength(0);
        pieChart.setLegendSide(Side.LEFT);
        VBox vbox = new VBox(pieChart);
        vbox.setPrefWidth(500);
        vbox.setPrefHeight(500);
        return vbox;
    }

    public static void addData(int position, String name, double value) {
        for (javafx.scene.chart.PieChart.Data d : pieChartData) {
            if (d.getName().equals(name)) {
                d.setPieValue(value);
                return;
            }
        }
        pieChartData.set(position, new javafx.scene.chart.PieChart.Data(name, value));
    }

}