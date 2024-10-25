package usermanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
	public static Connection getConnect() throws ClassNotFoundException, SQLException {
		String url = "jdbc:postgresql://localhost:5432/usermanagement";
		String user = "postgres";
		String pass = "root";
		Class.forName("org.postgresql.Driver");
		Connection con =DriverManager.getConnection(url, user, pass);
		return con;
	}

}
