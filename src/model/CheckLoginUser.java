package model;

import java.util.Iterator;

import javafx.scene.control.CheckBox;
import model.DAO.ManagementUsers;
import model.entitysSystem.Employee;
import model.entitysSystem.Entity;
import model.entitysSystem.Manager;
import model.exceptions.LoginException;

public class CheckLoginUser {
	ManagementUsers managUsers = ManagementUsers.getInstance();

	/**
	 * Método que verifica se o usuário e senha estão cadastrador e realiza o login.
	 *  
	 * @param userName
	 * @param password
	 * @return Retorna a classe que estiver fazendo o login no momento.
	 * @throws LoginException
	 */
	public Class<? extends Entity> login(String userName, String password) throws LoginException {

		Iterator<Entity> it = managUsers.getListEntity().iterator();
		Entity user;

		while (it.hasNext()) {
			user = (Entity) it.next();

			if (userName.equals(user.getName()) && user.getId().contains("Manag")) {
				Manager manager = (Manager) user;
				if (manager.getPassword().equals(password))
					return user.getClass();
				else
					throw new LoginException();

			} else if (userName.equals(user.getName()) && user.getId().contains("Empl")) {
				Employee employee = (Employee) user;
				if (employee.getPassword().equals(password))
					return user.getClass();
				else
					throw new LoginException();
			}
		}
		throw new LoginException();
	}

	/**
	 * Método que verifica se os campos estão preenchidos
	 * 
	 * @param register         Recebe true se for realizar um registro.
	 * @param userName         Recebe o nome do usuário
	 * @param password         Recebe a senha do usuário
	 * @param password1        Reecbe a senha novamente
	 * @param checkBoxManager  recebe tipo de usuário gerente
	 * @param checkBoxEmployee recebe tipo de usuário funcionário
	 * @return Retorna true se os campos estiverem preenchidos e false se não.
	 * @throws LoginException
	 */
	public boolean checkFieldsRegister(boolean register, String userName, String password, String password1,
			CheckBox checkBoxManager, CheckBox checkBoxEmployee) throws LoginException {
		boolean Fields = true;
		if (userName == "" || password == "" || password1 == "" && register) {
			Fields = false;
			throw new LoginException();
		}
		if (!checkBoxManager.isSelected() && !checkBoxEmployee.isSelected() && register != false) {
			throw new LoginException();
		}
		return Fields;
	}

	/**
	 * Verifica se existe o usuário na lista
	 * 
	 * @param userName Recebe o nome do usuário
	 * @throws LoginException Lança uma exceção quando não encontra o usuário.
	 */
	public void isExistUser(String userName) throws LoginException {
		Iterator<Entity> it = managUsers.getListEntity().iterator();
		Entity user;
		while (it.hasNext()) {
			user = it.next();
			if (userName.equals(user.getName()))
				throw new LoginException();
		}
	}

	/**
	 * Verifica se as senha são idênticas.
	 * 
	 * @param password Recebe a senha
	 * @param password1 Recebe a segunda senha
	 * @throws LoginException Se não forem idênticas lança uma exceção
	 */
	public void samePassword(String password, String password1) throws LoginException {
		if (!password.equals(password1))
			throw new LoginException();
	}

}
