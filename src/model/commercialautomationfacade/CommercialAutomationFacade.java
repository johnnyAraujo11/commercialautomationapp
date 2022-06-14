package model.commercialautomationfacade;

import application.Main;
import javafx.scene.control.CheckBox;
import model.CheckLoginUser;
import model.DAO.ManagementUsers;
import model.entitysSystem.Employee;
import model.entitysSystem.Entity;
import model.entitysSystem.Manager;
import model.exceptions.LoginException;

class GlobalVals {
	static String LOGGED;
}

public class CommercialAutomationFacade {
	private CheckLoginUser login;
	private ManagementUsers managUsers = ManagementUsers.getInstance();

	public CommercialAutomationFacade() {
		this.login = new CheckLoginUser();
	}

	public Class<? extends Entity> loginUser(String user, String password) throws LoginException {
		try {
			return login.login(user, password);	
		} catch (LoginException e) {
			throw e;
		}
	}

	
	
	public void checkRegister(String user, String password, String password1, CheckBox ChboxManager,
			CheckBox ChBoxEmployee) {

		try {
			this.login.checkFieldsRegister(user, password, password1, ChboxManager, ChBoxEmployee);
		} catch (LoginException e) {
			Main.erroUser("Campo vazio!");
		}

		try {
			this.login.isExistUser(user);
		} catch (LoginException e) {
			Main.erroUser("Usuário existente!");
		}

		try {
			this.login.samePassword(password, password1);
		} catch (LoginException e) {
			Main.erroUser("As senhas não coincidem.");
		}
	}

	public void registerUser(String userName, String password, CheckBox checkManager, CheckBox checkEmployee) {
		Manager manager;
		Employee employee;
		if (checkManager.isSelected()) {
			manager = new Manager(userName, password);
			managUsers.register(manager);

		} else if (checkEmployee.isSelected()) {
			employee = new Employee(userName, password);
			managUsers.register(employee);
		}
	}
}
