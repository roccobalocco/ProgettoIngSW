package test;
import java.awt.Label;

import javafx.fxml.FXML;

public class Controller {
	
	@FXML
	private Label label;
	
	public void initialize() {
		String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        label.setText("Hello, JavaFX " + javafxVersion + ",\nrunning on Java " + javaVersion + ".");
	}
	
}
