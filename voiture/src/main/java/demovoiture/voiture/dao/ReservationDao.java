package demovoiture.voiture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import demovoiture.voiture.metier.Client;
import demovoiture.voiture.metier.Reservation;
import demovoiture.voiture.metier.Voiture;





public class ReservationDao {
	
	public Reservation findById(int r2){ //n: n� deres
		Reservation R1= null;
		Voiture v1=null;
		String s= "select * from reservation where numres=?"; 
		ClientDAO bdClient = new ClientDAO();
		VoitureDAO bdVoiture = new VoitureDAO();
		Client c1=null;
		Voiture v11=null;
		
		Connection cnx= SConnection.getInstance();
		PreparedStatement st;
		try {
			
			st = cnx.prepareStatement(s);
			st.setInt(1, r2);		
			ResultSet res=st.executeQuery();
			if (res.next()) {
				
				c1= bdClient.FindById(res.getString(2));
				//v11=bdVoiture.findById(v11);
			
			
			//R1 = new Reservation(c1,v11, res.getDate(3),res.getString(4),res.getFloat(5));
			}
			 
			  st.close(); 
		} catch (SQLException e) {
			System.out.println("La requete de recherche de Reservation n'a pas ete executée");
		}
		System.out.println(R1);
		return R1;
	}
	
	
	
	
	public void saveReservation ( Reservation r) {
		Connection cnx=   (Connection) SConnection.getInstance();
		PreparedStatement st ; 
		int n=0;
		
			try {  
				cnx =  (Connection) SConnection.getInstance();
				
				String r2="insert into reservation (numres,datedelocation,datededebut,datedefin,cin,matricule) values (?,?,?,?,?,?)";
				st=(PreparedStatement) cnx.prepareStatement(r2);
				st.setInt(1,r.getNumres());
			    st.setDate(2,r.getDatedelocation());
				st.setDate(3,r.getDatedebut());
				st.setDate(4,r.getDatedefin());
				st.setString(5,r.getCin().getCin());
				st.setString(6,r.getMat().getMatricule());
				
				System.out.println(r.toString());
				
				n= st.executeUpdate();
				
               
				System.out.println("Ajout du resevation avec succees ");
				st.close();
			}
			
			catch (SQLException e) {
			System.out.println("Mise a jour echoueé");
			}
		}
		
	


//=========================

	
	public void delete (String c ) {
		int n = 0;
		String rq="DELETE FROM reservation where datelocation=? <= SYSDATE + 3 ";
		Connection cnx= SConnection.getInstance();
		PreparedStatement st ; 
		try {
			st=cnx.prepareStatement(rq);
		    st.setObject(1,LocalDate.now().getYear()+10);
		    n=st.executeUpdate();
		    if(n==1)
		    	System.out.println("Reservation supprimer avec succeé");
		    else System.out.println("aucune Reservation  n'a ete supprimée ");
		    st.close();
		}catch (SQLException e) {
			System.out.println("la Reservation n'a pas ete supprimeé");
			// TODO: handle exception
		}
		
}
}