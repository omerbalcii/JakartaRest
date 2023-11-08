package com.bilgeadam.springrest.model;

public class DersOgrenciDTO
{
	private Ders ders;
	private Ogrenci ogrenci;

	public DersOgrenciDTO()
	{

	}

	public DersOgrenciDTO(Ders ders, Ogrenci ogrenci)
	{
		super();
		this.ders = ders;
		this.ogrenci = ogrenci;
	}

	public Ders getDers()
	{
		return ders;
	}

	public void setDers(Ders ders)
	{
		this.ders = ders;
	}

	public Ogrenci getOgrenci()
	{
		return ogrenci;
	}

	public void setOgrenci(Ogrenci ogrenci)
	{
		this.ogrenci = ogrenci;
	}

	@Override
	public String toString()
	{
		return "DersOgrenciDTO [ogrenci=" + ogrenci + ", ders=" + ders + "]";
	}
}
