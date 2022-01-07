package demovoiture.voiture.metier;

import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;



public class Facture {
private Client client ;
private Reservation res;
private LocalDate DateFacture;
private String numero ;
private float  montant ;
public Facture(Client client, Reservation res, LocalDate dateFacture, String numero, float montant) {
	super();
	this.client = client;
	this.res = res;
	DateFacture = dateFacture;
	this.numero = numero;
	this.montant = montant;
}
public Facture() {
	super();
}
public Facture(int int1, float float1, LocalDate localDate, Reservation r2, boolean boolean1) {
	// TODO Auto-generated constructor stub
}
public Client getClient() {
	return client;
}
public void setClient(Client client) {
	this.client = client;
}
public Reservation getRes() {
	return res;
}
public void setRes(Reservation res) {
	this.res = res;
}
public LocalDate getDateFacture() {
	return DateFacture;
}
public void setDateFacture(LocalDate dateFacture) {
	DateFacture = dateFacture;
}
public String getNumero() {
	return numero;
}
public void setNumero(String numero) {
	this.numero = numero;
}
public float getMontant() {
	return montant;
}
public void setMontant(float montant) {
	this.montant = montant;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((numero == null) ? 0 : numero.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Facture other = (Facture) obj;
	if (numero == null) {
		if (other.numero != null)
			return false;
	} else if (!numero.equals(other.numero))
		return false;
	return true;
}
@Override
public String toString() {
	return "Facture [client=" + client + ", res=" + res + ", DateFacture=" + DateFacture + ", numero=" + numero
			+ ", montant=" + montant + "]";
}  



}


