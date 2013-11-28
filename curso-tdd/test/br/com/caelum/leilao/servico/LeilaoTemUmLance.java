package br.com.caelum.leilao.servico;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.TypeSafeMatcher;

public class LeilaoTemUmLance extends TypeSafeMatcher<Leilao> {
	
	private final Lance expected;
	 
    public LeilaoTemUmLance(Lance expected) {
        this.expected = expected;
    }
 
    @Override
    public void describeTo(Description descr) {
        descr.appendText("Tem um lance");
    }
 
    @Factory
    public static LeilaoTemUmLance temUmLance(Lance expected) {
        return new LeilaoTemUmLance(expected);
    }

	@Override
	protected boolean matchesSafely(Leilao actual) {

		for (Lance lance : actual.getLances()) {
			if (lance.equals(expected))
				return true;
		}

		return false;
	}

}
