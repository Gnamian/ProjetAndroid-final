package ci.gnamian.projet;

import androidx.appcompat.app.AppCompatActivity;
import ci.gnamian.projet.controller.Contact;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menu extends AppCompatActivity {
    private Button contact;
    private Button calcul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        this.contact = (Button) findViewById(R.id.contact);
        this.calcul = (Button) findViewById(R.id.calcul);
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity=new Intent(getApplicationContext(), Contact.class);
                startActivity(otherActivity);
                finish();
            }
        });
        calcul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity=new Intent(getApplicationContext(), calco.class);
                startActivity(otherActivity);
                finish();
            }
        });
    }
}
