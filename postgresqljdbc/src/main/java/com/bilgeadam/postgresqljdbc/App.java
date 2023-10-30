package com.bilgeadam.postgresqljdbc;

import java.sql.SQLException;

import com.bilgeadam.postgresqljdbc.model.DersOgrenci;
import com.bilgeadam.postgresqljdbc.model.Konu;
import com.bilgeadam.postgresqljdbc.model.Ogrenci;
import com.bilgeadam.postgresqljdbc.repository.DersRepository;
import com.bilgeadam.postgresqljdbc.repository.OgretmenRepository;

public class App
{
	private static OgretmenRepository ogretmen_repo = new OgretmenRepository();
	private static DersRepository ders_repo = new DersRepository();
	private static DersOgrenci dersogrenci_repo = new DersOgrenci();
	private static Konu konu_repo = new Konu();
	private static Ogrenci ogrenci_repo = new Ogrenci();
	
	

	public static void main(String[] args)
	{
		try
		{
//			System.err.println(ogretmen_repo.save(new Ogretmen("gökhan", true)));
			System.err.println(ogretmen_repo.getAll());
//			System.err.println(ogretmen_repo.getByID(22));
			//System.err.println(dersogrenci_repo.);
//			System.err.println(ogretmen_repo.deleteByID(7));
//			System.err.println(ders_repo.getAll());
//			System.err.println(ders_repo.getAllDTO());
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}