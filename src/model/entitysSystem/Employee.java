/*******************************************************************************
Autor: Johnny Araujo e Lyrton Marcell
Componente Curricular: Algoritmos I
Concluido em: 11/05/2022
Declaro que este código foi elaborado por mim de forma individual e não contém nenhum
trecho de código de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
******************************************************************************************/
package model.entitysSystem;

/**
 * Essa classe define os tipos de dados que serão utlizados para a criação da
 * estrutura de funcionário. Employee herda de <b>'Entity'</b> que possui mais
 * atribuitos para a sua criação.
 * 
 * @since 11/03/2022
 * @version 3.0
 * @author Johnny Araujo e Lyrton Marcell
 */
public class Employee extends Entity {
	/**
	 * Senha de uma funcionário
	 */
	private String password;
	
	/**
	 * Recebe o nome e senha para a criação de um novo usuário
	 * @param name
	 * @param password
	 */
	public Employee(String name, String password) {
		super(name);
		this.setPassword(password);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * A public String toString() é utilizada como formatação do modo de exibição da
	 * informações de um funcionário, criando um modelo a ser seguido.
	 */
	public String toString() {
		String model;

		model = String.format("id--------------------------: %s\n", super.getId())
				+ String.format("Nome do funcionário----------: %s\n", super.getName())
				+ String.format("Senha----------: %s\n", this.getPassword());
		return (model);
	}
}
