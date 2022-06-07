package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class Main extends Application {
	
	private static Stage stage;
	private static Scene mainScene;
	private static Scene managements; 
	
	
	@Override
	public void start(@SuppressWarnings("exports") Stage primaryStage) {
		try {	
			stage = primaryStage;
			primaryStage.setTitle("Sistema de automação de bares e restaurantes");

			Parent root = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
			mainScene = new Scene(root);
			mainScene.getStylesheets().add(getClass().getResource("/view/styles/styles.css").toExternalForm());
			
			Parent fxmlManagment = FXMLLoader.load(getClass().getResource("/view/Managements.fxml"));
			managements = new Scene(fxmlManagment);
			
			primaryStage.setScene(mainScene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void changeScreen(String url) {
		switch(url) {
		case "main":
			stage.setScene(mainScene);
			break;
		case "managements":
			stage.setScene(managements);
			break;
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}
}
