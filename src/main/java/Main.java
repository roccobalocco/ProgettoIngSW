
import java.util.Iterator;

import classes.Elettore;
import classes.ElettoreDAOImpl;
import classes.Scrutatore;
import classes.ScrutatoreDAOImpl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Login");
            primaryStage.setResizable(false);
            primaryStage.show();
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

	public static void main(String[] args) {
		/*System.out.print("Elettori: \n");
		for (Iterator<Elettore> iterator = (new ElettoreDAOImpl()).getAllElettori().iterator(); iterator.hasNext();) {
			Elettore elettore = (Elettore) iterator.next();
			System.out.println(elettore.toString());
		}
		System.out.print("Scrutatori: \n");
		for (Iterator<Scrutatore> iterator2 = (new ScrutatoreDAOImpl()).getAllElettori().iterator(); iterator2.hasNext();) {
			Scrutatore scrutatore = (Scrutatore) iterator2.next();
			System.out.println(scrutatore.toString());
		}*/
		launch(args);
	}
}
