package pacote;

public class Teste4 {
	public static void main(String[] args) {
		ClassX sampleA = new ClassX();
		ClassX sampleB = new ClassY();
		System.out.println("A:" + sampleA.currentStatus() + " B:" + sampleB.currentStatus());
	}
}