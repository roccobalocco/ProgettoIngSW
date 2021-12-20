package controllers;

import javafx.scene.control.TextField;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;


import javax.imageio.IIOException;

import classes.ElettoreDAOImpl;
import classes.ScrutatoreDAOImpl;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.PasswordField;

public class LoginController {
	@FXML private TextField userField;
	@FXML private PasswordField passwordField;
	
	Alert a = new Alert(AlertType.NONE);
	
	private static boolean existInDb(String user, String psw){
		if((new ElettoreDAOImpl()).getUtenteByUserPassword(user, psw) != null) 
			return true;
		else 
			if((new ScrutatoreDAOImpl()).getUtenteByUserPassword(user, psw) != null) 
				return true;

		System.out.println("Non esiste");
		return false;
	}
	
	public void logged(Stage primaryStage) {
		try {
            Parent root = FXMLLoader.load(getClass().getResource("logged.fxml"));
            //Scene scene = new Scene(root);
            
            //primaryStage.setScene(scene);
            //primaryStage.setTitle("Logged");
            //primaryStage.setResizable(false);
            //primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
	}
	
	@FXML
	public void login() throws IIOException{
		String userString = userField.getText();
		String pswString = passwordField.getText();
		if(existInDb(userString, pswString)) {
			/*a.setAlertType(AlertType.INFORMATION);
			a.setContentText("Login effettuato con successo " + userString);
			a.show();*/
			logged(new Stage());
		}else { 
			a.setAlertType(AlertType.ERROR);
			a.setContentText("Login non effettuato " + userString);
			a.show();
		}
		
	}
}
