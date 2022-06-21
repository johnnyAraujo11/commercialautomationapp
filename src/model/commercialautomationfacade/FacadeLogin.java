package model.commercialautomationfacade;

import application.Main;
import javafx.scene.control.CheckBox;
import model.CheckLoginUser;
import model.DAO.ManagementUsers;
import model.entitysSystem.Employee;
import model.entitysSystem.Entity;
import model.entitysSystem.Manager;
import model.exceptions.LoginException;

public class FacadeLogin {
	private CheckLoginUser login;
	private ManagementUsers managUsers = ManagementUsers.getInstance();

	public FacadeLogin() {
		this.login = new CheckLoginUser();
	}

	/**
	 * Método que recebe o usuário e a senha
	 * 
	 * @param user     Recebe o nome do usuário
	 * @param password Recebe a senha
	 * @return Retorna o tipo da classe que realiza o login (gerente ou funcionário)
	 * @throws LoginException Lança uma exceção.
	 */
	public Class<? extends Entity> loginUser(String user, String password) throws LoginException {
		try {
			return login.login(user, password);
		} catch (LoginException e) {
			throw e;
		}
	}

	/**
	 * Método que faz a verificação dos dados inseridos no registro.
	 * 
	 * @param isRegister    Verifica se está ação é de registro. True ou false
	 * @param user          Recebe o nome do usuário
	 * @param password      Recebe a senha do usuário
	 * @param password1     Recebe a senha novamente do usuário
	 * @param ChboxManager  Tipo gerente
	 * @param ChBoxEmployee Tipo funcionário
	 * @return Retorna true se as verificações forem bem sucedidas.
	 */
	public boolean checkRegister(boolean isRegister, String user, String password, String password1,
			CheckBox ChboxManager, CheckBox ChBoxEmployee) {
		boolean check = false;
		try {
			check = this.login.checkFieldsRegister(isRegister, user, password, password1, ChboxManager, ChBoxEmployee);
		} catch (LoginException e) {
			Main.erroUser("Campo vazio!");
		}

		if (isRegister) {
			try {
				this.login.isExistUser(user);
			} catch (LoginException e) {
				check = true;
				Main.erroUser("Usuário existente!");
			}
		}

		if (check && isRegister) {
			try {
				this.login.samePassword(password, password1);
			} catch (LoginException e) {
				Main.erroUser("As senhas não coincidem.");
			}
		}
		return check;
	}

	/**
	 * Registra um usuário na lista de usuários
	 * 
	 * @param userName      Recebe o nome do usuário
	 * @param password      Recebe a senha do usuário
	 * @param checkManager  Tipo gerente
	 * @param checkEmployee Tipo funcionáio
	 */
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
