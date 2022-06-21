package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ManagementProvider implements Initializable {
	@FXML
	private TextField address;

	@FXML
	private TextField cnpj;

	@FXML
	private ListView<?> listProviders;

	@FXML
	private Button register;

	@FXML
	private TextField userName;

	@FXML
	void onClickDelete(ActionEvent event) {

	}

	@FXML
	void onClickEdit(ActionEvent event) {

	}

	@FXML
	void onClickRegister(ActionEvent event) {

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("controler fornecedor");

	}

}
