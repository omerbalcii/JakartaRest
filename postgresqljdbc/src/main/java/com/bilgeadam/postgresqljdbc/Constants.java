package com.bilgeadam.postgresqljdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Constants
{
	public static final String USER = "postgres";

	public static final String PASSWORD = "1234";

	public static final String URL = "jdbc:postgresql://127.0.0.1:5432/OBS";

	public static Connection getConnection() throws SQLException
	{
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}