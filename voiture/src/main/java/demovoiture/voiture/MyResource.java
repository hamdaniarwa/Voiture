package demovoiture.voiture;

import java.sql.SQLException;

import demovoiture.voiture.dao.ClientDAO;
import demovoiture.voiture.dao.VoitureDAO;
import demovoiture.voiture.metier.Client;
import demovoiture.voiture.metier.Voiture;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    @GET
    @Path("identifiant/{cin}")
    @Produces("application/json")
    public Client findClient(@PathParam("cin") String cin) throws SQLException{
    ClientDAO pdao=new ClientDAO();
    System.out.println("cin");
        return pdao.FindById("cin") ;
       
        }
    //http://localhost:8005/voiture/webapi/myresource/create?cin=14789566&adresse=sfax&nbredelocation=5&nomprenom=cdef&numtel=123
    @POST
    @Path("create")
    @Produces("application/json")
    public void saveclient(@QueryParam("cin") String cin,
    		@QueryParam("adresse") String adresse,
            @QueryParam("nomprenom") String nomprenom,
            @QueryParam("nbredelocation") int nbredelocation,
            @QueryParam("numtel") int numtel ) {
    Client c =new Client(cin, adresse, nomprenom, nbredelocation,numtel);
    ClientDAO pdao=new ClientDAO();
     pdao.saveclient(c);
    //System.out.println(c);

    }
    //http://localhost:8005/voiture/webapi/myresource/remove/2222222
    @DELETE
    @Path("remove/{id}")
    public boolean delete(@PathParam("cin") String cin)
    {
    	ClientDAO pdao=new ClientDAO();
       
      return  pdao.delete(cin);
}
  //http://localhost:8005/voiture/webapi/myresource/modify/2222222?adresse=sousse
    @PUT
    @Path("modify/{cin}")
    @Produces("application/json")
    public Boolean updateclient(@PathParam("cin") String cin ,@QueryParam("adresse") String adresse
    )
    {
    Client p =new Client(cin,adresse);
    ClientDAO pdao=new ClientDAO();
    return pdao.updateclient(p);
    }
  //http://localhost:8005/voiture/webapi/myresource/new?matricule=125&marque=fiat&couleur=noir&model=nnn&nbrPlace=5&prix=75
    @POST
    @Path("new")
    @Produces("application/json")
    public void saveVoiture(@QueryParam("matricule") String matricule,
            @QueryParam("marque") String marque,
            @QueryParam("couleur") String couleur,
            @QueryParam("model") String model ,
            @QueryParam("nbrPlace") int nbrPlace , 
           @QueryParam("prix") float prix) {
    Voiture v =new Voiture(matricule, marque, couleur,nbrPlace,prix,model);
   VoitureDAO pdao1=new VoitureDAO();
     pdao1.saveVoiture(v);
    //System.out.println(c);

    }
}
