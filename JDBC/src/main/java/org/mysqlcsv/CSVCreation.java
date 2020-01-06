package org.mysqlcsv;

import org.connection.DBConnection;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import org.service.Service;

public class CSVCreation implements Service {
	
	public void csvDownload() {
		// defining csv file path
		String filename = "student.csv";

		try {

			// implementation of filewriter for writing output into csv
			FileWriter fw = new FileWriter(filename);

			Connection connection = null;
			Statement statement = null;

			DBConnection dbconnection = new DBConnection();

			// fetching connection and statement
			connection = dbconnection.getConnection();
			statement = dbconnection.getStatement();

			// implementation of resultset
			String query = "select * from student";
			ResultSet rs = statement.executeQuery(query);

			// spliting data using (,)
			while (rs.next()) {
				fw.append(rs.getString("id"));
				fw.append(",");
				fw.append(rs.getString("first_name"));
				fw.append(",");
				fw.append(rs.getString("last_name"));
				fw.append(",");
				fw.append(rs.getString("age"));
				fw.append("\n");
			}

			// closing
			fw.close();
			connection.close();
			statement.close();
			System.out.println("CSV File is created successfully.");

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
