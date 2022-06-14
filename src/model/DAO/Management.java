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

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.UUID;

/**
 * Classe abstrata <b>'Management'</b> é reponsável pela criação dos métodos e
 * atribuitos que serão herdadas pelas suas subclasses que inclui
 * <b>'ManagemetProducts'</b>... Nessa classe contém os métode de editar,
 * deletar, registrar e exibir um objeto do tipo Entity.
 * 
 * @since 11/03/2022
 * @version 3.0
 * @author Johnny Araujo e Lyrton Marcell
 */
public abstract class Management {
	/**
	 * Map é uma hash que armazena todos os ids de uma Entity quando criada. Essa
	 * hash é sempre consultada para não permitir a criação de ids idênticos.
	 */
	private Map<String, String> hash;
	/**
	 * listEntity é uma lista que será armazenada uma entidade, por exemplo,
	 * produtos, funcionário, fornecedor...
	 */
	private LinkedList<Entity> listEntity;

	public Management() {
		this.hash = new HashMap<String, String>();
		this.listEntity = new LinkedList<Entity>();
	}

	/**
	 * Recebe uma entidade: usuário, produto, Item de menu ou fornecedor e adiciona
	 * na lista.
	 * 
	 * @param entity Entidade criada, produto, fornecedor ...
	 * @param prefix Prefixo no qual representa a entidade, por exemplo, 'prod-' de
	 *               produto.
	 */
	protected void register(Entity entity, String prefix) {
		entity.setId(this.generateId(prefix));
		this.listEntity.addLast(entity);
	}

	/**
	 * Lista todos as entidades presentes na lista
	 */
	protected boolean show() {
		if (this.listEntity.size() == 0) {
			return false;
		} else {
			for (int i = 0; i < this.listEntity.size(); i++) {
				System.out.println(this.listEntity.get(i).toString());
			}
		}
		return true;
	}

	/**
	 * Remove uma entidade a partir de um id especificado
	 * 
	 * @param id
	 */
	protected Entity delete(String id) {
		Entity obj = null;
		for (int i = 0; i < this.listEntity.size(); i++) {
			if (this.listEntity.get(i).getId().equals(id)) {

				obj = this.listEntity.remove(i);
				this.hash.remove(id, "");
			}
		}
		return obj;
	}

	public LinkedList<Entity> getListEntity() {
		return this.listEntity;
	}

	/**
	 * Gera uma string no formato UUID
	 * 
	 * @param prefix
	 * @return retorna uma string, por exemplo,
	 *         'eb880172-30c4-4025-ab48-5418ffff6e27'
	 */
	public final String generateHashString(String prefix) {
		UUID uuid = UUID.randomUUID();
		String hashString = uuid.toString();
		// chave gerada para por na hash
		Integer key = this.convertHashStringtoInt(hashString);
		while (this.hash.containsKey(prefix + key)) {
			uuid = UUID.randomUUID();
			hashString = uuid.toString();
			key = this.convertHashStringtoInt(hashString);
		}
		return hashString;
	}

	/**
	 * Retorna um id único
	 * 
	 */
	public final String generateId(String prefix) {
		String hashString = this.generateHashString(prefix);
		String id = this.convertHashStringtoInt(hashString).toString();
		this.hash.put(prefix + id, "");
		return prefix + id;
	}

	/**
	 * Recebe uma string e retonar o resto da divisão de 13 + tamanho da lista
	 * 
	 * @param hashString
	 * @return
	 */
	private final Integer convertHashStringtoInt(String hashString) {
		return Math.abs(hashString.hashCode() % (13 + this.hash.size()));
	}

}
