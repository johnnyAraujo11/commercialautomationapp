package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import model.ManagementUsers;
import model.Manager;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			String url = "/view/Login.fxml";
			Parent root = FXMLLoader.load(getClass().getResource(url));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/view/style.css").toExternalForm());
			
			primaryStage.setTitle("Sistema de automação");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}
}
