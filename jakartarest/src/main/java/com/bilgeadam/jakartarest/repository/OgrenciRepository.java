package com.bilgeadam.jakartarest.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bilgeadam.jakartarest.Constants;
import com.bilgeadam.jakartarest.model.Ogrenci;

public class OgrenciRepository
{

	public boolean save(Ogrenci ogrn) throws SQLException
	{
		boolean result = false;
		Connection con = Constants.getConnection();
		String sql = "INSERT INTO \"public\".\"OGRENCI\"(\"NAME\", \"OGR_NUMBER\",\"YEAR\") VALUES (?, ?, ?)";
		PreparedStatement stmnt = con.prepareStatement(sql);
		stmnt.setString(1, ogrn.getNAME());
		stmnt.setLong(2, ogrn.getOGR_NUMBER());
		stmnt.setLong(3, ogrn.getYEAR());
		result = stmnt.executeUpdate() == 1;
		stmnt.close();
		con.close();
		return result;
	}

	public boolean deleteByID(long id) throws SQLException
	{
		Connection con = Constants.getConnection();
		String sql = "delete from \"public\".\"OGRENCI\" where \"ID\" = ?";
		PreparedStatement stmnt = con.prepareStatement(sql);
		stmnt.setLong(1, id);
		boolean result = stmnt.executeUpdate() == 1;
		stmnt.close();
		con.close();
		return result;
	}

	public ArrayList<Ogrenci> getAll() throws SQLException
	{
		ArrayList<Ogrenci> list = new ArrayList<>();
		Connection con = Constants.getConnection();
		Statement stmnt = con.createStatement();
		ResultSet result = stmnt.executeQuery("select * from \"public\".\"OGRENCI\" order by \"ID\" asc");
		while (result.next())
		{
			long id = result.getLong("ID");
			String name = result.getString("NAME");
			long ogr_number = result.getLong("OGR_NUMBER");
			long year = result.getLong("YEAR");
			list.add(new Ogrenci(id, name, ogr_number, year));
		}
		result.close();
		stmnt.close();
		con.close();
		return list;
	}

	public Ogrenci getByID(long id) throws SQLException
	{
		Ogrenci ogrn = null;
		Connection con = Constants.getConnection();
		String sql = "select * from \"public\".\"OGRENCI\" where \"ID\" = ?";
		PreparedStatement stmnt = con.prepareStatement(sql);
		stmnt.setLong(1, id);
		ResultSet result = stmnt.executeQuery();
		while (result.next())
		{
			ogrn = new Ogrenci(result.getLong("ID"), result.getString("NAME"), result.getLong("OGR_NUMBER"), result.getLong("YEAR"));
		}
		result.close();
		stmnt.close();
		con.close();
		return ogrn;
	}
}
