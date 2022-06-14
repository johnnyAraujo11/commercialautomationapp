package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.WeakEventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import model.DAO.ManagementUsers;
import model.entitysSystem.Manager;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

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

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static void changeScreen(String url) {
		switch (url) {
		case "main":
			stage.setScene(mainScene);
			break;
		case "managements":
			stage.setScene(managements);
			break;
		}
	}

	public static void erroUser(String msg) {
		Alert alert = new Alert(AlertType.NONE);
		alert.setAlertType(AlertType.CONFIRMATION);
		alert.setContentText(msg);
		alert.show();
	}

	public static void main(String[] args) {
		ManagementUsers managUsers = ManagementUsers.getInstance();
		Manager manager = new Manager("1", "1");

		managUsers.register(manager);
		launch(args);

	}
}
