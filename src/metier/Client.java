package metier;

import java.util.*;

public class Client {

    /* propriétés privées */
    
    private int idClient;
    private String raisonSociale;
    private Double caClient;
    private Categorie uneCategorie;
    private List<Commande> lesCommandes;
    
    /* getters et setters */
    
    private void setIdClient(int id){
        this.idClient=id;
    }
    public int getIdClient(){
        return this.idClient;
    }
    private void setRaisonSociale(String r){
        this.raisonSociale=r;
    }
    public String getRaisonSociale(){
        return this.raisonSociale;
    }
    private void setCaClient(Double ca){
        this.caClient=ca;
    }
    public Double getCaClient(){
        return this.caClient;
    }
    private void setUneCategorie(Categorie c){
        this.uneCategorie=c;
    }
    public Categorie getUneCategorie(){
        return this.uneCategorie;
    }
    private void setLesCommandes(List<Commande>lesCommandes){
        this.lesCommandes=null;
        
    }
    public List<Commande> getLesCommandes() throws Exception {
//        if (lesCommandes == null ){
//            throw new Exception ("La liste des commandes n'a pas été initialisée !");
//        }
        return this.lesCommandes;
    }
    
    
    
    
    public Client(int idClient, String raisonSociale, Categorie uneCategorie) {
        setIdClient(idClient);
        setRaisonSociale(raisonSociale);
        setUneCategorie(uneCategorie);
        setLesCommandes(lesCommandes);
    }

    /**
     * Ajoute une commande à la liste des commandes
     * du client. Prendre la précaution de vérifier
     * que la liste a bien été instanciée
     * @param uneCommande 
     */
    public void ajouterCommande(Commande uneCommande) throws Exception {
        if (getLesCommandes() == null){
        this.lesCommandes = new ArrayList<Commande>();
        }
        this.lesCommandes.add(uneCommande);
            
    }

    /**
     * Affecte la somme des valorisations des commandes
     * au CA du client. Prendre la précaution de 
     * l'initialiser avant de commencer
     */
    public void cumulCA(Client unClient) throws Exception {
        /* A compléter */
       if (lesCommandes == null)
           throw new Exception ("CumulCA : les commandes n'existent pas !");
       caClient = 0.0;
       for(Commande uneCommande : lesCommandes){
           caClient += uneCommande.valoriserCommande(uneCommande);
       }
    }

    /**
     * Recherche une commande sur son numéro en 
     * parcourant la liste des commandes, Retourne
     * une Commande si trouvée, sinon retourne null
     * @param idCommande
     * @return Commande
     */
    public Commande getCommandeById(int idCommande) {
        /* A compléter */
        
        for(int i=0; i<lesCommandes.size(); i++){
            Commande uneCommande= lesCommandes.get(i);
            if(uneCommande.getIdCommande()==idCommande)
               return uneCommande;
        }
        
        return null;
    }
             
        
    
    
    /**
     * Retire une commande la liste des commandes.
     * Remarque : en supprimant une commande on supprime
     * aussi ses lignes (Composition)
     * @param uneCommande 
     */
    public void supprimerCommande(Commande uneCommande) throws Exception {
        if (this.lesCommandes != null){
            if(this.lesCommandes.contains(uneCommande)){
                this.lesCommandes.remove(uneCommande);
            }
            else
                throw new Exception ("Cette commande n'existe pas !");
        }
    }
 }

        
    



