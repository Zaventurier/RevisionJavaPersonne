package personne.personne.modele;

public class Vacataire extends Enseignant{

    Integer nombreVacations;

    public Vacataire(String nom, Integer numero_secu, Integer nombreCourss, String specialite, Integer nombreVacations) {
        super(nom, numero_secu, nombreCourss, specialite);
        this.nombreVacations = nombreVacations;
    }

    public Integer getNombreVacations() {
        return nombreVacations;
    }

    public void setNombreVacations(Integer nombreVacations) {
        this.nombreVacations = nombreVacations;
    }
}
