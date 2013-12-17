package br.com.caelum.conta;

import org.junit.Assert;
import org.junit.Test;

public class RequisicaoTest {

	/**
	 * 
	 */
	@Test
	public void test() {
		Conta conta = new Conta("Daniel", 500.0);

        Requisicao req1 = new Requisicao(Formato.XML);
        Requisicao req2 = new Requisicao(Formato.PORCENTO);
        Requisicao req3 = new Requisicao(Formato.CSV);

        Resposta r4 = new SemResposta();
        Resposta r3 = new RespostaPORCENTO(r4);
        Resposta r2 = new RespostaCSV(r3);
        Resposta r1 = new RespostaXML(r2);

        System.out.println(r1.devolveConta(conta, req1));
        System.out.println(r1.devolveConta(conta, req2));
        System.out.println(r1.devolveConta(conta, req3));
        
		Assert.assertTrue(true);

	}

}
