package model.entitysSystem;

public class Client {
	private String cpf;
	private String name;
	private String phone;

	public Client(String cpf, String name, String phone) {
		this.cpf = cpf;
		this.name = name;
		this.phone = phone;
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
