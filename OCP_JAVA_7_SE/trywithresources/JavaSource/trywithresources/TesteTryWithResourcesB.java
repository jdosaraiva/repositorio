package trywithresources;

public class TesteTryWithResourcesB {
	public static void main(String[] args) {
		try (A a = new A(); ) {
			System.out.println("Inicio");
		} catch (MyException me) {
			System.err.println(me.getMessage());
			for (Throwable t : me.getSuppressed()) {
				System.err.println("Suppressed:[" + t + "]");
			}
		}
	}
}

class MyException extends Exception {
	MyException() {
	}
	MyException(String message) {
		super(message);
	}
	MyException(Throwable cause) {
		super(cause);
	}
	MyException(String message, Throwable cause) {
		super(message, cause);
	}
}

class A implements AutoCloseable {
	public void close() throws MyException {
		throw new MyException("MyException in Class A");
	}
}

class B implements AutoCloseable {
	public void close() throws MyException {
		throw new MyException("MyException in Class B");
	}
}