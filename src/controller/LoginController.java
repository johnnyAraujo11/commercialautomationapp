package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class LoginController implements Initializable {

	@FXML
	private Button bntLogar;

	@FXML
	private Button btnRegisterUser;
	@FXML
	private TextField password;

	@FXML
	private TextField userName;

	@FXML
	void onClickLogar(ActionEvent event) {
			
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
