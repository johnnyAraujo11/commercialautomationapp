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

import java.util.ArrayList;
import java.util.LinkedList;


import model.entitysSystem.Entity;
import model.entitysSystem.ItemMenu;
import model.entitysSystem.Product;
import model.exceptions.ManagementProductsException;

/**
 * Classe é responsável por gerenciar um produto fazendo edicão dos seus
 * atribuitos, armazenando um produto em lista e deletando um produto presente
 * na lista.
 * 
 * @since 11/03/2022
 * @version 3.0
 * @author Johnny Araujo e Lyrton Marcell
 *
 */
public class ManagementProducts extends Management {
	/*
	 * Atributo constante que representa o prefixo de um produto
	 */
	private static final String PREFIX = "prod-";
	
	/**
	 * Inicia o contrutor da superclasse
	 */
	public ManagementProducts() {
		super();
	}

	/**
	 * Recebe uma lista de itens de uma venda para realizar a atualização dos
	 * produtos no estoque
	 * 
	 * @param listProducts
	 */
	public void updateProductsStock(LinkedList<Entity> listItem) throws ManagementProductsException {
		// lista de items
		for (int i = 0; i < listItem.size(); i++) { 
			ItemMenu item = ((ItemMenu)listItem.get(i));
			// lista de produtos
			ArrayList<Product> listProducts = item.getlistProducts();
			for (int j = 0; j < listProducts.size(); j++) {
				// procura o produto do item no estoque
				for (int k = 0; k < super.getListEntity().size(); k++) {
					if (super.getListEntity().get(k).getId().equals(listProducts.get(j).getId())) {
						float weightUnity = listProducts.get(j).getWeightUnity();
						float weightTotal = listProducts.get(j).getWeightTotal();

						if (weightUnity <= weightTotal) {
							listProducts.get(j).setWeightTotal(weightTotal - weightUnity);
						} else {
							ManagementProductsException e = new ManagementProductsException();
							throw e;
						}
					}
				}
			}
		}
	}
 
	/**
	 * Adiciona um produto
	 * 
	 * @param product
	 */
	public void register(Product product) {
		super.register(product, PREFIX);
	}
 
	/**
	 * Lista todos os produtos
	 */
	public boolean show() {
		return super.show();
	}

	/**
	 * Deleta um produto especificado pelo id
	 */
	public Entity delete(String id) {
		return super.delete(id);
	}

	/**
	 * Metódo permite a edição dos dados de um produto pelo id informado
	 * 
	 * @param id
	 * @param name
	 * @param price
	 * @param validity
	 */
	public void edit(String id, String name, float price, String validity) {
		Product foundProduct = findProduct(id);
	
		if(foundProduct != null) {
			if (name != null && !name.isEmpty()) {
				foundProduct.setName(name);
			}
			if (price > 0) {
				foundProduct.setPrice(price);
			}
			if (validity != null && !validity.isEmpty()) {
				foundProduct.setValidity(validity);
			}
		}
	}
 
	/**
	 *Método que procura um produto na lista de produtos 
	 * @param id recebe o id do prduto desejado
	 * @return retorna um objeto do tipo Product
	 */
	public Product findProduct(String id) {
		for (int i = 0; i < super.getListEntity().size(); i++) {
			if (id.equals(super.getListEntity().get(i).getId())) {
				return ((Product)super.getListEntity().get(i));
			}
		}
		return null;
	}
}
