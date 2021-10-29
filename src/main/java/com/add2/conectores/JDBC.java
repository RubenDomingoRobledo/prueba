package com.add2.conectores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {
	public static void main (String[]args) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba","root","root");
			Statement stmnt= con.createStatement();
			ResultSet rs = stmnt.executeQuery("SELECT * FROM persona");
			while (rs.next())
				System.out.println(rs.getInt(1)+ " "+ rs.getInt(2)+ " "+ rs.getString(3)+ " "+ rs.getString(4)+ " "+ rs.getInt(5));
			
			stmnt.execute("DROP TABLE IF EXISTS animal");
			stmnt.execute("CREATE TABLE animal (id INT AUTO_INCREMENT PRIMARY KEY, Nombre CHAR(50), Especie CHAR(50))");
			stmnt.executeUpdate("INSERT INTO animal (Nombre, Especie) VALUES "
					+ "('Delf�n', 'Mam�fero')," 
					+ "('Iguana','Reptil')," 
					+ "('Rana','Anfibio')," 
					+ "('Nutria', 'Mamifero')");
			
			ResultSet rs1 = stmnt.executeQuery("SELECT * FROM animal");
			System.out.println("\n");
			System.out.println("---------");
			while (rs1.next())
				System.out.println(rs1.getInt(1)+ " "+ rs1.getString(2)+ " "+ rs1.getString(3));
			
			stmnt.executeUpdate("UPDATE animal SET Nombre = 'Rat�n' WHERE id = 4");
			ResultSet rs2 = stmnt.executeQuery("SELECT * FROM animal");
			System.out.println("---------");
			while (rs2.next())
				System.out.println(rs2.getInt(1)+ " "+ rs2.getString(2)+ " "+ rs2.getString(3));
			
			con.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
