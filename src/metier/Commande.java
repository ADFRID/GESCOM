package metier;

import dao.BdD;
import java.util.*;

public class Commande {

    /* propriétés privées */
    private int idCommande;
    private Date datecommande;
    private List<Ligne>lesLignes;
    
    /* getters et setters */
    
    private void setIdCommande(int id){
        this.idCommande=id;
    }
    private void setDatecommande(Date d){
        this.datecommande=d;
    }
    private void setLesLignes(List<Ligne> lesLignes){
        if(lesLignes==null)
            
        this.lesLignes=lesLignes;
    }
    public int getIdCommande(){
        return this.idCommande;
    }
    public Date getDateCommande(){
        return this.datecommande;
    }
    public List<Ligne> getLesLignes() throws Exception{
       return this.lesLignes;
    }
    
    public Commande (int idCommande, Date dateCommande){
        setIdCommande(idCommande);
        setDatecommande(dateCommande);
        setLesLignes(lesLignes);
        
    }
    
    /**
     * Ajoute une ligne à une commande.
     * Si la liste des lignes n'est pas instanciée,
     * l'instancier
     * Si l'article n'est pas dans la liste des
     * lignes, créer la ligne et l'ajouter à la liste
     * @param unArticle
     * @param qteCde 
     */
    
    public void ajouterLigne(Article unArticle, int qteCde) throws Exception {
        
        if(getLesLignes()!=null){
        
        Ligne uneLigne=new Ligne(unArticle, qteCde);
        this.lesLignes.add(uneLigne);
    }
    }
    

    /**
     * Supprime la ligne passée en paramètre
     * @param ligneASupprimer Ligne à supprimer
     */
    public void supprimerLigne(Ligne ligneASupprimer) throws Exception {
        /* A compléter */
        Ligne ligneATrouver = null;
        for(Ligne uneLigne: lesLignes){
            if(uneLigne.equals(ligneASupprimer)){
                ligneATrouver = uneLigne;
                break;
            }
        }
        if (ligneATrouver != null)
            lesLignes.remove(ligneATrouver);
        else
            throw new Exception ("Cette ligne n'existe pas !");
    }
    
    /**
     * Recherche la ligne contenant l'article ayant
     * l'id passé en paramètre. 
     * Utiliser la méthode equals() pour comparer deux objets.
     * @param idArticle identifiant de l'article à chercher
     * @param bdd objet Base de Données contenant la liste des articles
     */    
    public Ligne chercherLigne(int idArticle, BdD bdd) {
        /* A compléter */
        
       for(int i=0; i<lesLignes.size();i++){
            Ligne uneLigne=lesLignes.get(i);
            if(uneLigne.getUnArticle().equals(bdd.getArticleBdD(idArticle))){
                return uneLigne; 
            }else{
                continue;
        }
       }
       return null;
    }

    /**
     * Calcule le montant total HT de la commande 
     * à partir du prix des articles présents dans
     * les lignes de commande
     * @return Montant total HT de la commande
     */
    public double valoriserCommande(Commande uneCommande) throws Exception {
        
        /* A compléter */
    if(lesLignes == null)
        throw new Exception ("valoriserCommande : les lignes n'existent pas !");
    double totalCommande = 0.0;
    for (Ligne uneLigne : lesLignes){
        totalCommande += uneLigne.getUnArticle().getprix()*uneLigne.getQteCommande();
    }
    return totalCommande;
    }
}
