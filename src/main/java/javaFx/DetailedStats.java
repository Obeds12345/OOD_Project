package javaFx;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class DetailedStats {
    public static HBox DetailedBox() {
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

        hbox.getChildren().addAll(cases, casesValue, space, deaths, deathsValue, space2, recovery, recoveryValue);
        return hbox;
    }
}
