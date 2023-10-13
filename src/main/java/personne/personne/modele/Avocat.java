package personne.personne.modele;

public class Avocat extends personne{

    String nombreAffaires;
    String AdresseCabinet;

    public Avocat(String nom, Integer numero_secu, String nombreAffaires, String adresseCabinet) {
        super(nom, numero_secu);
        this.nombreAffaires = nombreAffaires;
        AdresseCabinet = adresseCabinet;
    }

    public String getNombreAffaires() {
        return nombreAffaires;
    }

    public void setNombreAffaires(String nombreAffaires) {
        this.nombreAffaires = nombreAffaires;
    }

    public String getAdresseCabinet() {
        return AdresseCabinet;
    }

    public void setAdresseCabinet(String adresseCabinet) {
        AdresseCabinet = adresseCabinet;
    }
}
