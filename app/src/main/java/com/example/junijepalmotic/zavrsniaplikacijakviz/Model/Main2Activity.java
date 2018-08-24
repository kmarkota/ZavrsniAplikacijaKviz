package com.example.junijepalmotic.zavrsniaplikacijakviz.Model;


import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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

    Button  dalje,nazad;
    CheckBox odg1,odg2,odg3,odg4,odg5;
   public String S;
    TextView pitanje,brPitanja;
   public Integer n=1,k=1;


    FirebaseDatabase database;
    DatabaseReference pitanja,choice1,choice2,choice3,choice4,choice5,odgovori;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        odg1=findViewById(R.id.odgovor1);
        odg2=findViewById(R.id.odgovor2);
        odg3=findViewById(R.id.odgovor3);
        odg4=findViewById(R.id.odgovor4);
        odg5=findViewById(R.id.odgovor5);

        pitanje=findViewById(R.id.pitanje);
        dalje=findViewById(R.id.dalje);
        nazad=findViewById(R.id.nazad);
        brPitanja=findViewById(R.id.brPitanja);

        database=FirebaseDatabase.getInstance();


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

    public void onCheckBoxClick(){
        odg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                odgovori=database.getReference("Odgovori").child("odgovori na pitanje "+n.toString());
                Odgovori odgovor= new Odgovori(odg1.getText().toString());

                odg2.setEnabled(false);
                odg3.setEnabled(false);
                odg4.setEnabled(false);
                odg5.setEnabled(false);
                if(!odg1.isChecked()){
                    odg2.setEnabled(true);
                    odg3.setEnabled(true);
                    odg4.setEnabled(true);
                    odg5.setEnabled(true);
                }

              S = odgovor.getOdgovori().toString();
            }
        });
        odg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                odgovori=database.getReference("Odgovori").child("odgovori na pitanje "+n.toString());
                Odgovori odgovor=new Odgovori((odg2.getText().toString()));
                S = odgovor.getOdgovori().toString();


                odg1.setEnabled(false);
                odg3.setEnabled(false);
                odg4.setEnabled(false);
                odg5.setEnabled(false);
                if(!odg2.isChecked()){
                    odg1.setEnabled(true);
                    odg3.setEnabled(true);
                    odg4.setEnabled(true);
                    odg5.setEnabled(true);
                }


            }
        });
        odg3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                odgovori=database.getReference("Odgovori").child("odgovori na pitanje "+n.toString());
                Odgovori odgovor= new Odgovori(odg3.getText().toString());
                 S = odgovor.getOdgovori().toString();
                odg1.setEnabled(false);
                odg2.setEnabled(false);
                odg4.setEnabled(false);
                odg5.setEnabled(false);
                if(!odg3.isChecked()){
                    odg2.setEnabled(true);
                    odg1.setEnabled(true);
                    odg4.setEnabled(true);
                    odg5.setEnabled(true);
                }

            }
        });
        odg4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                odgovori=database.getReference("Odgovori").child("odgovori na pitanje "+n.toString());
                Odgovori odgovor= new Odgovori(odg4.getText().toString());
                S = odgovor.getOdgovori().toString();
                odg1.setEnabled(false);
                odg2.setEnabled(false);
                odg3.setEnabled(false);
                odg5.setEnabled(false);
                if(!odg4.isChecked()){
                    odg2.setEnabled(true);
                    odg3.setEnabled(true);
                    odg1.setEnabled(true);
                    odg5.setEnabled(true);
                }

            }
        });
        odg5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                odgovori=database.getReference("Odgovori").child("odgovori na pitanje "+n.toString());
                Odgovori odgovor= new Odgovori(odg5.getText().toString());
                S = odgovor.getOdgovori().toString();
                odg1.setEnabled(false);
                odg2.setEnabled(false);
                odg3.setEnabled(false);
                odg4.setEnabled(false);
                if(!odg5.isChecked()){
                    odg2.setEnabled(true);
                    odg3.setEnabled(true);
                    odg4.setEnabled(true);
                    odg1.setEnabled(true);
                }

            }
        });
        dalje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                n++;
                brPitanja.setText(n.toString());
                if(odg1.isChecked() ||odg2.isChecked() || odg3.isChecked() || odg4.isChecked() || odg5.isChecked())
                {odgovori.push().setValue(S);
                 nazad.setEnabled(false);   }
                 else{nazad.setEnabled(true);}
                updateQuestion();

                odg1.setEnabled(true);
                odg2.setEnabled(true);
                odg3.setEnabled(true);
                odg4.setEnabled(true);
                odg5.setEnabled(true);
                unCheck();
            }
        });
        nazad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n--;
                if(n<1){n=1;}
                brPitanja.setText((n.toString()));
                updateQuestion();
            }
        });
    }

 void unCheck(){
        if(odg1.isChecked()){odg1.toggle();}
        if(odg2.isChecked()){odg2.toggle();}
        if(odg3.isChecked()){odg3.toggle();}
        if(odg4.isChecked()){odg4.toggle();}
        if(odg5.isChecked()){odg5.toggle();}
 }


}
