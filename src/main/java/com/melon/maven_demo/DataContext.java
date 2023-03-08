package com.melon.maven_demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;

public class DataContext {
	public static String DataQuery() {
		String url = "jdbc:mysql://172.17.0.2:3306/JavaMySQL";
		String username = "root";
		String password = "Melon@123";

		System.out.println("Connecting database...");

		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			DSLContext create = DSL.using(connection);

			// Result<?> records = create.fetchStream("SELECT * FROM people;");
			var records = create.fetch("SELECT * FROM people;");
			List recordsList = new ArrayList();

			for (var record : records) {
				recordsList.add(record);
			}

			return recordsList.toString();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro de conexão com o banco!");
			throw new RuntimeException(e);
		}
	}
}
