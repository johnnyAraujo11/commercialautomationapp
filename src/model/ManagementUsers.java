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
package model;

import java.util.LinkedList;

/**
 * <b> A classe ManagementUsers </b> define um tipo de dado que será utilizado
 * para a criação da estrutura da lista, que será utilizado para fins de
 * gerenciamento.
 * 
 * @since 11/03/2022
 * @version 3.0
 * @author Johnny Araujo e Lyrton Marcell
 *
 */ 
public class ManagementUsers extends Management {
	/**
	 * Atributo constante que representa o prefixo de um gerente
	 */
	private static final String PREFIXMANAGER = "Manag-";
	/**
	 * Atributo constante que representa o prefixo de um funcionário
	 */
	private static final String PREFIXEMPLOYEE = "Empl-";

	/**
	 * Registra o usuário gerando os prefixos adequados para cada cargo ocupado
	 * (gerente e fornecedor).
	 * 
	 * @param user
	 */
	public void register(Entity user) {

		if (user instanceof Manager) {
			super.register(user, ManagementUsers.PREFIXMANAGER);
		}
		if (user instanceof Employee) {
			super.register(user, ManagementUsers.PREFIXEMPLOYEE);
		}
	}

	/**
	 * Exibe a lista de usuários.
	 */
	public boolean show() {
		return super.show();
	}

	/**
	 * Edita o nome e a senha relacionado ao id de cada usuário cadastrado
	 * 
	 * @param id       Recebe o id do usuário alvo
	 * @param name     Novo nome
	 * @param password Nova senha
	 */
	public void edit(String id, String name, String password) {
		for (int i = 0; i < super.getListEntity().size(); i++) {
			if (id.equals(super.getListEntity().get(i).getId())) {
				if (name != null) {
					super.getListEntity().get(i).setName(name);
				}
				if (password != null && !password.isEmpty()) {

					Entity temp = super.getListEntity().get(i);

					if (temp instanceof Manager) {
						((Manager) temp).setPassword(password);
					}
					if (temp instanceof Employee) {
						((Employee) temp).setPassword(password);
					}
				}
			}

		}
	}

	/**
	 * Muda um gerente para se torna um funcionário ou muda um funcionário para
	 * gerente.
	 * 
	 * @param id busca pelo id especificado
	 */
	public boolean changePosition(String id) {
		LinkedList<Entity> list = super.getListEntity();
		for (int i = 0; i < list.size(); i++) {
			if (id.equals(list.get(i).getId())) {
				if (list.get(i) instanceof Manager) {
					Manager temp = ((Manager) this.delete(id));
					Employee newEmployee = new Employee(temp.getName(), temp.getPassword());
					this.register(newEmployee);
					return true;
				} else if (list.get(i) instanceof Employee) {
					Employee temp = ((Employee) this.delete(id));
					Manager newManager = new Manager(temp.getName(), temp.getPassword());
					this.register(newManager);
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Deleta o usuário relacionado ao id passado por parâmetro.
	 * 
	 * @param id recebe o id 
	 */
	public Entity delete(String id) {
		return super.delete(id);
	}
	
	
	public boolean verifyUser(String user, String password) {
		
		return false;
	}

}
