package com.example.calculator;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculator extends Application {

    private String currentText = "";
    private int total = 0;
    private String operator = "+";

    @Override
    public void start(Stage primaryStage) {

        TextField display = new TextField();
        display.setEditable(false);
        display.setStyle("-fx-font-size: 20px; -fx-background-color: #ffffff; -fx-text-fill: #333333; -fx-border-color: #888; -fx-border-width: 1px;");
        display.setAlignment(Pos.CENTER_RIGHT);
        display.setPrefHeight(50);

        Button button1 = new Button("1");
        button1.setStyle("-fx-font-weight: bold; -fx-background-color: #0fbfcf;");
        Button button2 = new Button("2");
        button2.setStyle("-fx-font-weight: bold; -fx-background-color: #0fbfcf;");
        Button button3 = new Button("3");
        button3.setStyle("-fx-font-weight: bold; -fx-background-color: #0fbfcf;");
        Button button4 = new Button("4");
        button4.setStyle("-fx-font-weight: bold; -fx-background-color: #0fbfcf;");
        Button button5 = new Button("5");
        button5.setStyle("-fx-font-weight: bold; -fx-background-color: #0fbfcf;");
        Button button6 = new Button("6");
        button6.setStyle("-fx-font-weight: bold; -fx-background-color: #0fbfcf;");
        Button button7 = new Button("7");
        button7.setStyle("-fx-font-weight: bold; -fx-background-color: #0fbfcf;");
        Button button8 = new Button("8");
        button8.setStyle("-fx-font-weight: bold; -fx-background-color: #0fbfcf;");
        Button button9 = new Button("9");
        button9.setStyle("-fx-font-weight: bold; -fx-background-color: #0fbfcf;");
        Button button0 = new Button("0");
        button0.setStyle("-fx-font-weight: bold; -fx-background-color: #0fbfcf;");

        Button buttonPlus = new Button("+");
        buttonPlus.setStyle("-fx-font-weight: bold; -fx-background-color: #4CAF50; -fx-text-fill: white;");
        Button buttonMinus = new Button("-");
        buttonMinus.setStyle("-fx-font-weight: bold; -fx-background-color: #F44336; -fx-text-fill: white;");
        Button buttonMultiply = new Button("*");
        buttonMultiply.setStyle("-fx-font-weight: bold; -fx-background-color: #9C27B0; -fx-text-fill: white;");
        Button buttonDivide = new Button("/");
        buttonDivide.setStyle("-fx-font-weight: bold; -fx-background-color: #2196F3; -fx-text-fill: white;");
        Button buttonC = new Button("C");
        buttonC.setStyle("-fx-font-weight: bold; -fx-background-color: #EEEEEE; -fx-text-fill: black;");
        Button buttonEquals = new Button("=");
        buttonEquals.setStyle("-fx-font-weight: bold; -fx-background-color: #FF9800; -fx-text-fill: white;");

        Button[] numberButtons = {button1, button2, button3, button4, button5, button6, button7, button8, button9, button0};
        Button[] operation = {buttonPlus, buttonMinus, buttonMultiply, buttonDivide};

        for (Button button : numberButtons) {
            button.setPrefSize(60, 60);
            button.setOnAction(e -> {
                currentText += button.getText();
                display.setText(currentText);
            });
        }

        buttonPlus.setPrefSize(60, 60);
        buttonPlus.setOnAction(e -> {
            total += Integer.parseInt(currentText);
            currentText = "";
            display.setText(String.valueOf(total));
            operator = "+";
        });

        buttonMinus.setPrefSize(60, 60);
        buttonMinus.setOnAction(e -> {
            total += Integer.parseInt(currentText);
            currentText = "";
            display.setText(String.valueOf(total));
            operator = "-";
        });

        buttonMultiply.setPrefSize(60, 60);
        buttonMultiply.setOnAction(e -> {
            total += Integer.parseInt(currentText);
            currentText = "";
            display.setText(String.valueOf(total));
            operator = "*";
        });

        buttonDivide.setPrefSize(60, 60);
        buttonDivide.setOnAction(e -> {
            total += Integer.parseInt(currentText);
            currentText = "";
            display.setText(String.valueOf(total));
            operator = "/";
        });

        buttonC.setPrefSize(60, 60);
        buttonC.setOnAction(e -> {
            currentText = "";
            total = 0;
            display.setText("");
        });

        buttonEquals.setPrefSize(60, 60);
        buttonEquals.setOnAction(e -> {
            if (!currentText.isEmpty()) {
                if (operator.equals("+")) {
                    total += Integer.parseInt(currentText);
                    display.setText(String.valueOf(total));
                    currentText = "";
                } else if (operator.equals("-")) {
                    total -= Integer.parseInt(currentText);
                    display.setText(String.valueOf(total));
                } else if (operator.equals("*")) {
                    total *= Integer.parseInt(currentText);
                    display.setText(String.valueOf(total));
                } else if (operator.equals("/")) {
                    total /= Integer.parseInt(currentText);
                    display.setText(String.valueOf(total));
                }
            }
        });

        for (Button button : numberButtons) {
            button.setPrefSize(60, 60);
            String baseStyle = "-fx-font-weight: bold; -fx-background-color: #0fbfcf;";
            button.setOnMouseEntered(e -> button.setStyle("-fx-font-weight: bold; -fx-background-color: #33d3e0;"));
            button.setOnMouseExited(e -> button.setStyle(baseStyle));
            button.setOnMousePressed(e -> button.setStyle("-fx-font-weight: bold; -fx-background-color: #0097a7;"));
            button.setOnMouseReleased(e -> {
                if (button.isHover()) {
                    button.setStyle("-fx-font-weight: bold; -fx-background-color: #33d3e0;");
                } else {
                    button.setStyle(baseStyle);
                }
            });

            for (Button operationButton : operation) {
                String baseStyleoperation = "";
                if (operationButton == buttonPlus) {
                    baseStyleoperation = "-fx-font-weight: bold; -fx-background-color: #4CAF50; -fx-text-fill: white;";
                } else if (operationButton == buttonMinus) {
                    baseStyleoperation = "-fx-font-weight: bold; -fx-background-color: #F44336; -fx-text-fill: white;";
                } else if (operationButton == buttonMultiply) {
                    baseStyleoperation = "-fx-font-weight: bold; -fx-background-color: #9C27B0; -fx-text-fill: white;";
                } else if (operationButton == buttonDivide) {
                    baseStyleoperation = "-fx-font-weight: bold; -fx-background-color: #2196F3; -fx-text-fill: white;";
                }

                String finalBaseStyle = baseStyleoperation;
                operationButton.setStyle(finalBaseStyle);
                operationButton.setOnMouseEntered(e -> operationButton.setStyle(finalBaseStyle + "-fx-opacity: 0.85;"));
                operationButton.setOnMouseExited(e -> operationButton.setStyle(finalBaseStyle));
                operationButton.setOnMousePressed(e -> operationButton.setStyle(finalBaseStyle + "-fx-opacity: 0.7;"));
                operationButton.setOnMouseReleased(e -> operationButton.setStyle(finalBaseStyle + "-fx-opacity: 0.85;"));
            }

            button.setStyle(baseStyle);
            button.setOnAction(e -> {
                currentText += button.getText();
                display.setText(currentText);
            });
        }

        HBox buttonRow1 = new HBox(10);
        buttonRow1.setAlignment(Pos.CENTER);
        buttonRow1.getChildren().addAll(button1, button2, button3, buttonPlus);

        HBox buttonRow2 = new HBox(10);
        buttonRow2.setAlignment(Pos.CENTER);
        buttonRow2.getChildren().addAll(button4, button5, button6, buttonMinus);

        HBox buttonRow3 = new HBox(10);
        buttonRow3.setAlignment(Pos.CENTER);
        buttonRow3.getChildren().addAll(button7, button8, button9, buttonMultiply);

        HBox buttonRow4 = new HBox(10);
        buttonRow4.setAlignment(Pos.CENTER);
        buttonRow4.getChildren().addAll(button0, buttonC, buttonEquals, buttonDivide);

        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(display, buttonRow1, buttonRow2, buttonRow3, buttonRow4);

        Scene scene = new Scene(layout, 300, 400);
        layout.setStyle("-fx-background-color: #000000;");
        primaryStage.setTitle("Calculator Step 4");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
