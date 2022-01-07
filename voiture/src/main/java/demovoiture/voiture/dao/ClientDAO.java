package demovoiture.voiture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import demovoiture.voiture.metier.Client;







public class ClientDAO {
	 Connection cnx ;
	

public Client  FindById(String c1) {
	String rq="select * from client where cin=?";
	Client c=null ; 
	Connection cnx = SConnection.getInstance();
	PreparedStatement st; 
	try {
		 cnx = SConnection.getInstance();
		st=cnx.prepareStatement(rq);
		st.setString(1, c1);
		ResultSet res = st.executeQuery();
		if(res.next())
			//suppeimé par FF:  c =new Client(res.getString(0), res.getString(2), res.getString(1), res.getInt(3),res.getInt(3));
			//Ajouté par FF
			c =new Client(res.getString(1), res.getString(2), res.getString(3), res.getInt(4),res.getInt(5));
		st.close();
		
		
	}catch (SQLException e) {
		System.out.println("client non trouv�");
	}
	return c ; 
}



//==========================================
public void misAjour (Client c , String newname) {
	int n = 0 ; 
	String rq1="update client set nomprenom =? where cin=?";
	Connection cnx= SConnection.getInstance();
	PreparedStatement st ; 
	try {
		cnx = SConnection.getInstance();
		st=cnx.prepareStatement(rq1);
		st.setString(1, newname);
		st.setString(2, c.getCin());
		n=st.executeUpdate();
		st.close();
		if(n==1) {
		System.out.println("Mise a jour du client avec succees:");
		}
			
	
	}catch (SQLException e) {
		System.out.println("Aucune modification");
	}
	
}
public void saveclient(Client c ) {
	
	
	Connection cnx= SConnection.getInstance();
	PreparedStatement st ; 
      int n = 0 ; 
		try {
			 cnx = SConnection.getInstance();
			//FF: String r2="insert into cient (cin , adresse , numtel , nomprenom) values(?,?,?,?) ";
			//Ajouté par FF
			String r2="insert into client (cin,nomprenom,adresse,numtel,nbredelocation) values (?,?,?,?,?)";
			 st=cnx.prepareStatement(r2);
			st.setString(1,c.getCin());
			//FF:  st.setString(2,c.getAdresse());
			st.setString(2,c.getNomprenom());
			st.setString(3,c.getAdresse());
			st.setInt(4,c.getNumtel());
			//FF:  st.setInt(3,c.getNumtel());
			//FF:  st.setString(4,c.getNomprenom());
			//FF
			st.setInt(5,c.getNbredelocation());
			
			n= st.executeUpdate();
			//FF
			System.out.println("Ajout du client avec succees ");
			st.close();
		}catch (SQLException e) {
		System.out.println("Mise a jour echouee");
		}
	}
/*public void save(Client c) {
	Connection cnx=   (Connection) SConnection.getInstance();
		PreparedStatement st ; 
		int n=0;
			try {  
				cnx =  (Connection) SConnection.getInstance();
				
				String r2="insert into Client (cin,nomprenom,adresse,numtel,nbrelocation) values (?,?,?,?,?)";
				st=(PreparedStatement) cnx.prepareStatement(r2);
				st.setString(1,c.getCin());
			    st.setString(2,c.getNomprenom());
				st.setString(3,c.getAdresse());
				st.setInt(4,c.getNumtel());
				st.setInt(5,c.getNbredelocation());
				
				System.out.println(c.toString());
				
				n= st.executeUpdate();
				
               
				System.out.println("Ajout du client  avec succees ");
				st.close();
			}
			
			catch (SQLException e) {
			System.out.println("Mise a jour echoue�");
			}
		}*/
		
	


//=========================
 public static boolean delete(String cin) {
	Connection cnx = SConnection.getInstance();
	boolean b = true;
	try {

		String req = "delete from client where cin= ?";
		PreparedStatement sta = cnx.prepareStatement(req);
		sta.setString(1, cin);
		b = sta.execute();
	} catch (SQLException e) {
		System.out.println(e.getMessage());
	}
	return b;
}
 
	public static Boolean updateclient(Client cmp ) {
		Connection cnx = SConnection.getInstance();

		try {
			String req = ("update client set adresse=?  where cin =?");
			PreparedStatement pstm = cnx.prepareStatement(req);
			pstm.setString(1,cmp.getCin());
			pstm.setString(2, cmp.getAdresse());
			
			return pstm.executeUpdate()>0;
		} catch (SQLException a) {
			System.out.println(a.getMessage());
		}
return false;

	}
}





