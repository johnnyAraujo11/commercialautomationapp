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
 * estrutura de um produto. <b>Product</b> herda de <b>'Entity'</b> que possui
 * mais atribuitos para a sua criação.
 * 
 * @since 11/03/2022
 * @version 3.0
 * @author Johnny Araujo e Lyrton Marcell
 */
public class Product extends Entity {
	/**
	 * Preço da venda
	 */
	private float price;
	/*
	 * Validade do produto em formato de data (dd/MM/yyy)
	 */
	private String validity;

	/**
	 * Quantidade de produtos
	 */
	private int quantity;  

	/**
	 * Unidade de medida do produto
	 */
	private String greatness;

	/**
	 *  Peso de um item
	 */
	private float weightUnity;

	/**
	 * Fornecedor que fornece o produto
	 */
	private Provider providerTheOfProduct;
	/*
	 * Peso total do produto
	 */
	private float weightTotal;

	public Provider getProviderTheOfProduct() {
		return providerTheOfProduct;
	}

	public void setProviderTheOfProduct(Provider providerTheOfProduct) {
		this.providerTheOfProduct = providerTheOfProduct;
	}

	/**
	 * Recebe o atribuitos para a criação de um novo produto.
	 * @param name     Nome do produto
	 * @param price    Preco do produto
	 * @param validity validade do produto formato(dd/MM/yyy)
	 * @param quantity quantidade do produto
	 * @param greatness unidde de medida do produto
	 * @param weightUnity peso de um único produto
	 * @param provider fornecedor que fornece o produto
	 */
	public Product(String name, float price, String validity, int quantity, String greatness, float weightUnity, Provider provider) {
		super(name);
		this.price = price;
		this.validity = validity;
		this.quantity = quantity;
		this.greatness = greatness;
		this.weightUnity = weightUnity;
		this.weightTotal = this.quantity * this.weightUnity;
		this.providerTheOfProduct = provider;
	}

	public float getWeightTotal() {
		return weightTotal;
	}

	public void setWeightTotal(float weightTotal) {
		this.weightTotal = weightTotal;
	}

	public float getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getGreatness() {
		return greatness;
	}

	public void setGreatness(String greatness) {
		this.greatness = greatness;
	}

	public float getWeightUnity() {
		return weightUnity;
	}

	public void setWeightUnity(float weightUnity) {
		this.weightUnity = weightUnity;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getValidity() {
		return validity;
	}

	public void setValidity(String validity) {
		this.validity = validity;
	}

	/**
	 * A public String toString() é utilizada como formatação do modo de exibição da
	 * informações de um produto, criando um modelo a ser seguido.
	 */
	public String toString() {
		String model;

		model = String.format("Id---------------------------: %s\n", super.getId())
				+ String.format("Nome do Produto-------------: %s\n", super.getName())
				+ String.format("Preço do produto------------: %.2f\n", this.price)
				+ String.format("Validade do produto---------: %s\n", this.validity)
				+ String.format("Quantidade total---------: %.2f %s\n", this.weightTotal,this.greatness);
		return (model);
	}

}
