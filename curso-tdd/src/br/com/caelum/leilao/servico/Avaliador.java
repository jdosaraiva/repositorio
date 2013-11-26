package br.com.caelum.leilao.servico;

public class Avaliador {

    private double maiorDeTodos = Double.NEGATIVE_INFINITY;

	private double menorDeTodos = Double.POSITIVE_INFINITY;

	private double lanceMedio = 0;

    public void avalia(Leilao leilao) {
    	
    	double sum = 0;

        for(Lance lance : leilao.getLances()) {
            if(lance.getValor() > maiorDeTodos) {
                maiorDeTodos = lance.getValor();
            }
            if(lance.getValor() < menorDeTodos) {
                menorDeTodos = lance.getValor();
            }
            
            sum += lance.getValor();
        }
        
        if (leilao.getLances().size() > 0) {
        	lanceMedio = sum / leilao.getLances().size();
        }
 
    }

    public double getMaiorLance() { 
        return maiorDeTodos; 
    }
	public double getMenorLance() {
		return menorDeTodos;
	}
	
	public double getLanceMedio() {
		return lanceMedio;
	}
}