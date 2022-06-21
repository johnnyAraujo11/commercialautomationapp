package model.DAO;

import java.util.LinkedList;

import model.entitysSystem.Client;
import model.entitysSystem.Entity;
import model.entitysSystem.Product;
import model.entitysSystem.Provider;

public class ManagmentClients extends Management {

	private static final String PREFIXCLIENT = "Cli-";

	private static ManagmentClients mC = new ManagmentClients();

	private ManagmentClients() {
	}

	public static ManagmentClients getInstance() {
		return mC;
	}

	
	
	public void register(Client client) {
		super.register(client, PREFIXCLIENT);
	}
	
	
	public Entity delete(String id) {
		return super.delete(id);

	}

	public LinkedList<Entity> getAll() {
		return super.getListEntity();
	}

	public void update(String id, String name, String cpf, String phone, String email) {
		Entity client = findClient(id);
		if (client != null) {
			client.setName(name);
			((Client) client).setCpf(cpf);
			((Client) client).setPhone(phone);
			((Client) client).setEmail(email);
		}
	}

	public Client findClient(String id) {
		for (int i = 0; i < super.getListEntity().size(); i++) {
			if (id.equals(super.getListEntity().get(i).getId())) {
				return ((Client) super.getListEntity().get(i));
			}
		}
		return null;
	}
}
