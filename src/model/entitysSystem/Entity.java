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

/**
 * Classe abstrata na qual é reponsável pela criação dos métodos e atribuitos
 * que serão herdados para as suas subclasses.
 * 
 * @since 11/03/2022
 * @version 3.0
 * @author Johnny Araujo e Lyrton Marcell
 *
 */
public abstract class Entity {
	/**
	 * id é um atributo para identificar uma entidade no sistema
	 */
	protected String id;
	/**
	 * Atribui o nome a uma entidade
	 */
	protected String name;

	/**
	 * Recebe o nome a ser atribuito a variável <b>'name'</b>
	 * 
	 * @param name
	 */
	public Entity(String name) {
		this.name = name;
	}
 
	/**
	 * Construtor sem inicação de variáveis
	 */
	public Entity() {

	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
