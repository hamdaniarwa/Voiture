package demovoiture.voiture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import demovoiture.voiture.metier.Voiture;






public class VoitureDAO {
	
	
	public ArrayList<Voiture> findALl(){
		String rq="select *from Voiture ";
		Voiture f ; 
		ArrayList<Voiture>Voitures = new ArrayList<Voiture>() ;
		Connection cnx = SConnection.getInstance();
		PreparedStatement st; 
		try {
			st=cnx.prepareStatement(rq);
			
			ResultSet res = st.executeQuery();
			if(res.next())
				 f  =new Voiture (res.getString("matricule"),res.getString("modele"),res.getString("couleur"),res.getInt("nbplace"),res.getInt(4),res.getString(5));
			st.close();
			
			
		}catch (SQLException e) {
			System.out.println("aucune Voiture enregistre pour ce client");
		}
		return Voitures ; 
	}


	public ArrayList<Voiture> findByMarque(String marque){
		String rq="select *from Voiture where marque = ?  ";
		Voiture f ; 
		ArrayList<Voiture>Voitures = new ArrayList<Voiture>() ;
		Connection cnx = SConnection.getInstance();
		PreparedStatement st; 
		try {
			st=cnx.prepareStatement(rq);
			st=cnx.prepareStatement(rq);
			st.setString(1, marque);
			ResultSet res = st.executeQuery();
			if(res.next())
				 f  =new Voiture (res.getString("matricule"),res.getString("modele"),res.getString("couleur"),res.getInt("nbplace"),res.getInt(4),res.getString(5));
			st.close();
			
			
		}catch (SQLException e) {
			System.out.println("aucune Voiture enregistre pour ce client");
		}
		return Voitures ; 
	}
	
	public ArrayList<Voiture> findByColor(String col ){
		String rq="select *from Voiture where couleur = ?  ";
		Voiture f ; 
		ArrayList<Voiture>Voitures = new ArrayList<Voiture>() ;
		Connection cnx = SConnection.getInstance();
		PreparedStatement st; 
		try {
			st=cnx.prepareStatement(rq);
			st=cnx.prepareStatement(rq);
			st.setString(1, col);
			ResultSet res = st.executeQuery();
			if(res.next())
				 f  =new Voiture (res.getString("matricule"),res.getString("modele"),res.getString("couleur"),res.getInt("nbplace"),res.getInt(4),res.getString(5));
			st.close();
			
			
		}catch (SQLException e) {
			System.out.println("aucune Voiture enregistre pour ce client");
		}
		return Voitures ; 
	} 
	
	
	public Voiture findById(String v11) {
		String rq="select * from voiture where matricule=?";
		Voiture v= null;
		Connection cnx= (Connection) SConnection.getInstance();
		PreparedStatement st;
		try {
			st=(PreparedStatement) cnx.prepareStatement(rq);
			st.setString(1, v11);
			ResultSet res= st.executeQuery();
			if(res.next())
				v=new Voiture(res.getString(1),res.getString(2),res.getString(3),res.getInt(4),res.getFloat(5),res.getString(6));
			
			st.close();
		} catch (SQLException e) {
			System.out.println("La requete1 n'a pas pu etre executee ");
		}
		return v;
	}
	public void saveVoiture(Voiture v ) {
		
		
		Connection cnx= SConnection.getInstance();
		PreparedStatement st ; 
	      int n = 0 ; 
			try {
				 cnx = SConnection.getInstance();
				
				String r2="insert into voiture (matricule,modele,couleur,nbplace,prixlocationparjour,marque) values (?,?,?,?,?,?)";
				 st=cnx.prepareStatement(r2);
				st.setString(1,v.getMatricule());
				//FF:  st.setString(2,c.getAdresse());
				st.setString(2,v.getModele());
				st.setString(3,v.getCouleur());
				st.setInt(4,v.getNbrPlace());
				//FF:  st.setInt(3,c.getNumtel());
				//FF:  st.setString(4,c.getNomprenom());
				//FF
				st.setFloat(5,v.getPrix());
				st.setString(6,v.getMarque());
				
				
				n= st.executeUpdate();
				//FF
				System.out.println("Ajout du voiture avec succees ");
				st.close();
			}catch (SQLException e) {
			System.out.println("Mise a jour echouee");
			}
		}


	public void delete(Voiture v) {
		int n = 0;
		String rq="DELETE FROM voiture where matricule=?";
		Connection cnx= SConnection.getInstance();
		PreparedStatement st ; 
		try {
			cnx = SConnection.getInstance();
			st=cnx.prepareStatement(rq);
		    st.setString(1,v.getMatricule());
		    n=st.executeUpdate();
		    if(n==1)
		    	System.out.println("le voiture a ete suprimer avec succee");
		    else System.out.println("aucun voiture n'a ete supprimee - ");
		    st.close();
		}catch (SQLException e) {
			System.out.println("le voiture n'a pas ete supprimee");
			// TODO: handle exception
		}
		
	}
		
	}
		
	
	
	

