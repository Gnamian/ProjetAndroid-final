package ci.gnamian.projet.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import ci.gnamian.projet.R;
import ci.gnamian.projet.model.modele.Amis;
import ci.gnamian.projet.model.modele.Famille;
import ci.gnamian.projet.model.modele.Personne;

public class PersonneAdapter extends RecyclerView.Adapter<PersonneAdapter.ViewHolder> {
    private ArrayList<Personne> personnes;
    private int couleurEleve, couleurEnseignant;
    private OnPersonneListener onPersonneListener;


    public PersonneAdapter(ArrayList<Personne> personnes, OnPersonneListener onPersonneListener) {
        this.personnes = personnes;
        this.onPersonneListener = onPersonneListener;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ligne_personne, parent, false);
        couleurEleve = ContextCompat.getColor(parent.getContext(), R.color.colorPrimaryDark);
        couleurEnseignant = ContextCompat.getColor(parent.getContext(), R.color.colorAccent);

        return new PersonneAdapter.ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Personne personne = personnes.get(position);

        holder.tv_nom.setText(personne.getNom());
        holder.tv_prenom.setText(personne.getPrenom());

        if (personne instanceof Amis) {
            holder.tv_section.setText((CharSequence) personne);
            holder.tv_nom.setTextColor(couleurEleve);
            holder.tv_prenom.setTextColor(couleurEleve);


        } else if (personne instanceof Famille) {
            holder.tv_section.setText((CharSequence) personne);
            holder.tv_nom.setTextColor(couleurEnseignant);
            holder.tv_prenom.setTextColor(couleurEnseignant);
        }

        personne.setAge(10);

        holder.root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onPersonneListener != null) {
                    onPersonneListener.onClick(personne);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return personnes.size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tv_nom, tv_prenom, tv_section;
        public View root;

        public ViewHolder(View itemView) {
            super(itemView);

            tv_nom = (TextView) itemView.findViewById(R.id.tv_nom);
            tv_prenom = (TextView) itemView.findViewById(R.id.tv_prenom);
            tv_section = (TextView) itemView.findViewById(R.id.tv_section);
            root = itemView.findViewById(R.id.root);
        }
    }
    public interface OnPersonneListener {

        void onClick(Personne personne);

    }
}
