package aula1;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

public class ConnectionFactoryTest {

	@Test
	public void test() {
		
		Connection conn = ConnectionFactory.getConnection();
		
		assertNotNull(conn);
		
	}

}
