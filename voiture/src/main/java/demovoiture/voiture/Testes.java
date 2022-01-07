package demovoiture.voiture;


import java.sql.Date;
import java.time.LocalDate;

import demovoiture.voiture.dao.ClientDAO;
import demovoiture.voiture.dao.FactureDao;
import demovoiture.voiture.dao.ReservationDao;
import demovoiture.voiture.dao.VoitureDAO;
import demovoiture.voiture.metier.Client;
import demovoiture.voiture.metier.Facture;
import demovoiture.voiture.metier.Reservation;
import demovoiture.voiture.metier.Voiture;



public class Testes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
	/*******************Client*/	
		  ClientDAO bdClient = new ClientDAO(); 
		   Client c3 = new Client ("2222222","fedifedi" , "sousse",21414141,5);
		   Client c4 = new Client ("0000008","eya", "fhcjhc",213344,3);
		   Client c6 = new Client ("555555555","slimkallel", "sfax",1245524,2);
		   
		
		    bdClient.saveclient(c3);
		    bdClient.saveclient(c4);	
		    bdClient.saveclient(c6);
		 
		  bdClient.misAjour(c3 , "fatma");//eim� par FF: Client chercher =
		// bdClient.FindById("2222222"); //Ajout� par FF
		   bdClient.delete("0000009");
			
			
			
          /***************Voiture*/	 
			 Voiture Voiture= new Voiture();
			VoitureDAO bdVoiture=new VoitureDAO();
			 Voiture v1=new Voiture("3","fiat","nhki",4,(float)45,"2");
			 bdVoiture.saveVoiture(v1);
			 Voiture v2=new Voiture("5","fiat","gris",4,(float)45,"2");
			 bdVoiture.saveVoiture(v2);
			 // bdVoiture.delete(v1);
			  Voiture v3=new Voiture("5","BM","xxxxx",4,(float)45,"4");
			  bdVoiture.saveVoiture(v3);
			 
			 /************Reservation*/
			  Date d1=new Date(2022,01,22);
			 Date d2=new Date(2022,01,30);
			Reservation r1=new Reservation(c6,v2,d1,"5",(float)500);
			Reservation r2=new Reservation(3,d1,d1,d2,c3,v3);
			ReservationDao bdReservation= new ReservationDao();
			//Reservation.delete(c3.getCin());
		//Reservation.saveReservation(r1);
			bdReservation.saveReservation(r2);
			 
			 /*************Facture*/
			FactureDao bdFacture= new FactureDao();
			Facture f1=new Facture(c4,r1,LocalDate.of(2015, 10, 10),"1",(float)400);
			bdFacture.save(f1);
			Facture f2=new Facture(c6,r2,LocalDate.of(2021,01,10),"5",(float)300);
			bdFacture.save(f2);
			
		

}
}
