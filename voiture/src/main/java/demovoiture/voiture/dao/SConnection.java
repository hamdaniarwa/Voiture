package demovoiture.voiture.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SConnection {

	
		//FF private static String url = "jdbc:mysql://localhost:3306/bdvoiture"+"autoReconnect=true&useSSL=false";
		private static String url = "jdbc:mysql://localhost:3306/dbvoitures";
		private static String utilisateur= "root";
		private static String motPasse="";
		private static Connection cnx;

		
		public static Connection getInstance()
		{   
		try {
			 
			 
		if(cnx==null || cnx.isClosed()) {
		
			 Class.forName("com.mysql.jdbc.Driver");
			 cnx=DriverManager.getConnection(url,utilisateur,motPasse);
		  cnx=DriverManager.getConnection(url,utilisateur,motPasse);
		  System.out.println("Connexion a la base de donnees ");
		  }
		}
		catch (ClassNotFoundException e) { 
		System.out.println("Classe Driver introuvable");
		}
		catch (SQLException e) {
		System.out.println("L'etablissement de la connexion a echoue.");
		}
		return cnx;
		}
//-------------Fermer la connexion-----------------------
		public static void close()
		{
			try{
				if(cnx!=null && !cnx.isClosed()) {
					cnx.close();}
			   }
			catch(SQLException e){
				System.out.print("Erreur lors de la fermeture de la connexion ");
			}
		}	
}
