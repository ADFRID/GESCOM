package metier;

import dao.BdD;

public class Article {

    /* propriétés privées */
    private int idArticle, qteStock;
    private Double caArticle, prix;
    private String designation;
    private Tva uneTva;
    private Famille uneFamille;
    
    /* getters et setters */
    
    private void setIdArticle(int id){
        this.idArticle=id;
    }
    public int getIdArticle(){
        return this.idArticle;
    }
    private void setQteStock(int qte){
        this.qteStock=qte;
    }
    public int getQteStock(){
        return this.qteStock;
    }
    private void setCaArticle(double ca){
        this.caArticle=ca;
    }
    public double getCaArticle(){
        return this.caArticle;
    }
    private void setPrix(double p){
        this.prix=p;
    }
    public double getprix(){
        return this.prix;
    }
    private void setDesignation(String d){
        this.designation=d;
    }
    public String getDesignation(){
        return this.designation;
    }
    private void setUneTva(Tva maTva){
        this.uneTva=maTva;
    }
    public Tva getUneTva(){
        return this.uneTva;
    }
    private void setUneFamille(Famille maFamille){
        this.uneFamille=maFamille;
    }
    public Famille getUneFamille(){
        return this.uneFamille;
    }
    
    public Article(int idArticle, String designation, int qteStock, double prix, Tva uneTva, Famille uneFamille) {
        /* Affectations */
        setIdArticle(idArticle);
        setDesignation(designation);
        setQteStock(qteStock);
        setPrix(prix);
        setUneTva(uneTva);
        setUneFamille(uneFamille);
    }
}
