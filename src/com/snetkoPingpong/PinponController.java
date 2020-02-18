package com.snetkoPingpong;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class PinponController {

    @FXML
    Timeline timeline;
    @FXML
    private Rectangle bluePaddle;
    @FXML
    private Rectangle yellowPaddle;
    @FXML
    private Circle ball;

    int paddleSpeed = 15;
    int allowedPaddleTopY ;

    //players

    DoubleProperty currentYYellowPaddle = new SimpleDoubleProperty();
    DoubleProperty currentYBluePaddle = new SimpleDoubleProperty();
    DoubleProperty ballCenterY = new SimpleDoubleProperty();
    DoubleProperty ballCenterX = new SimpleDoubleProperty();

    public void initialize() {
        currentYYellowPaddle.set(yellowPaddle.getLayoutY());
        yellowPaddle.layoutYProperty().bind(currentYYellowPaddle);
        currentYBluePaddle.set(bluePaddle.getLayoutY());
        bluePaddle.layoutYProperty().bind(currentYBluePaddle);
        ballCenterX.set(ball.getLayoutX());
        ball.layoutXProperty().bind(ballCenterX);
        ballCenterY.set(ball.getLayoutY());
        ball.layoutYProperty().bind(ballCenterY);



        allowedPaddleTopY = paddleSpeed;
    }

    @FXML
    public void onKeyReleased(KeyEvent event){
        System.out.println(event.getCode());
        switch (event.getCode()){
            case W:
                System.out.println("Pressed: W");
                processW();
                break;
            case S:
                System.out.println("Pressed: S");
                processS();
                break;
            case UP:
                System.out.println("Pressed: UP");
                processUp();
                break;
            case DOWN:
                System.out.println("Pressed: DOWN");
                processDown();
                break;
            case Q:
                Platform.exit();
                break;

        }
    }
    private void processUp(){
        if (currentYYellowPaddle.get()>allowedPaddleTopY) {
            currentYYellowPaddle.set(yellowPaddle.getLayoutY() - paddleSpeed);
        }
    }

    private void processDown(){
        if (500 - currentYYellowPaddle.get()>allowedPaddleTopY) {
            currentYYellowPaddle.set(yellowPaddle.getLayoutY() + paddleSpeed);
        }
    }

    private void processS(){
        if (500 - currentYYellowPaddle.get()>allowedPaddleTopY) {
            currentYBluePaddle.set(bluePaddle.getLayoutY() + paddleSpeed);
        }
    }

    private void processW(){
        if (currentYYellowPaddle.get()>allowedPaddleTopY) {
            currentYBluePaddle.set(bluePaddle.getLayoutY() - paddleSpeed);
        }
    }

    //ball

    int BALL_SPEED =15;

    KeyFrame keyFrame = new KeyFrame(new Duration(10), event -> { // Создаем объект "кадра", задаем период повторения и действия которые будут выполняться
        //TODO весь этот код представляет собой программирование поведения мяча => это ТОЛЬКО пример => Его нужно изменить что бы он соответствовал поведению мяча в вашей игре
        System.out.println(ballCenterX); // выводим в терминал текущую позицию мяча
        if (ballCenterX.get() > 0) { // если мяч дошел до левой границы тогда
            ballCenterX.set(ballCenterX.get() - BALL_SPEED); // меняем его позицию
        } else { //иначе
            timeline.stop(); // остонавливаем анимацию
        }
    });

    /*timeline = new Timeline(keyFrame); // создаем объект анимации куда помещаем наш кадр анимации
    timeline.setCycleCount(Timeline.INDEFINITE); // задаем цикл повторения
    timeline.play();*/

}
