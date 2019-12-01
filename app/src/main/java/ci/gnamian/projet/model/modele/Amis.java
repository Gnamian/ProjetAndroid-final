package ci.gnamian.projet.model.modele;

import java.util.Random;

public class Amis extends Personne {
    private static final Random random = new Random();

    public Amis(String nom, String prenom) {
        this(nom, prenom, null);
    }

    public Amis(String nom, String prenom, int age) {
        this(nom, prenom, null, age);
    }

    public Amis(String nom, String prenom, String classe) {
        this(nom, prenom, classe, random.nextInt(100));
    }

    public Amis(String nom, String prenom, String classe, int age) {
        super(nom, prenom);
        this.age = age;
    }

    @Override
    public String afficher() {
        return "Amis : " + nom + " " + prenom;
    }
}
