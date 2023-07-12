package model.valida;

public abstract class Valida {

	public static boolean eMail(String texto) {
		return texto.matches("[\\w.-]+@gmail.com$");
	}

	public static boolean forcaSenha(String texto) {

		return texto.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{8,}$");
	}

	public static boolean preco(String texto) {

		return texto.matches("^(\\d{1,3}(\\.\\d{3})*|\\d+)(\\,\\d{2})?$");
	}

}
