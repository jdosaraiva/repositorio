package trywithresources;

public class TesteTryWithResources implements AutoCloseable {
	
	public void close() {
		System.out.println("Fechando o recurso");
	}
	
	public void execute() {
		System.out.println("Executando...");
	}

	public static void main(String[] args) {
		
		try ( TesteTryWithResources ttwr = new TesteTryWithResources() ) {
			ttwr.execute();
		}
		
	}
	
}