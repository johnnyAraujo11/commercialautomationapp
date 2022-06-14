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

import java.util.LinkedList;

/**
 * Recebe o atribuitos para a criação de um novo fornecedor.
 * 
 * @since 11/03/2022
 * @version 3.0
 * @author Johnny Araujo e Lyrton Marcell
 *
 */
public class Provider extends Entity {
	/**
	 * cnpj do fornecedor
	 */
	private String cnpj;
	/**
	 * Endereço do fornecedor
	 */
	private String address;
	/**
	 * lista de produtos fornecidos pelo fornecedor
	 */
	private LinkedList<Product>listProduct;

	/**
	 * Recebe como parametro nome, cnpj e endereço todos em forma de string, sendo
	 * que nome é um atributo herdado de Entity e gera uma lista, na qual será
	 * manipulado os produtos fornecidos pelo respectivo fornecedor.
	 * 
	 * @param name
	 * @param cnpj
	 * @param address
	 */
	public Provider(String name, String cnpj, String address) {
		super(name);
		this.cnpj = cnpj;
		this.address = address;
		this.listProduct = new LinkedList<Product>();
	}

	public String getAddress() {
		return address;
	}
 
	public void setAddress(String address) {
		this.address = address;
	}

	public LinkedList<Product> getListProduct() {
		return listProduct;
	}

	public void setListProduct(LinkedList<Product> listProduct) {
		this.listProduct = listProduct;
	}

	public void addProduct(Product product) {
		this.listProduct.add(product);
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	/**
	 * A public String toString() é utilizada como formatação do modo de exibição da
	 * informações de um produto, criando um modelo a ser seguido.
	 */

	public String toString() {
		String model;

		model = String.format("id--------------------------: %s\n", super.getId())
				+ String.format("Nome do fornecedor----------: %s\n", super.getName())
				+ String.format("CNPJ------------------------: %s\n", this.cnpj)
				+ String.format("Endereço--------------------: %s\n", this.address);
		return (model);
	}
}
