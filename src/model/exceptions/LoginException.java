package model.exceptions;

public class LoginException extends Exception{
	public LoginException() {
		super("Usuário incorreto");
	}
}
