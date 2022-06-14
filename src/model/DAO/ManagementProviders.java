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
import model.entitysSystem.Product;
import model.entitysSystem.Provider;

/**
 * Classe responsável por gerenciar fornecedores, editar, deletar, registrar e
 * exibir.
 * 
 * @since 11/03/2022
 * @version 3.0
 * @author Johnny Araujo e Lyrton Marcell
 *
 */
public class ManagementProviders extends Management {
	/**
	 * Atributo constante que representa o prefixo de um fornecedor
	 */
	private static String PREFIX = "prov-";
 
	/**
	 * Inicia o construtor da superclasse
	 */
	public ManagementProviders() {
		super();
	}

	/**
	 * Adiciona um produto na lista de produtos do fornecedor
	 * 
	 * @param provider fornecedor o qual será adicionado o produto
	 * @param product  produto a ser adicionado a fornecedor
	 */
	public void addProductInProvider(Provider provider, Product product) {
		provider.addProduct(product);
	}

	/**
	 * Percorre a lista de fornecedor e adiciona no arquivo todos os elementos
	 * 
	 * @param provider fornecedor que deseja adicionar
	 */
	public void register(Provider provider) {
		super.register(provider, PREFIX);
	}

	/**
	 * Exibe a lista de fornecedores.
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
	 * Metódo permite a edição dos dados de um fornecedor pelo id informado
	 * 
	 * @param id      Recebe o id do fornecedor alvo
	 * @param name    Nome a ser substituído
	 * @param cnpj    CNPJ a ser substituído
	 * @param address Endereço a ser substituído
	 */
	public void edit(String id, String name, String cnpj, String address) {
		Entity provider = findProvider(id);
			if(provider != null) {
				if (cnpj != null) {
					((Provider) provider).setCnpj(cnpj);
				}
				if (name != null) {
					provider.setName(name);
				}
				if (address != null) {
					((Provider) provider).setAddress(address);
				}
			}
	}

	/** Procura o fornecedor pelo id
	 * @param id recebe o id para realizar a busca
	 * @return retorna nulo caso não o encontre
	 */
	public Provider findProvider(String id) {
		for(int i = 0; i < super.getListEntity().size(); i++) {
			if (id.equals(super.getListEntity().get(i).getId())) {
				System.out.println("Encontrou o forn");
				return ((Provider)super.getListEntity().get(i));
			}
		}
		return null;

	}

}