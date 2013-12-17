package br.com.caelum.relatorio;


public class EmiteRelatorio {
	
	public static void main(String[] args) {
		
		Banco banco = new BancoBuilder()
				.comNome("Banco da Nação Saraiva")
				.comEndereco("Rua dos Bobos, nº 0")
				.comTelefone("+55 (11) 9999-9999")
				.comEmail("sac@banco.com.br")
				.comConta("Saraiva", "Agencia", 1, 500.0)
				.comConta("Silvio Santos", "Super Agencia", 2, 500000.0)
				.constroi();
		
		TemplateDeRelatorio relatorio = new RelatorioComplexo();
		relatorio.setBanco(banco);
		
		relatorio.imprimeRelatorio();
		
		
		relatorio = new RelatorioSimples();
		relatorio.setBanco(banco);
		
		relatorio.imprimeRelatorio();
	}

}
