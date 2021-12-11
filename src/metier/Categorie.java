package metier;

import java.util.*;

public class Categorie {

    /* propriétés privées */
    
    private int idcategorie;
    private String libCategorie;

    /* getters et setters */

    private void setIdcategorie(int id){
        this.idcategorie=id;
    }
    public int getIdcategorie(){
        return this.idcategorie;
    }
    private void setLibCategorie(String lib){
        this.libCategorie=lib;
    }
    public String getLibCategorie(){
        return this.libCategorie;
    }
    
    public Categorie(int idCategorie, String libCategorie) {
        setIdcategorie(idCategorie);
        setLibCategorie(libCategorie);
        
    }
}
