package com.snetkoPingpong;

import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;

public class PinponController {

    @FXML
    private Rectangle bluePaddle;
    @FXML
    private Rectangle yellowPaddle;

    int paddleSpeed =5;

    DoubleProperty currentYYellowPaddle = new SimpleDoubleProperty();
    public void initialize() {
        currentYYellowPaddle.set(yellowPaddle.getLayoutY());
        yellowPaddle.layoutYProperty().bind(currentYYellowPaddle);

        int allowedPaddleTopY = paddleSpeed;
    }

    @FXML

    public void onKeyReleased(KeyEvent event){
        System.out.println(event.getCode());
        switch (event.getCode()){
            case W:
                System.out.println("Pressed: W");
                break;
            case S:
                System.out.println("Pressed: S");
                break;
            case UP:
                System.out.println("Pressed: UP");
                break;
            case DOWN:
                System.out.println("Pressed: DOWN");
                break;
            case Q:
                Platform.exit();
                break;

        }
    }
    private void processS(){
       // yellowPaddle.layoutYProperty()+=1;
    }

}
