package javaFx;

import data.CountryCovidStats;
import data.IndividualStat;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.VBox;

import java.util.List;

public class GetPieChart {
    public static VBox  pieChart(List<CountryCovidStats> countries, IndividualStat stat) {
        PieChart pieChart = new PieChart();
        pieChart.setTitle(stat.name());

        for(CountryCovidStats country : countries) {
            double tempValue = stat.getValue(country);
            PieChart.Data slice1 = new PieChart.Data(country.getCountryName(), tempValue);
            pieChart.getData().add(slice1);

        }


        pieChart.getData().forEach(data -> {
            data.nameProperty().bind(
                    javafx.beans.binding.Bindings.concat(data.getName(), " ", data.getPieValue())
            );
        });


        VBox vbox = new VBox(pieChart);
        vbox.setPrefWidth(600);
        vbox.setPrefHeight(600);
        return vbox;
    }
}
