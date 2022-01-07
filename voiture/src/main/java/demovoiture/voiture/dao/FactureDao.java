package demovoiture.voiture.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import demovoiture.voiture.metier.Facture;
import demovoiture.voiture.metier.Reservation;

public class FactureDao {
	

	public void save (Facture f) {
		String rq= "update facture set   res=?,codeclient=? , montant=?,Date=? where numfacture=?";
		Connection cnx= (Connection) SConnection.getInstance();
		java.sql.PreparedStatement st= null;
	int n=0;
			try {
				st = cnx.prepareStatement(rq);
				st.setString(1,f.getNumero());
				st.setInt(2,f.getRes().getNumres());
				st.setString(3, f.getClient().getCin());
				st.setFloat(4,f.getMontant());
				st.setObject(5,f.getDateFacture());
			
				
				n= st.executeUpdate();
				st.close();
			} catch (SQLException e) {
				System.out.println("Exception dans MAJ de la facture ");
			}
			if(n==0) //n=0 => ajouter la facture
			{ String rq2= "insert into facture(numfacture, res,codeclient,montant,date) values (?,?,?,?,?)";
			try {
				st = cnx.prepareStatement(rq2);
				st.setString(1,f.getNumero());
				st.setInt(2,f.getRes().getNumres());
				st.setString(3, f.getClient().getCin());
				st.setFloat(4,f.getMontant());
				st.setObject(5,f.getDateFacture());
				n= st.executeUpdate();
				st.close();
				System.out.println("Facture ajoutee avec succes");
			} catch (SQLException e) {
				System.out.println("Exception dans l'ajout de la facture ");
			}
			}
	}
	
	public void delete (String f1) {
		String rq1= "select date from facture where numF=?";
		java.sql.Connection cnx= SConnection.getInstance();
		long annee=0; //la diff�rence entre la date actuelle et la date de la facture (en terme d'ann�es)
		java.sql.PreparedStatement st1=null;
		try {
			st1 = cnx.prepareStatement(rq1);
			st1.setString(1, f1);
			ResultSet res=st1.executeQuery();
			if(res.next())
				{
				LocalDate ld= res.getDate(3).toLocalDate(); 
				LocalDate auj= LocalDate.now();
				annee= ChronoUnit.YEARS.between(ld, auj);
				System.out.println("annee == "+ annee);
				}
			st1.close(); 
		} catch (SQLException e) {
			System.out.println("La requete rq1 n'a pas pu etre executee");
		}
//----Si annee<10 (la facture date moins de 10 ans)
		if(annee>10) {
		String rq= "update facture set etat=FALSE where numF=?";
		java.sql.PreparedStatement st2;
		try {
			st2 = cnx.prepareStatement(rq);
			st2.setString(1, f1);
			int n2= st2.executeUpdate(); 
			if (n2 == 1)
				System.out.println("La facture est archivee avec succes");
			else
				System.out.println("Probleme dans l'archivage de facture");
			st2.close(); 
		} catch (SQLException e) {
			System.out.println("La requete de l'archivage de la facture n'a pas �t� ex�cut�e");
		}
	}
	else { //Supprimer la facture
		String rq3= "delete from facture where numf=?";
		java.sql.PreparedStatement st;
		int n2=0;
		try {
				st = cnx.prepareStatement(rq3);
				st.setString(1, f1);
				n2= st.executeUpdate();
				st.close(); 
			    System.out.println("La suppression de facture et ses lignes sont effectu�es avec succ�s!");
		} catch (SQLException e) {
			System.out.println("Exception dans la suppression de facture !!");
		}
	}
}
	
	
	//----------------------------findById------------------------------------
			public Facture findById(int n){ 
				
				Facture f1= null;
				ReservationDao bdReservation = new ReservationDao();
				Reservation  r2=null;
				
				String rq = "select * from facture where numF=?";
				Connection cnx= (Connection) SConnection.getInstance();
				PreparedStatement st;
				
				try {
					
					st = (PreparedStatement) cnx.prepareStatement(rq);
					st.setInt(1, n);		
					ResultSet res=st.executeQuery();
					if (res.next()) 
						//Client c1
					//r2= bdReservation.findById(res.getInt(1));
				   f1 = new Facture(res.getInt(1),res.getFloat(2),res.getDate(3).toLocalDate(),r2,res.getBoolean(5));
					
				} catch (SQLException e) {
					System.out.println("La requete de recherche de facture n'a pas ete executee");
				}
				return f1;
			}
}
			
	








