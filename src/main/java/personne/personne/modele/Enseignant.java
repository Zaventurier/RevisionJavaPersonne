package personne.personne.modele;

public class Enseignant extends personne{
    Integer nombreCourss;
    String specialite;

    public Enseignant(String nom, Integer numero_secu, Integer nombreCourss, String specialite) {
        super(nom, numero_secu);
        this.nombreCourss = nombreCourss;
        this.specialite = specialite;
    }

    public Integer getNombreCourss() {
        return nombreCourss;
    }

    public void setNombreCourss(Integer nombreCourss) {
        this.nombreCourss = nombreCourss;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
}
