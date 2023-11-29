package controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
	
	@FXML
	TextField passwordField;
	
	@FXML
	public void nextScreen() throws IOException {
		
		Stage priorScreen = (Stage)this.passwordField.getScene().getWindow();
		priorScreen.close();
		
		Stage stage = new Stage();
		
		Parent parent = FXMLLoader.load(getClass().getResource("/views/view.fxml"));
		
		Scene scene = new Scene(parent);
		
		stage.setScene(scene);
		
		stage.show();
		
	}

}
