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

import java.util.ArrayList;

/**
 * ItemMenu é uma classe que possui atributos e métodos exclusivos de um itens.
 * Essa classe herda de Entity que possui mais atributos a ser utilizados para a
 * criação de um item do cardápio.
 * 
 * @since 11/03/2022
 * @version 3.0
 * @author Johnny Araujo e Lyrton Marcell
 * 
 */
public class ItemMenu extends Entity {
	/**
	 * Preço do item
	 */
	private double price;
	/**
	 * Categoria do item
	 */
	private String category;
	/**
	 * Descrição do item 
	 */
	private String description;
	/**
	 * Lista de produtos
	 */
	private ArrayList<Product> listProducts;

	/**
	 * Recebe como parâmentro nome, preço, categoria, e descrição do item. 
	 * Inicia a lista de produto e seus atributos
	 * @param name Nome do item
	 * @param price Preço do item
	 * @param category Categoria do item
	 * @param description Descrição do item
	 */
	public ItemMenu(String name, float price, String category, String description) {
		super(name);
		this.listProducts = new ArrayList<Product>();
		this.price = price;
		this.category = category;
		this.description = description;
	}
 
	/**
	 * Método que adiciona um produto à lista de item do cardápio.
	 * 
	 * @param product Produto a ser adicionado
	 */
	public void addProduct(Product product) {
		this.listProducts.add(product);
	}

	/**
	 * A public String toString() é utilizada como formatação do modo de exibição da
	 * informações de um item do cardápio, criando um modelo a ser seguido.
	 */
	public String toString() {
		String model;

		model = String.format("Id--------------------------: %s\n", super.getId())
				+ String.format("Nome do Produto-------------: %s\n", super.getName())
				+ String.format("Preço do produto------------: %.2f\n", this.price)
				+ String.format("Descrição-------------------: %s\n", this.description);

		return (model);
	}

	public ArrayList<Product> getlistProducts() {
		return listProducts;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price2) {
		this.price = price2;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
