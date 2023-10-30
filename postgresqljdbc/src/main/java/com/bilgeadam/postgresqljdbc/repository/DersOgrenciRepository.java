package com.bilgeadam.postgresqljdbc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bilgeadam.postgresqljdbc.Constants;
import com.bilgeadam.postgresqljdbc.model.DersOgrenci;


public class DersOgrenciRepository {
	
	public boolean save(DersOgrenci dersogrenci) throws SQLException
	{
		boolean result = false;
		Connection con = Constants.getConnection();
		String sql = "INSERT INTO \"public\".\"DERS_OGRENCI\"(\"DERS_ID\", \"OGR_ID\", \"DEVAMSIZLIK\", \"NOTE\")VALUES ( ?, ?, ?, ?)";
		PreparedStatement stmnt = con.prepareStatement(sql);
		stmnt.setLong(1, dersogrenci.getDERS_ID());
		stmnt.setLong(2, dersogrenci.getOGR_ID());
		stmnt.setInt(3, dersogrenci.getDEVAMSIZLIK());
		stmnt.setInt(4, dersogrenci.getNOTE());
		result = stmnt.executeUpdate() == 1;
		stmnt.close();
		con.close();
		return result;
	}
	
	public boolean deleteByID(long id) throws SQLException
	{
		Connection con = Constants.getConnection();
		String sql = "delete from \"public\".\"DERS_OGRENCI\" where \"ID\" = ?";
		PreparedStatement stmnt = con.prepareStatement(sql);
		stmnt.setLong(1, id);
		boolean result = stmnt.executeUpdate() == 1;
		stmnt.close();
		con.close();
		return result;
	}
	
	public DersOgrenci getByID(long id) throws SQLException
	{
		DersOgrenci dersogrenci = null;
		Connection con = Constants.getConnection();
		String sql = "select * from \"public\".\"DERS_OGRENCI\" where \"ID\" = ?";
		PreparedStatement stmnt = con.prepareStatement(sql);
		stmnt.setLong(1, id);
		ResultSet result = stmnt.executeQuery();
		while (result.next())
		{
			dersogrenci = new DersOgrenci(result.getLong("ID"), result.getLong("DERS_ID"), result.getLong("OGR_ID"), result.getInt("DEVAMSIZLIK"), result.getInt("NOTE"));
		}
		result.close();
		stmnt.close();
		con.close();
		return dersogrenci;
	}
	
	public ArrayList<DersOgrenci> getAll() throws SQLException
	{
		ArrayList<DersOgrenci> list = new ArrayList<>();
		Connection con = Constants.getConnection();
		Statement stmnt = con.createStatement();
		ResultSet result = stmnt.executeQuery("select * from \"public\".\"DERS_OGRENCI\" order by \"ID\" asc");
		while (result.next())
		{
			long id = result.getLong("ID");
			long d_id = result.getLong("DERS_ID");
			long o_id = result.getLong("OGR_ID");
			int devamsızlık = result.getInt("DEVAMSIZLIK");
			int note = result.getInt("NOTE");
		
			list.add(new DersOgrenci(id,d_id,o_id,devamsızlık,note ));
		}
		result.close();
		stmnt.close();
		con.close();
		return list;
	}
	
	
	
	

}