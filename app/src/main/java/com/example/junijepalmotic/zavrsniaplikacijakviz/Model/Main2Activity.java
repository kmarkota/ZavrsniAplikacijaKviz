package com.example.junijepalmotic.zavrsniaplikacijakviz.Model;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;

        import com.example.junijepalmotic.zavrsniaplikacijakviz.R;

public class Main2Activity extends AppCompatActivity {

    Button odg1,odg2,odg3,odg4,odg5;
    TextView pitanje;
    Integer n=0;


    FirebaseDatabase database;
    DatabaseReference pitanja,choice1,choice2,choice3,choice4,choice5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        odg1 =(Button)findViewById(R.id.odgovor1);
        odg2 =(Button)findViewById(R.id.odgovor2);
        odg3 =(Button)findViewById(R.id.odgovor3);
        odg4 =(Button)findViewById(R.id.odgovor4);
        odg5 =(Button)findViewById(R.id.odgovor5);
        pitanje=(TextView)findViewById(R.id.pitanje);

        database=FirebaseDatabase.getInstance();


        updateQuestion();
        onButtonClick();

    }

    public void updateQuestion(){
        pitanja=database.getReference().child("Pitanja").child(n.toString()).child("question");

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
        choice1=database.getReference().child("Pitanja").child(n.toString()).child("choice1");

        choice1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String choice1=dataSnapshot.getValue(String.class);
                odg1.setText(choice1);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        choice2=database.getReference().child("Pitanja").child(n.toString()).child("choice2");

        choice2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String choice2=dataSnapshot.getValue(String.class);
                odg2.setText(choice2);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        choice3=database.getReference().child("Pitanja").child(n.toString()).child("choice3");

        choice3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String choice3 = dataSnapshot.getValue(String.class);
                odg3.setText(choice3);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        choice4=database.getReference().child("Pitanja").child(n.toString()).child("choice4");

        choice4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String choice4=dataSnapshot.getValue(String.class);
                odg4.setText(choice4);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        choice5=database.getReference().child("Pitanja").child(n.toString()).child("choice5");

        choice5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String choice5 =dataSnapshot.getValue(String.class);
                odg5.setText(choice5);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    public void onButtonClick(){
        odg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n++;
                updateQuestion();
            }
        });
        odg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n++;
                updateQuestion();
            }
        });
        odg3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n++;
                updateQuestion();
            }
        });
        odg4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n++;
                updateQuestion();
            }
        });
        odg5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n++;
                updateQuestion();
            }
        });
    }


}
