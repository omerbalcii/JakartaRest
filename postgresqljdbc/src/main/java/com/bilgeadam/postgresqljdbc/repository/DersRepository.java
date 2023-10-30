package com.bilgeadam.postgresqljdbc.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bilgeadam.postgresqljdbc.Constants;
import com.bilgeadam.postgresqljdbc.model.Ders;
import com.bilgeadam.postgresqljdbc.model.DersDTO;
import com.bilgeadam.postgresqljdbc.model.Konu;
import com.bilgeadam.postgresqljdbc.model.Ogretmen;

public class DersRepository
{
	public ArrayList<Ders> getAll() throws SQLException
	{
		ArrayList<Ders> list = new ArrayList<>();
		Connection con = Constants.getConnection();
		Statement stmnt = con.createStatement();
		ResultSet result = stmnt.executeQuery("select * from \"public\".\"DERS\" order by \"ID\" asc");
		while (result.next())
		{
			long id = result.getLong("ID");
			long ogretmen_id = result.getLong("OGRETMEN_ID");
			long konu_id = result.getLong("KONU_ID");
			list.add(new Ders(id, ogretmen_id, konu_id));
		}
		result.close();
		stmnt.close();
		con.close();
		return list;
	}

	public ArrayList<DersDTO> getAllDTO() throws SQLException
	{
		ArrayList<DersDTO> list = new ArrayList<>();
		Connection con = Constants.getConnection();
		Statement stmnt = con.createStatement();
		ResultSet result = stmnt.executeQuery("select \"DERS\".\"OGRETMEN_ID\", \"OGRETMEN\".\"NAME\" AS \"OGR_NAME\", \"OGRETMEN\".\"IS_GICIK\", \"DERS\".\"KONU_ID\", \"KONU\".\"NAME\" AS \"KONU_NAME\" from \"DERS\" inner join \"OGRETMEN\" ON \"OGRETMEN\".\"ID\" = \"DERS\".\"OGRETMEN_ID\" inner join \"KONU\" ON \"KONU\".\"ID\" = \"DERS\".\"KONU_ID\";");
		while (result.next())
		{
			Ogretmen ogr = new Ogretmen(result.getLong("OGRETMEN_ID"), result.getString("OGR_NAME"), result.getBoolean("IS_GICIK"));
			Konu konu = new Konu(result.getLong("KONU_ID"), result.getString("KONU_NAME"));
			list.add(new DersDTO(ogr, konu));
		}
		result.close();
		stmnt.close();
		con.close();
		return list;
	}
}