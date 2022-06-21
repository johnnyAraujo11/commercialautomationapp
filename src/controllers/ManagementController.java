package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class ManagementController implements Initializable {
	String[] typeManagment = { "Usuarios", "Fornecedores", "Produtos", "Vendas", "Clientes","Menu" };
	@FXML
	private Menu menuManagement;

	@FXML
	private Menu menuReport;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("Controle gerenciamentos");
		setMenuItems();	
	}

	public void setMenuItems() {
		for (int i = 0; i < typeManagment.length; i++) {
			MenuItem menuItem1 = new MenuItem(typeManagment[i]);
			menuManagement.getItems().add(menuItem1);
		}
	}
}
