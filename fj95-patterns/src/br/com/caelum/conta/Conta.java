package br.com.caelum.conta;

import java.util.GregorianCalendar;

public class Conta {
	private String nome;
	private double saldo;
	private String agencia;
	private int numero;
	private GregorianCalendar dataAbertura;
	protected EstadoDeUmaConta estado;

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Conta(String nome, double saldo) {
		this.setNome(nome);
		this.setSaldo(saldo);
		if (saldo > 0) {
			this.estado = new POSITIVO();
		} else {
			this.estado = new NEGATIVO();
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public GregorianCalendar getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(GregorianCalendar dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public void efetuarSaque(double valorSaque) {
		estado.efetuarSaque(this, valorSaque);
	}

	public void eftuarDeposito(double valorDeposito) {
		estado.efetuarDeposito(this, valorDeposito);
	}

}
