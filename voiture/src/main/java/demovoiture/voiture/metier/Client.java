package demovoiture.voiture.metier;

public class Client {
private String cin;
private String nomprenom;
private String adresse;
private int numtel;
private int nbredelocation ; 



public Client(String cin, String nomprenom, String adresse, int numtel, int nbredelocation) {
	super();
	this.cin = cin;
	this.nomprenom = nomprenom;
	this.adresse = adresse;
	this.numtel = numtel;
	this.nbredelocation = nbredelocation;
}

public Client() {
	super();
}

public Client(String cin2, String adresse2) {
	super();
	cin = cin;
	this.adresse = adresse;
}

public String getCin() {
	return cin;
}

public int getNumtel() {
	return numtel;
}
public void setNumtel(int numtel) {
	this.numtel = numtel;
}
public String getNomprenom() {
	return nomprenom;
}
public void setNomprenom(String nomprenom) {
	this.nomprenom = nomprenom;
}
public String getAdresse() {
	return adresse;
}
public void setAdresse(String adresse) {
	this.adresse = adresse;
}
//FF
public int getNbredelocation() {
	return nbredelocation;
}

public void setNbredelocation(int nbredelocation) {
	this.nbredelocation = nbredelocation;
}

@Override
public String toString() {
	return "client [cin=" + cin + ", nomprenom=" + nomprenom + ", adresse=" + adresse + "]";
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Client other = (Client) obj;
	return cin == other.cin;
}




}
