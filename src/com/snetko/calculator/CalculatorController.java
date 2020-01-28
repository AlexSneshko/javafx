package com.snetko.calculator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class CalculatorController {
    @FXML
    public TextField text;


    public void onMouseClicked(MouseEvent event) {
        if (event.getSource() instanceof Button) {
            Button button = (Button) event.getSource();
            System.out.println("Pressed button: " + button.getText());
            text.setText(text.getText() + button.getText());
            if (button.getText().equals("CE")) {
                text.clear();
            }
            if (button.getText().equals("=")) {

            }
        }
    }

    public void onKeyPressed(KeyEvent event) {
        System.out.println(event.getText());
        if (event.getText().equals("1") || event.getText().equals("2") || event.getText().equals("3") || event.getText().equals("4") || event.getText().equals("5") ||
                event.getText().equals("6") || event.getText().equals("7") || event.getText().equals("9") || event.getText().equals("+") || event.getText().equals("-") ||
                event.getText().equals("*") || event.getText().equals("/") || event.getText().equals("0")) {
            text.setText(text.getText() + event.getText());
        }
    }
}
