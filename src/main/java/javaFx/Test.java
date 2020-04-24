package javaFx;

import data.Tools;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Map;


public class Test extends Application {

    ObservableList<PieChart.Data> pieChartData;

    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(new Group());
        stage.setTitle("Imported Fruits");
        stage.setWidth(500);
        stage.setHeight(500);

        this.pieChartData =
                FXCollections.observableArrayList();

        addData("Test", 5.1);
        addData("Test2", 15.1);
        addData("Test3", 3.1);
        addData("Test1", 4.9);
        addData("Test2", 15.1);
        addData("Test3", 2.1);
        addData("Test5", 20.1);


        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Imported Fruits");
        final Label caption = new Label("");
        caption.setTextFill(Color.DARKORANGE);
        caption.setStyle("-fx-font: 24 arial;");

        BorderPane b= new BorderPane();
        b.setTop(menuLeft());
        b.setBottom(chart);
        scene = new Scene(b, 500, 500);
//        stage.setScene(scene);
//        ((Group) scene.getRoot()).getChildren().addAll(menuLeft(), chart, caption);
        stage.setScene(scene);
        stage.show();
    }

    public HBox menuLeft() throws IOException {
        HBox hbox = new HBox();
        Map<String, String> countries = Tools.createMap();
        ComboBox comboBox = new ComboBox(FXCollections.observableArrayList(countries.keySet()));
        comboBox.setValue("United States of America (the)");

        ComboBox comboBox2 = new ComboBox(FXCollections.observableArrayList(countries.keySet()));
        comboBox2.setValue("Ghana");

        // Create action event
        // This part needs work. Do you know how to update the app when you select a country.
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                String countryAbbr = countries.get(comboBox.getValue());
                addData("new", 2.0);
            }
        };

        EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                String countryAbbr = countries.get(comboBox.getValue());
                naiveAddData2("Test", 5.1);
            }
        };

        comboBox.setOnAction(event);
        comboBox2.setOnAction(event2);
//        String value = (String) comboBox.getValue();
        hbox.getChildren().addAll(comboBox, comboBox2);
        hbox.setSpacing(20);
        hbox.setStyle("-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");
        hbox.setPrefWidth(120);
        return hbox;
    }

    public void naiveAddData(String name, double value) {
        pieChartData.add(new javafx.scene.chart.PieChart.Data(name, value));
    }
    public void naiveAddData2(String name, double value) {
        pieChartData.remove(2);
    }

    //updates existing Data-Object if name matches
    public void addData(String name, double value) {
        for (javafx.scene.chart.PieChart.Data d : pieChartData) {
            if (d.getName().equals(name)) {
                d.setPieValue(value);
                return;
            }
        }
        naiveAddData(name, value);
    }

    public void removeData(String name, double value) {
        for (javafx.scene.chart.PieChart.Data d : pieChartData) {
            if (d.getName().equals(name)) {
                d.setPieValue(value);
                return;
            }
        }
        naiveAddData(name, value);
    }

    public static void main(String[] args) {
        launch(args);
    }


}