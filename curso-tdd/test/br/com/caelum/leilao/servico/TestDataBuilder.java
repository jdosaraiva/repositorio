package br.com.caelum.leilao.servico;

public class TestDataBuilder {

	private Leilao leilao;

	public TestDataBuilder() {
	}

	public TestDataBuilder para(String descricao) {
		this.leilao = new Leilao(descricao);
		return this;
	}

	public TestDataBuilder lance(Usuario usuario, double valor) {
		leilao.propoe(new Lance(usuario, valor));
		return this;
	}

	public Leilao constroi() {
		return leilao;
	}
}
