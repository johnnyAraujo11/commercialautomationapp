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
	
	
	
	public void checkFieldsRegister(String userName, String password, String password1,CheckBox checkBoxManager, CheckBox checkBoxEmployee) throws LoginException {
		if(userName == "" || password == "" || password1 == "") {
			throw new LoginException();
		}
		if(!checkBoxManager.isSelected() && !checkBoxEmployee.isSelected()) {
			throw new LoginException();
		}
	}
	
	
	public void isExistUser(String userName) throws LoginException {
		Iterator<Entity> it = managUsers.getListEntity().iterator();
		Entity user;
		while (it.hasNext()) {
			user = it.next();
			if(userName.equals(user.getName())) 
				throw new LoginException();	
		}
	}
	
	public void samePassword(String password, String password1) throws LoginException {
		if(!password.equals(password1))
			throw new LoginException();		
	}
	
	
}
