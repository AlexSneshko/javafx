package com.snetko.tictactoe;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;


public class TictactoeController {
    @FXML
    public Button button_1;
    public Button button_2;
    public Button button_3;
    public Button button_4;
    public Button button_5;
    public Button button_6;
    public Button button_7;
    public Button button_8;
    public Button button_9;
    public TextArea text;

    @FXML
    String newPlayer = new String("X");
    public void onMouseClicked(MouseEvent event) {
        if (event.getSource() instanceof Button) {
            Button button = (Button) event.getSource();
            if (button.getText().equals("")) {
               button.setText(newPlayer);
               winnerChecker(newPlayer);
               if (newPlayer.equals("X")) { newPlayer="O"; } else newPlayer="X";
            }
        }
    }

    public void winnerChecker(String whoseTurn) {
        if (button_1.getText().equals(button_2.getText()) && button_2.getText().equals(button_3.getText()) && button_1.getText()!=""   ||
                button_3.getText().equals(button_4.getText()) && button_4.getText().equals(button_5.getText()) && button_3.getText()!=""  ||
                button_6.getText().equals(button_7.getText()) && button_7.getText().equals(button_8.getText()) && button_6.getText()!=""  ||
                button_1.getText().equals(button_4.getText()) && button_4.getText().equals(button_7.getText()) && button_1.getText()!=""  ||
                button_2.getText().equals(button_5.getText()) && button_5.getText().equals(button_7.getText()) && button_2.getText()!=""  ||
                button_3.getText().equals(button_6.getText()) && button_6.getText().equals(button_9.getText()) && button_3.getText()!=""  ||
                button_1.getText().equals(button_5.getText()) && button_5.getText().equals(button_9.getText()) && button_1.getText()!=""  ||
                button_3.getText().equals(button_5.getText()) && button_5.getText().equals(button_7.getText()) && button_3.getText()!=""  ) {
            System.out.println("You win");
            if (newPlayer.equals("X")) {
                text.setText("1st winner 2nd loser");
            } else  text.setText("2nd winner 1st loser");
        }
    }
}
