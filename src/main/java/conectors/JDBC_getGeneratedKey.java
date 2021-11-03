package conectors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_getGeneratedKey {
	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba","root","root");
			Statement stmnt= con.createStatement();
			stmnt.execute("DROP TABLE IF EXISTS animal");
			stmnt.execute("CREATE TABLE animal (id INT AUTO_INCREMENT PRIMARY KEY, Nombre CHAR(50), Especie CHAR(50))");
			stmnt.executeUpdate("INSERT INTO animal (Nombre, Especie) VALUES "
					+ "('Delf�n', 'Mam�fero')");
			
			stmnt.executeUpdate("sql",Statement.RETURN_GENERATED_KEYS);
			ResultSet rgk = stmnt.getGeneratedKeys();
			System.out.println(rgk);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
