package br.com.caelum.investimento;

public class RealizadorDeInvestimentos {

    public void realizaInvestimento(ContaBancaria conta, Investimento investimento) {

        double rendimentoLiquido = investimento.calculaRendimento(conta);
        conta.setSaldo(conta.getSaldo() + rendimentoLiquido);
        System.out.println("Novo Saldo da Conta:[" + conta.getSaldo() + "]");
    }

}
