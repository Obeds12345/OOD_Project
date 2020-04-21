package javaFx;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;

public class GetBarChart {
    public static VBox bar() {
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Jan-2-2020");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Data");

        BarChart barChart = new BarChart(xAxis, yAxis);

        XYChart.Series dataSeries1 = new XYChart.Series();
        dataSeries1.setName("USA");

        dataSeries1.getData().add(new XYChart.Data("Cases", 167));
        dataSeries1.getData().add(new XYChart.Data("Deaths", 65));
        dataSeries1.getData().add(new XYChart.Data("Recovery", 23));

        barChart.getData().add(dataSeries1);

        VBox vbox = new VBox(barChart);
        vbox.setStyle("-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");
        vbox.setPrefWidth(400);
        vbox.setPrefHeight(400);
        return vbox;
    }

}
