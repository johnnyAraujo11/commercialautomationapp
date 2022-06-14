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

import java.util.LinkedList;

import model.entitysSystem.Entity;
import model.entitysSystem.ItemMenu;
import model.entitysSystem.Sale;

/**
 * A classe <b>ManagementSales</b> define um tipo de dado que será utilizado
 * para a criação da estrutura da lista, para fins de gerenciamento.
 * 
 * @since 11/03/2022
 * @version 3.0
 * @author Johnny Araujo e Lyrton Marcell
 *
 */
public class ManagementSales extends Management {
	/**
	 * Atributo constante que representa o prefixo de um venda
	 */
	private static final String PREFIX = "sale-";

	/**
	 * Adiciona um item do cardápio a uma venda.
	 * 
	 * @param sale
	 * @param item
	 */
	public void addItemToSale(Sale sale, ItemMenu item, ManagementProducts mProducts) {
		sale.addItemToSale(item);
		
		
	}

	/**
	 * Adiciona um venda a lista de vendas
	 * 
	 * @param sale
	 */
	public void register(Sale sale) {
		super.register(sale, PREFIX);
	}

	/**
	 * Exibe todos os itens da lista de itens.
	 */
	public boolean show() {
		return super.show();
	}

	/**
	 * Deleta uma venda da lista de vendas pelo id identificado.
	 * 
	 * @param id Recebe o id ser encontrado.
	 */
	public Entity delete(String id) {
		return super.delete(id);
	}

	/**
	 * Edita um tipo de pagamento de uma venda.
	 * 
	 * @param id          Pesquisa o id da venda.
	 * @param typePayment Recebe o novo tipo de pagamento.
	 */
	public void editPayment(String id, String typePayment) {
		for (int i = 0; i < super.getListEntity().size(); i++) {
			if (id.equals(super.getListEntity().get(i).getId())) {
				if (typePayment != null && !typePayment.isEmpty()) {
					((Sale) super.getListEntity().get(i)).setTypePayment(typePayment);
				}
			}
		}
	}

	/**
	 * Remove um item de uma venda.
	 * 
	 * @param id     Recebe o id da venda a ser encontrada.
	 * @param idItem Recebe o id do item a ser encontrado para remoção do item.
	 */
	public void editRemoveitens(String id, String idItem) {
		Sale temp = findSale(id);
		if (temp != null) {
			LinkedList<ItemMenu> listItem = (LinkedList<ItemMenu>) temp.getListItems();
			for (int k = 0; k < listItem.size(); k++) {
				if (listItem.get(k).getId().equals(idItem)) {
					temp.setTotal(temp.getTotal() - listItem.get(k).getPrice());
					listItem.remove(k);
				}
			}
		}
	}

	/**
	 *Método que procura uma venda na lista de vendas 
	 * @param id recebe o id do venda desejada
	 * @return retorna um objeto do tipo Sale
	 */
	public Sale findSale(String id) {
		for (int i = 0; i < super.getListEntity().size(); i++) {
			if (id.equals(super.getListEntity().get(i).getId())) {
				return ((Sale) super.getListEntity().get(i));
			}
		}
		return null;
	}
}