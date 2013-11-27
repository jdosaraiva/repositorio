package br.com.caelum.palindromo.servico;

public class Palindromo {

    public boolean ehPalindromo(String frase) {

        String fraseFiltrada = frase.toUpperCase().replace(" ", "").replace("-", "");

        String fraseFiltradaReverse = new StringBuilder(fraseFiltrada).reverse().toString();
        
        for (int i = 0; i < fraseFiltrada.length(); i++) {
            if (fraseFiltrada.charAt(i) != fraseFiltradaReverse.charAt(i)) {
                return false;
            }
        }

        return true;
    }
    

}