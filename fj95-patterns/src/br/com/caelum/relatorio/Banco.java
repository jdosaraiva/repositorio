package br.com.caelum.relatorio;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.conta.Conta;

public class Banco {

	private List<Conta> contas;
	private String nomeBanco;
	private String endereco;
	private String telefone;
	private String email;

	public List<Conta> getContas() {
		if (contas == null) {
			contas = new ArrayList<Conta>();
		}
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

	public String getNomeBanco() {
		return nomeBanco;
	}

	public void setNomeBanco(String nomeBanco) {
		this.nomeBanco = nomeBanco;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
