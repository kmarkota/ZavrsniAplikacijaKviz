package com.example.junijepalmotic.zavrsniaplikacijakviz;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.junijepalmotic.zavrsniaplikacijakviz.Model.Odgovori;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SetAnswersActivity extends AppCompatActivity implements View.OnClickListener {

    Button daljeButton;
    CheckBox answer1,answer2,answer3,answer4,answer5;
    public String answerText;
    TextView pitanje,brPitanja;
    public Integer n=1, bodovi=0;



    FirebaseDatabase database;
    DatabaseReference pitanja,choice1,choice2,choice3,choice4,choice5,odgovori;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        answer1=findViewById(R.id.odgovor1);
        answer2=findViewById(R.id.odgovor2);
        answer3=findViewById(R.id.odgovor3);
        answer4=findViewById(R.id.odgovor4);
        answer5=findViewById(R.id.odgovor5);


        pitanje=findViewById(R.id.pitanje);
        daljeButton =findViewById(R.id.dalje);
        brPitanja=findViewById(R.id.brPitanja);


        database=FirebaseDatabase.getInstance();

        daljeButton.setEnabled(false);
        updateQuestion();
        onCheckBoxClick();



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
                answer1.setText(choice1);
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
               answer2.setText(choice2);
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
                answer3.setText(choice3);
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
                answer4.setText(choice4);
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
                answer5.setText(choice5);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    public void onCheckBoxClick(){
        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                odgovori=database.getReference("Odgovori").child("odgovori na pitanje "+n.toString());
                Odgovori answ= new Odgovori(answer1.getText().toString());

               bodovi=bodovi+2;

                answer2.setEnabled(false);
                answer3.setEnabled(false);
                answer4.setEnabled(false);
                answer5.setEnabled(false);
                daljeButton.setEnabled(true);
                if(!answer1.isChecked()) {
                    answer2.setEnabled(true);
                    answer3.setEnabled(true);
                    answer4.setEnabled(true);
                    answer5.setEnabled(true);
                    daljeButton.setEnabled(false);
                }

              answerText = answ.getOdgovori().toString();
            }
        });
        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                odgovori=database.getReference("Odgovori").child("odgovori na pitanje "+n.toString());
                Odgovori answ=new Odgovori((answer2.getText().toString()));
                answerText = answ.getOdgovori().toString();

                bodovi=bodovi+1;

                answer1.setEnabled(false);
                answer4.setEnabled(false);
                answer3.setEnabled(false);
                answer5.setEnabled(false);
                daljeButton.setEnabled(true);
                if(!answer2.isChecked()) {
                    answer1.setEnabled(true);
                    answer4.setEnabled(true);
                    answer3.setEnabled(true);
                    answer5.setEnabled(true);
                    daljeButton.setEnabled(false);
                }



            }
        });
        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                odgovori=database.getReference("Odgovori").child("odgovori na pitanje "+n.toString());
                Odgovori answ= new Odgovori(answer3.getText().toString());
                 answerText = answ.getOdgovori().toString();

                 bodovi=bodovi+0;
                answer1.setEnabled(false);
                answer2.setEnabled(false);
                answer4.setEnabled(false);
                answer5.setEnabled(false);
                daljeButton.setEnabled(true);
                if(!answer3.isChecked()) {
                    answer2.setEnabled(true);
                    answer1.setEnabled(true);
                    answer4.setEnabled(true);
                    answer5.setEnabled(true);
                    daljeButton.setEnabled(false);
                }


            }
        });
        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                odgovori=database.getReference("Odgovori").child("odgovori na pitanje "+n.toString());
                Odgovori answ= new Odgovori(answer4.getText().toString());
                answerText = answ.getOdgovori().toString();
                bodovi=bodovi-1;


                answer1.setEnabled(false);
                answer2.setEnabled(false);
                answer3.setEnabled(false);
                answer5.setEnabled(false);
                daljeButton.setEnabled(true);
                if(!answer4.isChecked()) {
                    answer2.setEnabled(true);
                    answer3.setEnabled(true);
                    answer1.setEnabled(true);
                    answer5.setEnabled(true);
                    daljeButton.setEnabled(false);
                }


            }
        });
        answer5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                odgovori=database.getReference("Odgovori").child("odgovori na pitanje "+n.toString());
                Odgovori answ= new Odgovori(answer5.getText().toString());
                answerText = answ.getOdgovori().toString();
                bodovi=bodovi-2;

                answer1.setEnabled(false);
                answer2.setEnabled(false);
                answer3.setEnabled(false);
                answer4.setEnabled(false);
                daljeButton.setEnabled(true);
                if(!answer5.isChecked()) {
                    answer2.setEnabled(true);
                    answer3.setEnabled(true);
                    answer4.setEnabled(true);
                    answer1.setEnabled(true);
                    daljeButton.setEnabled(false);
                }


            }
        });
        daljeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                n++;

                brPitanja.setText(n.toString());


                updateQuestion();
                odgovori.push().setValue(answerText);
                answer1.setEnabled(true);
                answer2.setEnabled(true);
                answer3.setEnabled(true);
                answer4.setEnabled(true);
                answer5.setEnabled(true);
                daljeButton.setEnabled(false);
                unCheck();


                if(n>15){
                    Intent intent = new Intent(SetAnswersActivity.this,ResultActivity.class);
                    intent.putExtra("ba",bodovi);
                    startActivity(intent);
                    odgovori.child(odgovori.getKey()).removeValue();
                    finish();
                }
            }
        });

    }

 void unCheck(){
        if(answer1.isChecked()){answer1.toggle();}
        if(answer2.isChecked()){answer2.toggle();}
        if(answer3.isChecked()){answer3.toggle();}
        if(answer4.isChecked()){answer4.toggle();}
        if(answer5.isChecked()){answer5.toggle();}
 }


    @Override
    public void onClick(View v) {

}}
