package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.SystemFacade;

public class LoginController implements Initializable {

	@FXML
	protected Button btnLogar;

	@FXML
	protected Button btnRegisterUser;
	@FXML
	protected TextField password;

	@FXML
	protected TextField userName;

	@FXML
	void onClickLogar(ActionEvent event) {
		SystemFacade facadeLogin = new SystemFacade();
		System.out.println(facadeLogin.login(this.userName.getText(), this.password.getText()));
		
		Main.changeScreen("managements");
	}

	@FXML
	void onClickRegisterUser(ActionEvent event) {
		System.out.println("cadastrar");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	}



}
