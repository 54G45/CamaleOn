package view;
import java.text.NumberFormat;
import java.util.Locale;

public class ExemploFormatoMoeda {
    public static void main(String[] args) {
        String valorString = "1224220";

        // Converter a string para um valor numérico
        double valor = Double.parseDouble(valorString) / 100;

        // Formatar o valor como moeda
        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        String valorFormatado = formatoMoeda.format(valor);

        System.out.println("Valor formatado: " + valorFormatado);
    }
}
