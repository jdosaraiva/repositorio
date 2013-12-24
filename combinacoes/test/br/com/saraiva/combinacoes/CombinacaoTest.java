package br.com.saraiva.combinacoes;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import static br.com.saraiva.combinacoes.Combinacao.*;

import org.junit.Test;

import br.com.saraiva.utils.Chronometer;

public class CombinacaoTest {

	@Test
	public void calculaFatorial() {
		
		assertThat(fat(0), equalTo(  1.0));
		assertThat(fat(1), equalTo(  1.0));
		assertThat(fat(2), equalTo(  2.0));
		assertThat(fat(3), equalTo(  6.0));
		assertThat(fat(4), equalTo( 24.0));
		assertThat(fat(5), equalTo(120.0));
		assertThat(fat(6), equalTo(720.0));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deveRetornarExceptionSeNMenorQP() {
		
		combinacao(2, 4);
	}
	
	@Test
	public void calculaCombinacao() {
		
		assertThat(combinacao( 1,  1), equalTo(  1.0));
		assertThat(combinacao( 4,  2), equalTo(  6.0));
		assertThat(combinacao( 5,  2), equalTo( 10.0));
		assertThat(combinacao(17, 15), equalTo(136.0));
		assertThat(combinacao(18, 15), equalTo(816.0));

		assertThat(combinacao(25, 15), equalTo(3268760.0));
		
		assertEquals(50063860.0, combinacao(60, 6), 0.0001);
	
	}
	
	@Test
	public void testaFatModificado() {
		
		assertThat(fat(5, 3), equalTo(20.0));
	}
	

	public static void main(String[] args) {

        
        Chronometer.start();
        
        for (int i = 0; i < 100000000; i++) {

        	combinacao(60, 6);
        	
        }
		
		Chronometer.stop();
		System.out.println("ms "+Chronometer.time());  
        System.out.println("s "+Chronometer.stime());  
        System.out.println("m "+Chronometer.mtime());  
        System.out.println("h "+Chronometer.htime());

        System.out.println("===============================================================");
        
	}
}
