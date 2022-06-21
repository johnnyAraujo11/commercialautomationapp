package model.entitysSystem;

import java.util.LinkedList;

public class Client extends Entity {
	private String cpf;
	private String name;
	private String phone;
	private String email;
	private LinkedList<Sale> listBuy;

	public Client(String name, String cpf, String phone, String email) {
		super(name);
		this.cpf = cpf;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.listBuy = null;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LinkedList<Sale> getListBuy() {
		return listBuy;
	}

	public void setListBuy(LinkedList<Sale> listBuy) {
		this.listBuy = listBuy;
	}

	public LinkedList<Sale> getListSales() {
		return listBuy;
	}

	public void setListSales(LinkedList<Sale> listSales) {
		this.listBuy = listSales;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
