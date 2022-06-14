package model.exceptions;


public class ManagementProductsException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ManagementProductsException() {
		super("Estoque de produtos vazio");
		
	}
}
