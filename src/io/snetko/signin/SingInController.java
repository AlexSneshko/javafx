package io.snetko.signin;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class SingInController {
    @FXML
    public TextField account;

    @FXML
    public PasswordField password;

    @FXML
    public Label status;

    private String mainAccount = "admin";
    private String mainPassword = "admin";

    @FXML
    public void onMouseClickedListener(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() instanceof Button) {
            System.out.println("Pressed button: Sign in");
            System.out.println("userId: " + account.getText());
            System.out.println("password:" + password.getText());
            if (account.getText().equals(mainAccount) && password.getText().equals(mainPassword) ) {
                System.out.println("Admin");
                status.setText("Access successful");
            } else { status.setText("Permission denied"); }
        }
    }
}
