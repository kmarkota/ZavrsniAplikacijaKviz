package com.example.junijepalmotic.zavrsniaplikacijakviz;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.junijepalmotic.zavrsniaplikacijakviz.Model.Main2Activity;
import com.example.junijepalmotic.zavrsniaplikacijakviz.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    RadioButton Musko,Zensko,rb;// za unos na firebase
    EditText Dob,Obraz;// za unso na firebase
    Button Dalje,UnesiPodatke;/// dalje za unos na firebase
    RadioGroup Spolicc;
    String Spolic;
    // za pitanja
    Button odg1,odg2,odg3,odg4,odg5;
    TextView pitanje;


    FirebaseDatabase database;
    DatabaseReference korisnici,pitanja,choice1,choice2,choice3,choice4,choice5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database=FirebaseDatabase.getInstance();
        korisnici=database.getReference("Korisnici");


        Spolicc =(RadioGroup)findViewById(R.id.Spol);
        Dob=(EditText)findViewById(R.id.editText);
        Dalje=(Button)findViewById(R.id.dalje);
        Obraz=(EditText)findViewById(R.id.obrazovanjeText);


       // updateQuestion();


        Dalje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioButtonId= Spolicc.getCheckedRadioButtonId();
                rb=(RadioButton)findViewById(radioButtonId);
                User users = new User(rb.getText().toString(),Dob.getText().toString(),Obraz.getText().toString());
                //String value = Dob.getText().toString();
                //korisnici.child("name").setValue(value);
                korisnici.push().setValue(users);
               Intent intent = new Intent(MainActivity.this,Main2Activity.class);
               startActivity(intent);

            }
        });


        }





   
}
