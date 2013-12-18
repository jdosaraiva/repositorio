package br.com.caelum.relatorio;

import br.com.caelum.conta.Conta;

public class BancoBuilder {
	
	Banco banco;
	
	public BancoBuilder() {
		banco = new Banco();
	}
	
	public BancoBuilder comNome(String nome) {
		this.banco.setNomeBanco(nome);
		return this;
	}
	
	public BancoBuilder comEndereco(String endereco) {
		this.banco.setEndereco(endereco);
		return this;
	}
	
	public BancoBuilder comTelefone(String telefone) {
		this.banco.setTelefone(telefone);
		return this;
	}
	
	public BancoBuilder comEmail(String email) {
		this.banco.setEmail(email);
		return this;
	}
	
	public BancoBuilder comConta(String titular, String agencia, int numeroConta, double saldo) {
		Conta conta = new Conta(titular, saldo);
		conta.setAgencia(agencia);
		conta.setNumero(numeroConta);
		this.banco.getContas().add(conta);
		return this;
	}
	
	public Banco constroi() {
		return this.banco;
	}

}
