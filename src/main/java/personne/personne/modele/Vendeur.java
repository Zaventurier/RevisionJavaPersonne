package personne.personne.modele;

public class Vendeur extends personne{
    Integer anciennete;
    String nomDuStand;

    public Vendeur(String nom, Integer numero_secu, Integer anciennete, String nomDuStand) {
        super(nom, numero_secu);
        this.anciennete = anciennete;
        this.nomDuStand = nomDuStand;
    }

    public Integer getAnciennete() {
        return anciennete;
    }

    public void setAnciennete(Integer anciennete) {
        this.anciennete = anciennete;
    }

    public String getNomDuStand() {
        return nomDuStand;
    }

    public void setNomDuStand(String nomDuStand) {
        this.nomDuStand = nomDuStand;
    }

}
