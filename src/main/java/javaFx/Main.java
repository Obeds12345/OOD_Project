package javaFx;

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

import java.io.IOException;
import java.util.Map;

public class Main extends Application {
    Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Project");
        Scene scene = new Scene(createBorderPane(), 1200, 700);
        window.setScene(scene);
        window.show();
    }

    public BorderPane createBorderPane() throws IOException {
        BorderPane borderPane = new BorderPane();
        BorderPane centerPane = new BorderPane();
        BorderPane centerPane2 = new BorderPane();

        centerPane2.setLeft(GetBarChart.bar());
        centerPane2.setCenter(GetMultiBarChart.multiBar());
        centerPane2.setRight(GetPieChart.pieChart());

        centerPane.setTop(GetLineChart.getlinechart());
        centerPane.setCenter(centerPane2);

        borderPane.setTop(DetailedStats.DetailedBox());
        borderPane.setLeft(menuLeft());
        borderPane.setCenter(centerPane);
        return borderPane;
    }

    public VBox menuLeft() throws IOException {
        VBox vbox = new VBox();
        Map<String, String> countries = Tools.createMap();
        ComboBox comboBox = new ComboBox(FXCollections.observableArrayList(countries.keySet()));
        comboBox.setValue("United States of America (the)");

        // Create action event
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
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
