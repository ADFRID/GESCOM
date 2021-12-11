package metier;

public class Famille {

    /* propriétés privées */
    
    private int idFamille;
    private String libFamille;
    
    /* getters et setters */
    
    private void setIdFamille(int id){
        this.idFamille=id;
    }
    private void setLibFamille(String lib){
        this.libFamille=lib;
    }
    public int getIdFamille(){
        return this.idFamille;
    }
    public String getLibFamille(){
        return this.libFamille;
    }
    
    public Famille(int idFamille, String libFamille) {
        setIdFamille(idFamille);
        setLibFamille(libFamille);
        
    }



}
