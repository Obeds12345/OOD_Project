package javaFx;

import javafx.scene.chart.PieChart;
import javafx.scene.layout.VBox;

public class GetPieChart {
    public static VBox  pieChart() {
        PieChart pieChart = new PieChart();
        pieChart.setTitle("USA Month Summary");
        PieChart.Data slice1 = new PieChart.Data("April", 213);
        PieChart.Data slice2 = new PieChart.Data("May", 67);
        PieChart.Data slice3 = new PieChart.Data("June", 36);

        pieChart.getData().add(slice1);
        pieChart.getData().add(slice2);
        pieChart.getData().add(slice3);

        VBox vbox = new VBox(pieChart);
        vbox.setPrefWidth(400);
        vbox.setPrefHeight(400);
        return vbox;
    }
}
