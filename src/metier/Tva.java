package metier;

import java.util.*;

public class Tva {

    /* propriétés privées */
    private int idtva;
    private Double tauxTva;
    
    private void setIdtva(int id){
        this.idtva=id;
    }
    private void setTauxTva(Double taux){
        this.tauxTva=taux;
    }
    public int getIdtva(){
        return this.idtva;
    }
    public Double getTauxTva(){
        return this.tauxTva;
    } 
    
    public Tva(int idTva, double tauxTva) {
        setIdtva(idtva);
        setTauxTva(tauxTva);
    }

    

}
