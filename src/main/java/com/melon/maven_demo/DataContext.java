package com.melon.maven_demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import static com.melon.mysql.generatedclasses.tables.People.PEOPLE;

public class DataContext {
	public static String DataQuery() {
		String url = "jdbc:mysql://172.17.0.2:3306/jooq_demo";
		String username = "root";
		String password = "Melon@123";

		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			DSLContext create = DSL.using(connection, SQLDialect.MYSQL);

			Result<?> result = create.select().from(PEOPLE).fetch();
			List<Record> recordsList = new ArrayList<Record>();

			for (Record r : result) {
				recordsList.add(r);
			}

			return recordsList.toString();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro de conexão com o banco!", "Error", JOptionPane.ERROR_MESSAGE);
			throw new RuntimeException(e);
		}
	}
}
