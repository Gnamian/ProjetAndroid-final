package ci.gnamian.projet.controller;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ci.gnamian.projet.R;
import ci.gnamian.projet.model.modele.Amis;
import ci.gnamian.projet.model.modele.Famille;
import ci.gnamian.projet.model.modele.Personne;
import ci.gnamian.projet.view.PersonneAdapter;

public class Contact extends AppCompatActivity implements View.OnClickListener, PersonneAdapter.OnPersonneListener {
    Button bt_ajouter, bt_supp_dernier;
    Button bt_ajouter_plusieurs;
    EditText et_nom, et_numero;
    SeekBar sb;
    RadioButton rb_parent, rb_ami;
    RecyclerView rv;

    ArrayList<Personne> personnes;


    PersonneAdapter personneAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.menu);
        bt_ajouter = (Button) findViewById(R.id.bt_ajouter);
        bt_supp_dernier = (Button) findViewById(R.id.bt_supp_dernier);
        et_nom = (EditText) findViewById(R.id.et_nom);
        et_numero = (EditText) findViewById(R.id.et_numero);
        rb_parent = (RadioButton) findViewById(R.id.rb_parent);
        rb_ami = (RadioButton) findViewById(R.id.rb_ami);
        rv = (RecyclerView) findViewById(R.id.rv);

        bt_ajouter.setOnClickListener(this);
        bt_supp_dernier.setOnClickListener(this);
        bt_ajouter_plusieurs.setOnClickListener(this);


        personnes = new ArrayList<>();
        personneAdapter = new PersonneAdapter(personnes, this);

        rv.setAdapter(personneAdapter);

        rv.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onClick(View v) {

        if (v == bt_ajouter) {
            String nom = et_nom.getText().toString();
            String prenom = et_numero.getText().toString();

            ajouter(nom, prenom, 1);

        } else if (v == bt_supp_dernier) {
            supprimerDernier();
        } else if (v == bt_ajouter_plusieurs) {
            int nb = sb.getProgress();
            String nom = et_nom.getText().toString();
            String prenom = et_numero.getText().toString();

            ajouter(nom, prenom, nb);
        }

    }

    public void ajouter(String nom, String prenom, int nb) {

        if (nom.length() == 0) {
            Toast.makeText(this, "Le nom et le prénom sont vides", Toast.LENGTH_SHORT).show();
            return;
        }
        if (prenom.length() == 0) {
            Toast.makeText(this, "Le Numéro est vide", Toast.LENGTH_SHORT).show();
            return;
        }


        for (int i = 0; i < nb; i++) {
            if (rb_parent.isChecked()) {
                Amis parent = new Amis(nom, prenom, "Parents");
                personnes.add(parent);
            } else {
                Famille famille = new Famille(nom, prenom, "Amis");
                personnes.add(famille);
            }
        }
        personneAdapter.notifyDataSetChanged();

    }


    public void supprimerDernier() {

        Personne dernier = null;


        for (Personne personne : personnes) {
            if (rb_parent.isChecked() && personne instanceof Amis) {
                dernier = personne;
            } else if (rb_ami.isChecked() && personne instanceof Famille) {
                dernier = personne;
            }
        }

        if (dernier != null) {
            personnes.remove(dernier);
        } else if (rb_parent.isChecked()) {
            Toast.makeText(this, "Il n'y a plus de parent dans la liste", Toast.LENGTH_SHORT).show();
        } else if (rb_ami.isChecked()) {
            Toast.makeText(this, "Il n'y a plus d'amis dans la liste", Toast.LENGTH_SHORT).show();
        }
        personneAdapter.notifyDataSetChanged();

    }

    @Override
    public void onClick(Personne personne) {
        Toast.makeText(this, "Vous avez cliquez sur " + personne.getNom() + " " + personne.getPrenom(), Toast.LENGTH_SHORT).show();

    }
}
