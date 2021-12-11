package metier;

import java.util.*;

public class Ligne {
   /* propriétés privées */
   private int qteCommande;
   private Article unArticle;
   
   /* getters et setters */
   private void setQteCommande(int qtec){
       this.qteCommande=qtec;
   }
   public int getQteCommande(){
       return this.qteCommande;
   }
   private void setUnArticle(Article monArticle){
       this.unArticle=monArticle;
   }
   public Article getUnArticle(){
       return this.unArticle;
   }

    public Ligne (Article unArticle, int qteCommande){
        setUnArticle(unArticle);
        setQteCommande(qteCommande);
    }
}