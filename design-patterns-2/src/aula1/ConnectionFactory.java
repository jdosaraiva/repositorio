package aula1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection getConnection() {
		String banco = System.getenv("tipoBanco");

		try {
			Connection conexao = null;

			if ("postgres".equals(banco)) {

				String url = "jdbc:postgresql://localhost/test?user=fred&password=secret&ssl=true";
				conexao = DriverManager.getConnection(url);

			} else if ("hsqldb".equals(banco)) {
				conexao = DriverManager.getConnection("jdbc:hsqldb:MyDB", "sa",	"");

			}

			return conexao;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
