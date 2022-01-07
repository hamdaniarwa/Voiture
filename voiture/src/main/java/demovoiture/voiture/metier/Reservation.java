package demovoiture.voiture.metier;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;


public class Reservation{
	private int numres;
	
	private Date Datedelocation ; 
	private Date  Datedebut;
	private Date Datedefin ;
	private Client cin;
    private Voiture mat;
	public int getNumres() {
		return numres;
	}
	public void setNumres(int numres) {
		this.numres = numres;
	}
	public Date getDatedelocation() {
		return Datedelocation;
	}
	public void setDatedelocation(Date datedelocation) {
		Datedelocation = datedelocation;
	}
	public Date getDatedebut() {
		return Datedebut;
	}
	public void setDatedebut(Date datedebut) {
		Datedebut = datedebut;
	}
	public Date getDatedefin() {
		return Datedefin;
	}
	public void setDatedefin(Date datedefin) {
		Datedefin = datedefin;
	}
	public Client getCin() {
		return cin;
	}
	public void setCin(Client cin) {
		this.cin = cin;
	}
	public Voiture getMat() {
		return mat;
	}
	public void setMat(Voiture mat) {
		this.mat = mat;
	}
	public Reservation(int numres, Date datedelocation, Date datedebut, Date datedefin, Client cin,
			Voiture mat) {
		super();
		this.numres = numres;
		Datedelocation = datedelocation;
		Datedebut = datedebut;
		Datedefin = datedefin;
		this.cin = cin;
		this.mat = mat;
	}
	public Reservation() {
		super();
	}
	public Reservation(Client c1, Voiture v11, Date date, String string, float float1) {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Reservation [numres=" + numres + ", Datedelocation=" + Datedelocation + ", Datedebut=" + Datedebut
				+ ", Datedefin=" + Datedefin + ", cin=" + cin + ", mat=" + mat + "]";
	}
	
    
}