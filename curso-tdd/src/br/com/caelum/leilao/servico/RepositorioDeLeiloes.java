package br.com.caelum.leilao.servico;

import java.util.List;

public interface RepositorioDeLeiloes {

	public List<Leilao> correntes();

	public void atualiza(Leilao leilao);

	public void salva(Leilao leilao1);

	public List<Leilao> encerrados();
	
}
