package org.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;
import java.io.FileInputStream;


public class DBConnection {

	Connection connection = null;
	Statement statement = null;

	// implementation of mysql connection
	public Connection getConnection() {

		try {
			
			//JDBC properties entry for MySQL
			FileInputStream fis = new FileInputStream("dbconnection.properties");
			Properties prop = new Properties();
			prop.load(fis);

			String driver = prop.getProperty("MYSQLJDBC.driver");
			String url = prop.getProperty("MYSQLJDBC.url");
			String username = prop.getProperty("MYSQLJDBC.username");
			String password = prop.getProperty("MYSQLJDBC.password");

			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, password);

		} catch (Exception e) {
			System.out.println(e);
		}
		return connection;
	}

	// implementation of statement
	public Statement getStatement() {

		try {
			statement = connection.createStatement();
		} catch (Exception e) {
			System.out.println(e);
		}
		return statement;
	}

}
