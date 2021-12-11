package metier;

import java.util.*;

public class Representant {

    /* propriétés privées */
    private String nom, prenom;
    private int idrepresentant;
    private Double caRepresentant;
    private List<Client> lesClients;
    
    private void setNom(String name){
        this.nom=name;
    }
    private void setPrenom(String surname){
        this.prenom=surname;
    }
    private void setIdrepresentant(int id){
        this.idrepresentant=id;
    }
    private void setCaRepresentant(Double ca){
        this.caRepresentant=ca;
    }
    private void setLesClients(List<Client>lesClients){
        if(lesClients==null)
        this.lesClients=lesClients;
    }
    public String getNom(){
        return this.nom;
    }
    public String getprenom(){
        return this.prenom;
    }
    public int getIdrepresentant(){
        return this.idrepresentant;
    }
    public Double getCaRepresentant(){
        return this.caRepresentant;
    }
    
    public List<Client> getLesClients() throws Exception{
        if (lesClients == null){
            throw new Exception ("La liste des clients n'a pas été initialisée !");
        }
        return lesClients;
    }
    
    public Representant(int idRepresentant, String prenom, String nom, List<Client> lesClients) {
        setIdrepresentant(idRepresentant);
        setPrenom(prenom);
        setNom(nom);
        setLesClients(lesClients);
    }
    
    /**
     * Recherche un Client sur son id dans la 
     * liste des clients. 
     * Retourne le Client si trouvé, sinon retourne null
     * @param idClient
     * @return Client
     */
    public Client getClientById(int idClient) throws Exception {
        /* A compléter */
        
        for(int i=0; i<lesClients.size(); i++){
            if (lesClients == null)
            throw new Exception ("La liste des clients n'a pas été initialisée !");
            
            Client unClient= lesClients.get(i);
            if(unClient.getIdClient()==idClient)
               return unClient;
        }
        
        return null;
    

}
}


    
    


    
        
    

        
   
    
    

