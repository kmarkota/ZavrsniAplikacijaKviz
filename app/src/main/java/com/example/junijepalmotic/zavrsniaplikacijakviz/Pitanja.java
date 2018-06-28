package com.example.junijepalmotic.zavrsniaplikacijakviz;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Pitanja extends AppCompatActivity {

    RadioButton Musko,Zensko,rb;// za unos na firebase
    EditText Dob,Obraz;// za unso na firebase
    Button Dalje, UnesiPodatke;/// dalje za unos na firebase
    RadioGroup Spolicc;
    String Spolic;
    // za pitanja
    Button odg1,odg2,odg3,odg4,odg5;
    TextView pitanje;


    FirebaseDatabase database;
    DatabaseReference pitanja,choice1,choice2,choice3,choice4,choice5;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.potvrdi_layout);
      database=FirebaseDatabase.getInstance();

        odg1=(Button)findViewById(R.id.odgovor1);
        odg2=(Button)findViewById(R.id.odgovor2);
        odg3=(Button)findViewById(R.id.odgovor3);
        odg4=(Button)findViewById(R.id.odgovor4);
        odg5=(Button)findViewById(R.id.odgovor5);
        pitanje=(TextView)findViewById(R.id.pitanje);

        updateQuestion();
    }

   public void updateQuestion(){
        choice3=database.getReference().child("Pitanja").child("question");

        pitanja.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String question=dataSnapshot.getValue(String.class);
                pitanje.setText(question);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        choice3=database.getReference().child("Pitanja").child("choice1");

        choice1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String choice=dataSnapshot.getValue(String.class);
                odg1.setText(choice);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        choice3=database.getReference().child("Pitanja").child("choice2");
        choice2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String choice = dataSnapshot.getValue(String.class);
                odg2.setText(choice);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        choice3=database.getReference().child("Pitanja").child("choice3");
        choice3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String choice = dataSnapshot.getValue(String.class);
                odg3.setText(choice);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        choice3=database.getReference().child("Pitanja").child("choice4");
        choice4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String choice=dataSnapshot.getValue(String.class);
                odg4.setText(choice);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        choice3=database.getReference().child("Pitanja").child("choice5");
        choice5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String choice =dataSnapshot.getValue(String.class);
                odg5.setText(choice);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}

