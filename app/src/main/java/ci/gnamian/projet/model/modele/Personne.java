package ci.gnamian.projet.model.modele;

public abstract class Personne {
    protected String nom, prenom;
    protected int age;

    public Personne(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public abstract String afficher();

    @Override
    public String toString() {
        return afficher();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o instanceof Personne) return false;

        Personne that = (Personne) o;

        if (age != that.age) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
        return prenom != null ? prenom.equals(that.prenom) : that.prenom == null;

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
