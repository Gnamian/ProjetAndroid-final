package ci.gnamian.projet.model.modele;

public class Famille extends Personne {
    public Famille(String nom, String prenom) {
        super(nom, prenom);
    }


    public Famille(String nom, String prenom, String matiere) {
        super(nom, prenom);
    }

    @Override
    public String afficher() {
        return   nom + " " + prenom;
    }
}
