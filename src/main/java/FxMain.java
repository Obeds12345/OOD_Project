import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FxMain extends Application {
    Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Project");
        Scene scene = new Scene(createBorderPane(), 500, 500);
        window.setScene(scene);
        window.show();
    }

    public BorderPane createBorderPane() {
        BorderPane borderPane = new BorderPane();
        BorderPane centerPane = new BorderPane();
        BorderPane centerPane2 = new BorderPane();

        centerPane2.setLeft(bar());
        centerPane2.setCenter(multiBar());
        centerPane2.setRight(pieChart());

        centerPane.setTop(linechart());
        centerPane.setCenter(centerPane2);

        borderPane.setTop(DetailedBox());
        borderPane.setLeft(menuLeft());
        borderPane.setCenter(centerPane);
        return borderPane;
    }

    public HBox DetailedBox() {
        HBox hbox = new HBox();
        hbox.setSpacing(10);
        hbox.setPadding(new Insets(5));
        hbox.setAlignment(Pos.CENTER_LEFT);
        hbox.setStyle("-fx-border-style: solid inside;" +
                "-fx-border-width: 1;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 2;" +
                "-fx-border-color: gray;");
        Label space = new Label("             ");
        Label space2 = new Label("             ");
        Label cases = new Label("Total Cases: ");
        Label casesValue = new Label("1,120,908");

        Label deaths = new Label("Total Deaths: ");
        Label deathsValue = new Label("200,345");

        Label recovery = new Label("Total Recovery: ");
        Label recoveryValue = new Label("700,345");

        hbox.getChildren().addAll(cases, casesValue, space, deaths, deathsValue,space2, recovery, recoveryValue);
        return hbox;
    }

    public VBox menuLeft() {
        VBox vbox = new VBox();
        ChoiceBox cb = new ChoiceBox(FXCollections.observableArrayList("Country1", "Country2", "Country3", "Country4", "Country5"));
        vbox.getChildren().addAll(cb);
        vbox.setStyle("-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");
        vbox.setPrefWidth(120);
        return vbox;
    }

    public VBox linechart() {
        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("Country");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Selected Date");

        LineChart lineChart = new LineChart(xAxis, yAxis);

        XYChart.Series dataSeries1 = new XYChart.Series();
        dataSeries1.setName("As of April 2020");

        dataSeries1.getData().add(new XYChart.Data(1, 567));
        dataSeries1.getData().add(new XYChart.Data(5, 612));
        dataSeries1.getData().add(new XYChart.Data(10, 800));
        dataSeries1.getData().add(new XYChart.Data(20, 780));
        dataSeries1.getData().add(new XYChart.Data(40, 810));
        dataSeries1.getData().add(new XYChart.Data(80, 850));

        lineChart.getData().add(dataSeries1);

        VBox vbox = new VBox(lineChart);
        return vbox;
    }

    public VBox bar() {
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





    public VBox multiBar() {
        final String austria = "Austria";
        final String brazil = "Brazil";
        final String france = "France";
        final String italy = "Italy";
        final String usa = "USA";
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String, Number> bc = new BarChart<String, Number>(xAxis, yAxis);
        bc.setTitle("Country Summary");
        xAxis.setLabel("Country");
        yAxis.setLabel("Value");

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Jan");
        series1.getData().add(new XYChart.Data(austria, 25601.34));
        series1.getData().add(new XYChart.Data(brazil, 20148.82));
        series1.getData().add(new XYChart.Data(france, 10000));
        series1.getData().add(new XYChart.Data(italy, 35407.15));
        series1.getData().add(new XYChart.Data(usa, 12000));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Feb");
        series2.getData().add(new XYChart.Data(austria, 57401.85));
        series2.getData().add(new XYChart.Data(brazil, 41941.19));
        series2.getData().add(new XYChart.Data(france, 45263.37));
        series2.getData().add(new XYChart.Data(italy, 117320.16));
        series2.getData().add(new XYChart.Data(usa, 14845.27));

        XYChart.Series series3 = new XYChart.Series();
        series3.setName("April");
        series3.getData().add(new XYChart.Data(austria, 45000.65));
        series3.getData().add(new XYChart.Data(brazil, 44835.76));
        series3.getData().add(new XYChart.Data(france, 18722.18));
        series3.getData().add(new XYChart.Data(italy, 17557.31));
        series3.getData().add(new XYChart.Data(usa, 92633.68));

        bc.getData().addAll(series1, series2, series3);
        VBox vbox = new VBox(bc);
        vbox.setPrefWidth(400);
        vbox.setPrefHeight(400);
        return vbox;
    }

    public VBox pieChart() {
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

    public static void main(String[] args) {
        Application.launch(args);
    }
}
