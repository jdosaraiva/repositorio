package br.com.caelum.leilao.servico;

import java.util.ArrayList;
import java.util.List;

public class Leilao {

	private String item;
	private List<Lance> lances = new ArrayList<Lance>();

	public Leilao(String item) {
		this.item = item;
	}

	public List<Lance> getLances() {
		if (lances == null)
			lances = new ArrayList<Lance>();
		return lances;
	}

	public void propoe(Lance lance) {
		if (lance.getValor() <= 0)
			throw new IllegalArgumentException("O valor do Lance deve ser maior que zero");
		
		if (lances.isEmpty() || podeDarLance(lance.getUsuario())) {
			lances.add(lance);
		}
	}

	public void dobraLance(Usuario usuario) {
		Lance ultimoLance = ultimoLanceDo(usuario);
		if (ultimoLance != null) {
			propoe(new Lance(usuario, ultimoLance.getValor() * 2));
		}
	}

	private Lance ultimoLanceDo(Usuario usuario) {
		Lance ultimo = null;
		for (Lance lance : lances) {
			if (lance.getUsuario().equals(usuario))
				ultimo = lance;
		}

		return ultimo;
	}

	private boolean podeDarLance(Usuario usuario) {
		return !ultimoLanceDado().getUsuario().equals(usuario)
				&& qtdDelancesDo(usuario) < 5;
	}

	private int qtdDelancesDo(Usuario usuario) {
		int total = 0;
		for (Lance lance : lances) {
			if (lance.getUsuario().equals(usuario))
				total++;
		}
		return total;
	}

	private Lance ultimoLanceDado() {
		return lances.get(lances.size() - 1);
	}

}
