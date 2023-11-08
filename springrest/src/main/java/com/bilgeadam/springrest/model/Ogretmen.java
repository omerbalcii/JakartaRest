package com.bilgeadam.springrest.model;

public class Ogretmen
{
	// DTO, POJO, BEAN, ENTITY, MODEL

	private long ID;
	private String NAME;
	private boolean IS_GICIK;

	public Ogretmen()
	{
	}

	public Ogretmen(long iD, String nAME, boolean iS_GICIK)
	{
		ID = iD;
		NAME = nAME;
		IS_GICIK = iS_GICIK;
	}

	public Ogretmen(String nAME, boolean iS_GICIK)
	{
		NAME = nAME;
		IS_GICIK = iS_GICIK;
	}

	public long getID()
	{
		return ID;
	}

	public void setID(long iD)
	{
		ID = iD;
	}

	public String getNAME()
	{
		return NAME;
	}

	public void setNAME(String nAME)
	{
		NAME = nAME;
	}

	public boolean isIS_GICIK()
	{
		return IS_GICIK;
	}

	public void setIS_GICIK(boolean iS_GICIK)
	{
		IS_GICIK = iS_GICIK;
	}

	@Override
	public String toString()
	{
		return "Ogretmen [ID=" + ID + ", NAME=" + NAME + ", IS_GICIK=" + IS_GICIK + "]";
	}

}