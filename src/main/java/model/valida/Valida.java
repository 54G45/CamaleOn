package model.valida;

import java.text.Normalizer;
import java.util.regex.Pattern;

public abstract class Valida {
	
	public static boolean StringCaixaAltaBaixa(String str) {
		return str.matches("[A-Z][a-z]{1,}");
	}
	
	public static boolean numero(int numero) {
		return String.valueOf(numero).matches("[0-9]");
	}
	
	public static boolean numeros(int numero) {
		return String.valueOf(numero).matches("[0-9]{3}");
	}
	
	public static boolean cep(String cep) {
		return !cep.matches("[0-9]{5}\\-[0-9]{2}");
	}
	
	public static boolean digito(String digito) {
		return digito.matches("\\d{3}"); //[0-9]{3}
	}
	
	//validar 3 caracters com numero, texto ou carcteres especiais
	public static boolean caracter(String texto) {
		return texto.matches("..."); 
	}
	
	public static String removeCEP(String cep) {
		return cep.replace("-", "");
	}
	
	public static String removeCPF(String cpf) {
		return cpf.replace(".", "").replace("-", "");
	}
	
	//remove acentos
	public static String removeAcentos(String texto) {
		String nfdNormalizedString = Normalizer.normalize(texto, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(nfdNormalizedString).replaceAll("");
	}
	public static boolean eMail(String texto) {
		return texto.matches("[\\w.-]+@gmail.com$"); 
	}
	public static boolean forcaSenha(String texto) {
		
		return texto.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{8,}$"); 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
