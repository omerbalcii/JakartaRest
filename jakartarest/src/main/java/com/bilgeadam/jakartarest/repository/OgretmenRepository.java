package com.bilgeadam.jakartarest.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bilgeadam.jakartarest.Constants;
import com.bilgeadam.jakartarest.model.Ogretmen;

public class OgretmenRepository
{
	public boolean save(Ogretmen ogr) throws SQLException
	{
		boolean result = false;
		Connection con = Constants.getConnection();
		String sql = "INSERT INTO \"public\".\"OGRETMEN\"(\"NAME\", \"IS_GICIK\") VALUES (?, ?)";
		PreparedStatement stmnt = con.prepareStatement(sql);
		stmnt.setString(1, ogr.getNAME());
		stmnt.setBoolean(2, ogr.isIS_GICIK());
		result = stmnt.executeUpdate() == 1;
		// update yerine query çalıştırılırsa felaket
		// hem hata veriyor hem de yazıyor
		// stmnt.executeQuery();
		stmnt.close();
		con.close();
		return result;
	}

	public boolean deleteByID(long id) throws SQLException
	{
		Connection con = Constants.getConnection();
		String sql = "delete from \"public\".\"OGRETMEN\" where \"ID\" = ?";
		PreparedStatement stmnt = con.prepareStatement(sql);
		stmnt.setLong(1, id);
		boolean result = stmnt.executeUpdate() == 1;
		stmnt.close();
		con.close();
		return result;
	}

	public Ogretmen getByID(long id) throws SQLException
	{
		Ogretmen ogr = null;
		Connection con = Constants.getConnection();
		String sql = "select * from \"public\".\"OGRETMEN\" where \"ID\" = ?";
		PreparedStatement stmnt = con.prepareStatement(sql);
		stmnt.setLong(1, id);
		ResultSet result = stmnt.executeQuery();
		while (result.next())
		{
			ogr = new Ogretmen(result.getLong("ID"), result.getString("NAME"), result.getBoolean("IS_GICIK"));
		}
		result.close();
		stmnt.close();
		con.close();
		return ogr;
	}

	public ArrayList<Ogretmen> getAll() throws SQLException
	{
		ArrayList<Ogretmen> list = new ArrayList<>();
		Connection con = Constants.getConnection();
		Statement stmnt = con.createStatement();
		ResultSet result = stmnt.executeQuery("select * from \"public\".\"OGRETMEN\" order by \"ID\" asc");
		while (result.next())
		{
			long id = result.getLong("ID");
			String name = result.getString("NAME");
			boolean IS_GICIK = result.getBoolean("IS_GICIK");
			list.add(new Ogretmen(id, name, IS_GICIK));
		}
		result.close();
		stmnt.close();
		con.close();
		return list;
	}

	public boolean update(long id, Ogretmen ogr) throws SQLException
	{
		boolean result = false;
		Connection con = Constants.getConnection();
		String sql = "UPDATE \"public\".\"OGRETMEN\" SET \"NAME\" = ?, \"IS_GICIK\" = ? WHERE \"ID\" = ?";
		PreparedStatement stmnt = con.prepareStatement(sql);
		stmnt.setString(1, ogr.getNAME());
		stmnt.setBoolean(2, ogr.isIS_GICIK());
		stmnt.setLong(3, id);
		result = stmnt.executeUpdate() == 1;
		stmnt.close();
		con.close();
		return result;
	}
}