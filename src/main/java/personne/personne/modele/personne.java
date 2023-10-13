package personne.personne.modele;

public class personne {

    String nom;
    Integer numero_secu;

    public personne(String nom, Integer numero_secu) {
        this.nom = nom;
        this.numero_secu = numero_secu;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getNumero_secu() {
        return numero_secu;
    }

    public void setNumero_secu(Integer numero_secu) {
        this.numero_secu = numero_secu;
    }
}
