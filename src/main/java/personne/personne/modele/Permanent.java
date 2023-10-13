package personne.personne.modele;

public class Permanent extends Enseignant{
    Integer numeroBureau;

    public Permanent(String nom, Integer numero_secu, Integer nombreCourss, String specialite, Integer numeroBureau) {
        super(nom, numero_secu, nombreCourss, specialite);
        this.numeroBureau = numeroBureau;
    }

    public Integer getNumeroBureau() {
        return numeroBureau;
    }

    public void setNumeroBureau(Integer numeroBureau) {
        this.numeroBureau = numeroBureau;
    }
}
