package com.bilgeadam.postgresqljdbc.model;

public class DersOgrenci {

	private long ID;
	private long DERS_ID;
	private long OGR_ID;
	private int DEVAMSIZLIK;
	private int NOTE;
	
	
	public DersOgrenci() 
	{
		
	}
	
	public DersOgrenci(long iD, long dERS_ID, long oGR_ID, int dEVAMSIZLIK, int nOTE) {
		ID = iD;
		DERS_ID = dERS_ID;
		OGR_ID = oGR_ID;
		DEVAMSIZLIK = dEVAMSIZLIK;
		NOTE = nOTE;
	}
	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public long getDERS_ID() {
		return DERS_ID;
	}

	public void setDERS_ID(long dERS_ID) {
		DERS_ID = dERS_ID;
	}

	public long getOGR_ID() {
		return OGR_ID;
	}

	public void setOGR_ID(long oGR_ID) {
		OGR_ID = oGR_ID;
	}

	public int getDEVAMSIZLIK() {
		return DEVAMSIZLIK;
	}

	public void setDEVAMSIZLIK(int dEVAMSIZLIK) {
		DEVAMSIZLIK = dEVAMSIZLIK;
	}

	public int getNOTE() {
		return NOTE;
	}

	public void setNOTE(int nOTE) {
		NOTE = nOTE;
	}

	
}