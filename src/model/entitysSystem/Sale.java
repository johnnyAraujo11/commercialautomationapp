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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

/**
 * Recebe o atribuitos para a criação de uma nva venda. <b>Sale</b> herda de
 * <b>'Entity'</b> que possui mais atribuitos para a sua criação.
 * 
 * @since 11/03/2022
 * @version 3.0
 * @author Johnny Araujo e Lyrton Marcell
 *
 */
public class Sale extends Entity {
	
	private int clientNote;
	
	/**
	 * Data e hora da venda
	 */
	private String dataHour;
	/**
	 * Valor total da venda
	 */
	private double total;
	/**
	 * Lista de itens da venda
	 */
	private LinkedList<ItemMenu> listItems;
	/**
	 * Tipo de pagamento
	 */
	private String typePayment;

	/**
	 * Inicia as variáveis 'listItems', 'total' = 0 e gera uma data no atributo
	 * 'dataHour'
	 */
	public Sale() {
		this.listItems = new LinkedList<ItemMenu>();
		this.total = 0;
		this.dataHour = this.generateDate();
	}

	/**
	 * Recebe o item a ser adicionado na lista de itens da venda
	 * 
	 * @param item
	 */
	public void addItemToSale(ItemMenu item) {
		this.listItems.add(item);
		this.total = this.total + (double) item.getPrice();

	}

	public String getDataHour() {
		return dataHour;
	}

	public void setDataHour(String dataHour) {
		this.dataHour = dataHour;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public LinkedList<ItemMenu> getListItems() {
		return listItems;
	}

	public void setListItems(LinkedList<ItemMenu> listItems) {
		this.listItems = listItems;
	}

	public String getTypePayment() {
		return typePayment;
	}
 
	public void setTypePayment(String typePayment) {
		this.typePayment = typePayment;
	}

	/**
	 * Gera uma data de hora da máquina local.
	 * 
	 * @return Retorna uma data e hora no formato <b>'dd/MM/yyyy HH:mm:ss'</b>
	 */
	private String generateDate() {
		Date time = Calendar.getInstance().getTime();
		return new SimpleDateFormat("dd/MM/yyyy").format(time);
	}

	/**
	 * A public String toString() é utilizada como formatação do modo de exibição da
	 * informações de um produto, criando um modelo a ser seguido.
	 */
	public String toString() {
		String model;

		model = String.format("id--------------------------: %s\n", super.getId())
				+ String.format("Total-----------------------: %s\n", this.getTotal())
				+ String.format("Data e Hora-----------------: %s\n", this.getDataHour())
				+ String.format("Tipo de pagamento-----------: %s\n", this.typePayment);
				
				//+ String.format("\n--------------- Lista de itens -------------: \n%s\n", this.listItems.toString());

		return (model);
	}

}