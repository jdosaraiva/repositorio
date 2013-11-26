package br.com.caelum.leilao.servico;

import java.util.ArrayList;
import java.util.List;

public class Leilao {

	private String item;
	private List<Lance> lances;

	public Leilao(String item) {
		this.item = item;
	}

	public List<Lance> getLances() {
		if (lances == null) 
			lances = new ArrayList<Lance>();
		return lances;
	}

	public void propoe(Lance lance) {
		if (lances == null) 
			lances = new ArrayList<Lance>();
		lances.add(lance);
	}

}
