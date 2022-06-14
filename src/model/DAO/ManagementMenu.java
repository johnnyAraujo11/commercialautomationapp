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
package model.DAO;

import model.entitysSystem.Entity;
import model.entitysSystem.ItemMenu;
import model.entitysSystem.Product;

/**
 * A classe ManagementMenu define um tipo de dado que será utilizado para fins
 * de gerenciamento de itens.
 * 
 * @since 11/03/2022
 * @version 3.0
 * @author Johnny Araujo e Lyrton Marcell
 */
public class ManagementMenu extends Management {
	/**
	 * Atributo constante que representa o prefixo de um menu(ou item do cardápio)
	 */
	private static String PREFIX = "item-";

	/**
	 * Inicia o contrutor da superclasse
	 */
	public ManagementMenu() {
		super();
	}

	/**
	 * Adiciona um produto na lista de itens
	 * 
	 * @param menu
	 * @param product
	 */
	public void addProduct(ItemMenu itemMenu, Product product) {
		itemMenu.addProduct(product);
	}

	/**
	 * Registra um item ao cardápio
	 * 
	 * @param itemMenu
	 */
	public void register(ItemMenu itemMenu) {
		super.register(itemMenu, PREFIX);
	}

	/**
	 * Exibe a lista de itens do cardápio com a lista de produtos associado a item
	 */
	public boolean show() {
		return super.show();
	}

	/**
	 * Deleta um item da lista de itens
	 * 
	 * @Param id
	 */
	public Entity delete(String id) {
		return super.delete(id);
	}

	/**
	 * Edita um item a partir do id especificado. É possível a edição da descrição
	 * do item e o preço
	 * 
	 * @param id
	 * @param description descrição a ser alterada
	 * @param price       preço a ser alterado
	 */
	public void edit(String id, String description, double price) {
		ItemMenu itemMenu = findItemMenu(id);
		if (itemMenu != null) {
			if (description != null && !description.isEmpty()) {
				itemMenu.setDescription(description);
			}
			if (price > 0) {
				itemMenu.setPrice(price);
			}
		}

	}

	/**
	 *Método que procura um item na lista de itens 
	 * @param id recebe o id do item desejado
	 * @return retorna um objeto do tipo ItemMenu
	 */
	public ItemMenu findItemMenu(String id) {
		for (int i = 0; i < super.getListEntity().size(); i++) {
			if (id.equals(super.getListEntity().get(i).getId())) {
				return ((ItemMenu) super.getListEntity().get(i));
			}
		}
		return null;
	}
}
