package com.example.junijepalmotic.zavrsniaplikacijakviz;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.junijepalmotic.zavrsniaplikacijakviz.Model.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
public class MainActivity extends AppCompatActivity {
    RadioButton rb;
    EditText dob,obraz;
    Button daljeButton;
    RadioGroup spol;



    TextView pitanje;
    FirebaseDatabase database;
    DatabaseReference korisnici;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database=FirebaseDatabase.getInstance();
        korisnici=database.getReference("Korisnici");


        spol =findViewById(R.id.Spol);
        dob=findViewById(R.id.editText);
        daljeButton =findViewById(R.id.dalje);
        obraz=findViewById(R.id.obrazovanjeText);





        daljeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if( dob.getText().toString().isEmpty() || obraz.getText().toString().isEmpty()){
                   Toast.makeText(MainActivity.this,"Popunite sve podatke",Toast.LENGTH_SHORT).show();

                }else{

                    int radioButtonId= spol.getCheckedRadioButtonId();
                    rb=findViewById(radioButtonId);
                    User users = new User(rb.getText().toString(),dob.getText().toString(),obraz.getText().toString());
                    korisnici.push().setValue(users);
                    Intent intent = new Intent(MainActivity.this,SetAnswersActivity.class);
                    startActivity(intent);
                }
            }
        });


        }





   
}
