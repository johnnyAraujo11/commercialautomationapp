package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;


public class ManagementController implements Initializable {

	@FXML
	private MenuBar menuBar;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("Controle gerenciamentos");
	}

}
