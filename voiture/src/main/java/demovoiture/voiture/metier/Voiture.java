package demovoiture.voiture.metier;

import java.util.Objects;

public class Voiture {
	private String  matricule;
	private String Modele  ;
    private String Couleur ;
	
	private int nbrPlace;
	private float prix;
	private String marque ;
	public Voiture(String matricule, String modele, String couleur, int nbrPlace, float prix, String marque) {
		super();
		this.matricule = matricule;
		Modele = modele;
		Couleur = couleur;
		this.nbrPlace = nbrPlace;
		this.prix = prix;
		this.marque = marque;
	}
	public Voiture() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getModele() {
		return Modele;
	}
	public void setModele(String modele) {
		Modele = modele;
	}
	public String getCouleur() {
		return Couleur;
	}
	public void setCouleur(String couleur) {
		Couleur = couleur;
	}
	public int getNbrPlace() {
		return nbrPlace;
	}
	public int setNbrPlace(int nbrPlace) {
		return this.nbrPlace = nbrPlace;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	} 
	
	

	
	
	
	}

