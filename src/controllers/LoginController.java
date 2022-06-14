package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.DAO.ManagementUsers;
import model.commercialautomationfacade.CommercialAutomationFacade;
import model.entitysSystem.Entity;
import model.exceptions.LoginException;

public class LoginController implements Initializable {

	@FXML
	private Button backLogin;

	@FXML
	private Button btnLogar;

	@FXML
	private Button btnRegisterUser;

	@FXML
	private CheckBox checkEmployee;

	@FXML
	private CheckBox checkManager;

	@FXML
	private Button confirmRegister;

	@FXML
	private PasswordField password;

	@FXML
	private TextField password1;

	@FXML
	private TextField userName;

	@FXML
	void onClickLogar(ActionEvent event) {
		CommercialAutomationFacade commercialfacade = new CommercialAutomationFacade();
		
		ManagementUsers managUsers = ManagementUsers.getInstance();
		
		Class<? extends Entity> typeUser;
		
		try {
			typeUser = commercialfacade.loginUser(userName.getText(), password.getText());
			
			if (typeUser.getSimpleName().equals("Manager")) {
				Main.changeScreen("managements");
				
			} else if (typeUser.getSimpleName().equals("Employee")) {
				// Adicionar o caminho
			}
		} catch (LoginException e) {
			// e.printStackTrace();
			clearFields();
			Main.erroUser("Usuário incorreto");
		}
	}

	@FXML
	void onClickConfirmRegister(ActionEvent event) {
		CommercialAutomationFacade commercialfacade = new CommercialAutomationFacade();
		commercialfacade.checkRegister(userName.getText(), password.getText(), password1.getText(), checkManager,
				checkEmployee);
		commercialfacade.registerUser(userName.getText(), password.getText(), checkManager, checkEmployee);
		clearFields();
	}

	@FXML
	void onClickBackLogin(ActionEvent event) {
		settingsInitial();
	}

	@FXML
	void onClickRegister(ActionEvent event) {
		settingRegister();
	}

	@FXML
	void onClickCheckBoxManager(MouseEvent event) {
		if (checkManager.isSelected()) {
			checkEmployee.setSelected(false);
		}
	}

	@FXML
	void onClickCheckBoxEmployee(MouseEvent event) {
		if (checkEmployee.isSelected()) {
			checkManager.setSelected(false);
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		settingsInitial();

	}

	public void settingRegister() {
		btnLogar.setVisible(false);
		confirmRegister.setVisible(true);
		password1.setVisible(true);
		backLogin.setVisible(true);
		btnRegisterUser.setDisable(true);
		checkEmployee.setVisible(true);
		checkManager.setVisible(true);
	}

	public void settingsInitial() {
		confirmRegister.setVisible(false);
		checkManager.setVisible(false);
		checkEmployee.setVisible(false);
		password1.setVisible(false);
		backLogin.setVisible(false);
		btnLogar.setVisible(true);
		btnRegisterUser.setVisible(true);
		btnRegisterUser.setDisable(false);
	}
	
	public void clearFields() {
		userName.setText("");
		password.setText("");
		password1.setText("");
	}

}
