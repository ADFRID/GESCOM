package gescom;

import metier.*;
import dao.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import utilitaires.Clavier;
import utilitaires.Outils;

public class Gescom {

    /* Déclaration de l'objet de type BdD */
    static BdD bdd;
    public static void main(String[] args) throws Exception {
        /* Instanciation de l'objet de type BdD */
        bdd = new BdD();
        /* Déclaration et instanciation d'un objet de type Representant */
          List<Client>lesClients;
          lesClients=null;
          Representant unRepresentant = new Representant(100, "Paul", "Auchon",lesClients );
//        Representant unRepresentant = new Representant(100, "Paul", "Auchon", bdd.getClientsBdD());
        int choix = menu();
        while (choix >= 0 ) {
            switch (choix) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    listerClients(unRepresentant);
                    break;
                case 2:
                    afficherArticlesCommandes(unRepresentant);
                    break;
                case 3:
                    rechercherCommande(unRepresentant);
                    break;
                case 4:
                    ajouterCommande(unRepresentant);
                    afficherCommandesClient(unRepresentant);
                    break;
                case 5:
                    supprimerCommande(unRepresentant);
                    listerClients(unRepresentant);
                    break;
                case 6:
                    supprimerLigne(unRepresentant);
                    break;
                case 7:
                    afficherCaClient(unRepresentant);
                    break;
                case 8:
                    afficherCaClients(unRepresentant);
                    break;
            }
            choix = menu();
        }
    }

    private static int menu() {
        System.out.println("Menu général");
        System.out.println();
        System.out.println("1..Lister les clients et leurs commandes");
        System.out.println("2..Liste des articles commandés");
        System.out.println("3..Rechercher une commande");
        System.out.println("4..Ajouter une commande");
        System.out.println("5..Supprimer une commande");
        System.out.println("6..Supprimer une ligne d'une commande");
        System.out.println("7..Afficher le CA d'un client");
        System.out.println("8..Afficher le CA de tous les clients");
        
        System.out.println("0..Quitter");
        Scanner sc = new Scanner(System.in);
        System.out.println("Votre choix : ");
        int choix = sc.nextInt();
        return choix;
    }

    /**
     * Saisie de l'id du client à recherché, si trouvé
     * parcours de la liste des commande et pour chaque
     * commande, affiche la commande
     * sinon affiche client inexistant
     * @param unRepresentant 
     */
    private static void afficherCaClient(Representant unRepresentant) throws Exception {
        /* A compléter */
        try{
        int idClient=Clavier.saisie_int("Numéro client : ");
            unRepresentant.getClientById(idClient);
            if( unRepresentant.getClientById(idClient)==null)
                afficher("Ce client");
            else{
                Client unClient=unRepresentant.getClientById(idClient);
                unClient.cumulCA(unClient);
                
                System.out.println("CA du client : "+unClient.getCaClient());
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
        
    

    /**
     * Saisie de l'id du client à recherché, si trouvé
     * parcours de la liste des commande et pour chaque
     * commande, affiche la commande
     * sinon affiche client inexistant
     * @param unRepresentant 
     */
    private static void afficherCommandesClient(Representant unRepresentant) {
        /* A compléter */
    }

    /**
     * Parcours de la liste des clients et pour chaque client
     * affiche son id et sa raison sociale, puis parcours de
     * la liste des commandes du client et affiche chaque
     * commande
     * @param unRepresentant 
     */
    private static void listerClients(Representant unRepresentant) throws Exception {
        
        try{
        System.out.println("Liste des clients et de leurs commandes :");
        
        for(int i=0; i<unRepresentant.getLesClients().size(); i++){
          Client unClient =unRepresentant.getLesClients().get(i);
          System.out.println(unClient.getIdClient()+ " " +unClient.getRaisonSociale());
          List<Commande>LesCommandes=unClient.getLesCommandes();
            for(int s=0; s<LesCommandes.size(); s++){
                Commande uneCommande=LesCommandes.get(s);
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
                String uneDate=simpleDateFormat.format(uneCommande.getDateCommande());
                System.out.println("Commande : " + uneCommande.getIdCommande() + " du " + uneDate);
                List<Ligne>Leslignes=uneCommande.getLesLignes();
                for(int j=0; j<Leslignes.size();j++){
                    Ligne uneLigne=Leslignes.get(j);
                    Article unArticle=uneLigne.getUnArticle();
                    System.out.println(unArticle.getIdArticle() + " " + unArticle.getDesignation() + ", quantité : " + uneLigne.getQteCommande());
                }
            }
        }
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
    }

    /**
     * Saisie du numéro de la commande à suprimer,
     * parcours de la liste de tous les clients, si la commande  
     * est trouvée, la supprimer de la liste des commandes 
     * de ce client et arrêter le parcours.
     * @param unRepresentant 
     */
    private static void supprimerCommande(Representant unRepresentant) throws Exception {
        /* A compléter */
        try{
        int idCommande = Clavier.saisie_int("Numéro Commande : ");
        for(int i=0; i<unRepresentant.getLesClients().size(); i++){
            Client unClient=unRepresentant.getLesClients().get(i);
            if(unClient.getCommandeById(idCommande)==null){
                afficher("Cette commande");
                break;
            }else{
                for(int j=0;j<unClient.getLesCommandes().size(); j++){
                Commande uneCommande=unClient.getLesCommandes().get(i);
                if(uneCommande.getIdCommande()==idCommande){
                  unClient.getLesCommandes().remove(uneCommande);
                  break;}
                }    
            }
        }
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
           
        
            
        
    

    /**
     * Affiche la liste des articles commandés sans doublons.
     * Déclare et instancie une collection d'Article
     * Parcours de la liste des clients et pour chaque client
     * parcours de la liste de ses commandes et pour chaque 
     * commande parcours de la liste des lignes
     * Si la liste locale ne contient pas l'article de la ligne
     * en cours ,l'ajouter et afficher l'article
     * @param unRepresentant 
     */
    private static void afficherArticlesCommandes(Representant unRepresentant) throws Exception {
        /* A compléter */
        try{
        System.out.println("Liste des articles commandés :");
        List<Article>LesArticles=new ArrayList<Article>();
        
        for(int i=0; i<unRepresentant.getLesClients().size(); i++){
            Client unClient=unRepresentant.getLesClients().get(i);
            for(int e=0;e<unClient.getLesCommandes().size();e++){
                Commande uneCommande=unClient.getLesCommandes().get(e);
                for(int z=0; z<uneCommande.getLesLignes().size();z++){
                    Ligne uneLigne=uneCommande.getLesLignes().get(z);
                        if(LesArticles.contains(uneLigne.getUnArticle()))
                            continue;
                        else
                            LesArticles.add(uneLigne.getUnArticle());
                }
            }
        }
        for(int p=0; p<LesArticles.size();p++){
           Article unArticle=LesArticles.get(p);
           Famille uneFamille=unArticle.getUneFamille();
           Tva uneTva=unArticle.getUneTva();
           System.out.println("Article : " +unArticle.getIdArticle()+" "+unArticle.getDesignation()+", Famille : "+uneFamille.getLibFamille()+" , TVA : "+uneTva.getTauxTva());
        }
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    /**
     * Affiche l'id, la désignation, la famille et la TVA
     * de l'article passé en paramètre
     * @param unArticle 
     */
    private static void afficherArticle(Article unArticle) {
        try{
        Famille uneFamille=unArticle.getUneFamille();
        System.out.println(unArticle.getIdArticle()+" "+unArticle.getDesignation()+" "+uneFamille.getLibFamille()+" "+unArticle.getUneTva());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
        /* A compléter */
    
    

    /**
     * Parcours de la liste des clients et pour chaque client, 
     * appel de la méthode cumulCA() et affichage de l'id
     * de la raison sociel et du CA du client
     * @param unRepresentant 
     */
    private static void afficherCaClients(Representant unRepresentant) throws Exception {
        /* A compléter */
        try{
        System.out.println("Liste des CA des clients : ");
        for(int i=0; i<unRepresentant.getLesClients().size();i++){
            Client unClient=unRepresentant.getLesClients().get(i);
            unClient.cumulCA(unClient);
            System.out.println(unClient.getIdClient()+ " " +unClient.getRaisonSociale()+" CA : "+unClient.getCaClient());
        }
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Recherche la commande d'un client.
     * saisie de l'id du client, récupération
     * du client, s'il existe : saisie de l'id
     * de la commande, récupération de la commande
     * si elle existe afficher la commande, sinon 
     * afficher commande inexistante, idem pour 
     * le client
     * @param unRepresentant 
     */
    private static void rechercherCommande(Representant unRepresentant) throws Exception {
        /* A compléter */
        
        int idClient = Clavier.saisie_int("Numéro client : ");
        try{
        unRepresentant.getClientById(idClient);
        if(unRepresentant.getClientById(idClient)==null){
            afficher("ce client n'existe pas !");
        }else{
        Client unClient=unRepresentant.getClientById(idClient);
        int idCommande=Clavier.saisie_int("Numéro commande");
        Commande uneCommande=unClient.getCommandeById(idCommande);
        if(unClient.getCommandeById(idCommande)==null){
            afficher("Cette commande n'existe pas !");
        }else{
        afficherCommande(uneCommande);
        }
        
        }
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Supprimer une ligne de commande :
     * Saisie de l'id du client et récupération du client
     * S'il n'existe pas afficher client inexistant, 
     * s'il existe : saisie de l'id de la commande
     * récupération de la commande, si elle n'existe pas
     * afficher commande inexistante, si elle existe
     * saisie de l'id de l'article, rechercher la ligne
     * ayant l'id de l'article, si la ligne existe la supprimer
     * sinon afficher que l'article ne figure pas dans cette commande
     * @param unRepresentant 
     */
    private static void supprimerLigne(Representant unRepresentant) throws Exception {
        /* A compléter */
        try{
        int idClient = Clavier.saisie_int("Numéro client : ");
        Client unClient=unRepresentant.getClientById(idClient);
        if(unRepresentant.getClientById(idClient)==null)
            afficher("Ce client");
        else{
        int idCommande = Clavier.saisie_int("Numéro commande : ");
        Commande uneCommande= unClient.getCommandeById(idCommande);
        if(unClient.getCommandeById(idCommande)==null)
            afficher("Cette commande");
        int idArticle = Clavier.saisie_int("Numéro article : ");
        Ligne uneLigne=uneCommande.chercherLigne(idArticle, bdd);
        if(uneCommande.chercherLigne(idArticle, bdd)==null)
            System.out.println("Cet article ne figure pas dans cette commande.");
        uneCommande.supprimerLigne(uneLigne);
        }
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    /**
     * Ajoute une commande à un client.
     * Saisie de l'id du client et recherche du client
     * S'il nexiste pas afficher client inexistant
     * S'il existe : saisie de l'id et de la date de commande
     * création de la commande et ajout à la liste des 
     * commandes du client, saisie de l'id de l'article
     * et de la qte commandée, ajout de la ligne à la
     * commande
     * Rappel : la classe bdd propose une méthode de recherche d'un article sur son id
     * @param unRepresentant 
     */
    private static void ajouterCommande(Representant unRepresentant) throws Exception {
        /* A compléter */
        try{
        int idClient = Clavier.saisie_int("Numéro client : ");
        Client unClient=unRepresentant.getClientById(idClient);
        if(unRepresentant.getClientById(idClient)==null)
            afficher("Ce client");
        else{
            int idCommande=Clavier.saisie_int("Numéro de commande : ");
            String dateCommande = Clavier.saisie_string("Date de commande");
            Commande uneCommande=new Commande(idCommande,Outils.stringToDate(dateCommande) );
            unClient.getLesCommandes().add(uneCommande);
            int idArticle= Clavier.saisie_int("Numéro article : ");
            int QteCommande=Clavier.saisie_int("Quantité commandée :");
            Ligne uneLigne=new Ligne(bdd.getArticleBdD(idArticle),QteCommande);
            uneCommande.getLesLignes().add(uneLigne);
        }
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
        
    /**
     * Affiche l'id, la date de la commande,
     * puis affiche la liste des lignes : id article
     * désignation et qte commandée
     * @param uneCommande 
     */
    private static void afficherCommande(Commande uneCommande) throws Exception {
        /* A compléter */
        try{
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
        String uneDate=simpleDateFormat.format(uneCommande.getDateCommande());
        System.out.println("Commande  : " +uneCommande.getIdCommande() + " du : " + uneDate);
        for(int i=0;i<uneCommande.getLesLignes().size();i++){
            Ligne uneLigne=uneCommande.getLesLignes().get(i);
            Article unArticle=uneLigne.getUnArticle();
            System.out.println(uneLigne.getUnArticle().getIdArticle()+" "+uneLigne.getUnArticle().getDesignation()+", quantité : "+uneLigne.getQteCommande());
            
        }
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public static  void afficher(String message){
        System.out.println(message+" n'existe pas");
    }
   
}
   
    
    
    


