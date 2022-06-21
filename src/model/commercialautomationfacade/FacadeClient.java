package model.commercialautomationfacade;

import java.util.LinkedList;

import model.DAO.ManagmentClients;
import model.entitysSystem.Client;
import model.entitysSystem.Entity;

public class FacadeClient {
	ManagmentClients mangClient = ManagmentClients.getInstance();

	public boolean checkData(String name, String cfp, String phone, String email) {

		// verificar se os campos estão vazios

		// Verificar se já existe o client cadastrado pelo cpf

		return true;
	}

	public void registerClient(String name, String cpf, String phone, String email) {
		if (checkData(name, cpf, phone, email)) {
			Client client = new Client(name, cpf, phone, email);
			mangClient.register(client);	
		}
	}

	
	public LinkedList<Entity> getClients() {
		LinkedList<Entity> listClient = mangClient.getAll();
		return listClient != null ? listClient : null;
	}
	
	
	public void deleteClient(Entity client) {
		mangClient.delete(client.getId());
	}
}
