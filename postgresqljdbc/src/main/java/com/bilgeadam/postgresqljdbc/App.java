package com.bilgeadam.postgresqljdbc;

import java.sql.SQLException;

import com.bilgeadam.postgresqljdbc.repository.DersOgrenciRepository;
import com.bilgeadam.postgresqljdbc.repository.DersRepository;
import com.bilgeadam.postgresqljdbc.repository.KonuRepository;
import com.bilgeadam.postgresqljdbc.repository.OgrenciRepository;
import com.bilgeadam.postgresqljdbc.repository.OgretmenRepository;

public class App
{
	private static OgretmenRepository ogretmen_repo = new OgretmenRepository();
	private static DersRepository ders_repo = new DersRepository();
	private static DersOgrenciRepository dersogrenci_repo = new DersOgrenciRepository();
	private static KonuRepository konu_repo = new KonuRepository();
	private static OgrenciRepository ogrenci_repo = new OgrenciRepository();
	
	

	public static void main(String[] args)
	{
		try
		{
//		System.err.println(ogretmen_repo.save(new Ogretmen("gökhan", true)));
			System.err.println(ogretmen_repo.getAll());
//			System.err.println(ogretmen_repo.getByID(22));
			//System.err.println(dersogrenci_repo.);
//			System.err.println(ogretmen_repo.deleteByID(7));
			System.err.println(ders_repo.getAll());
			System.err.println(ders_repo.getAllDTO());
			//System.err.println(ogrenci_repo.);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}