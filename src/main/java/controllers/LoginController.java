package controllers;

import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.IIOException;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;

public class LoginController {
	@FXML private TextField userField;
	@FXML private PasswordField passwordField;
	
	Alert a = new Alert(AlertType.NONE);
	
	private static boolean existInDb(String user, String psw){
		boolean l = false;
		try{
		      //apro connessione
		      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/votazioni?user=root&password=admin");
		      //scrivo query
		      String query = "SELECT * FROM utenti WHERE username = \"" + user + "\" AND password = \"" + psw + "\"";
		      //creo oggetto statement per esecuzione query
		      PreparedStatement statement = conn.prepareStatement(query);
		      //eseguo la query
		      ResultSet resultSet = statement.executeQuery();
		      //guarda se ci sono risultati
		      if(resultSet.next())
		        l = true;
		      
		      //chiudo resultset e connessione
		      resultSet.close();
		      conn.close();
		    }catch(SQLException e){
		      System.out.println("SQLException: " + e.getMessage());
		      System.out.println("SQLState: " + e.getSQLState());
		      System.out.println("VendorError: " + e.getErrorCode());
		    }
		return l;
	}
	
	@FXML
	public void register() {
		
	}
	
	@FXML
	public void login() throws IIOException{
		String userString = userField.getText();
		String pswString = passwordField.getText();
		if(existInDb(userString, pswString)) {
			a.setAlertType(AlertType.INFORMATION);
			a.setContentText("Login effettuato con successo " + userString);
		}else { 
			a.setAlertType(AlertType.ERROR);
			a.setContentText("Login non effettuato " + userString);
		}
			a.show();
		
	}
}
