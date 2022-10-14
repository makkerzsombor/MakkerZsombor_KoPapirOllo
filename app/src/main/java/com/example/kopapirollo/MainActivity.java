package com.example.kopapirollo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView emberKep, gepKep;
    private Button btnKo, btnPapir, btnOllo;
    private TextView eredmeny;
    private Random rnd = new Random();
    private String gepKez;
    private int computerNy, emberNy;
    private AlertDialog.Builder jatekVegeAlertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btnKo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emberKep.setImageResource(R.drawable.rock);
                gepDobas();
                if (gepKez.equals("Ko")){
                    Toast.makeText(MainActivity.this, "Döntetlen", Toast.LENGTH_SHORT).show();
                    gepKep.setImageResource(R.drawable.rock);
                }else if (gepKez.equals("Papir")){
                    computerNy++;
                    Toast.makeText(MainActivity.this, "A gép nyert!", Toast.LENGTH_SHORT).show();
                    gepKep.setImageResource(R.drawable.paper);
                    eredmeny.setText("Eredmény: Ember: "+ emberNy +" Computer: "+ computerNy);
                }else{
                    emberNy++;
                    Toast.makeText(MainActivity.this, "Ön nyert", Toast.LENGTH_SHORT).show();
                    gepKep.setImageResource(R.drawable.scissors);
                    eredmeny.setText("Eredmény: Ember: "+ emberNy +" Computer: "+ computerNy);
                }
                jatekVege();
            }
        });
        btnPapir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emberKep.setImageResource(R.drawable.paper);
                gepDobas();
                if (gepKez.equals("Ko")){
                    emberNy++;
                    Toast.makeText(MainActivity.this, "Ön nyert!", Toast.LENGTH_SHORT).show();
                    eredmeny.setText("Eredmény: Ember: "+ emberNy +" Computer: "+ computerNy);
                    gepKep.setImageResource(R.drawable.rock);
                }else if (gepKez.equals("Papir")){
                    Toast.makeText(MainActivity.this, "Döntetlen", Toast.LENGTH_SHORT).show();
                    gepKep.setImageResource(R.drawable.paper);
                }else{
                    computerNy++;
                    Toast.makeText(MainActivity.this, "A gép nyert!", Toast.LENGTH_SHORT).show();
                    eredmeny.setText("Eredmény: Ember: "+ emberNy +" Computer: "+ computerNy);
                    gepKep.setImageResource(R.drawable.scissors);
                }
                jatekVege();
            }
        });
        btnOllo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emberKep.setImageResource(R.drawable.scissors);
                gepDobas();
                if (gepKez.equals("Ko")){
                    computerNy++;
                    gepKep.setImageResource(R.drawable.rock);
                    eredmeny.setText("Eredmény: Ember: "+ emberNy +" Computer: "+ computerNy);
                    Toast.makeText(MainActivity.this, "A gép nyert!", Toast.LENGTH_SHORT).show();
                }else if(gepKez.equals("Papir")){
                    emberNy++;
                    gepKep.setImageResource(R.drawable.paper);
                    eredmeny.setText("Eredmény: Ember: "+ emberNy +" Computer: "+ computerNy);
                    Toast.makeText(MainActivity.this, "Ön nyert!", Toast.LENGTH_SHORT).show();
                }else{
                    gepKep.setImageResource(R.drawable.scissors);
                    Toast.makeText(MainActivity.this, "Döntetlen", Toast.LENGTH_SHORT).show();
                }
                jatekVege();
            }
        });

    }
    private void init(){
        emberKep = findViewById(R.id.emberKep);
        gepKep = findViewById(R.id.gepKep);
        btnKo = findViewById(R.id.btnKo);
        btnPapir = findViewById(R.id.btnPapir);
        btnOllo = findViewById(R.id.btnOllo);
        eredmeny = findViewById(R.id.eredmeny);
        computerNy = 0;
        emberNy = 0;
        jatekVegeAlertDialog = new AlertDialog.Builder(this);
    }
    private void gepDobas(){
        int r = rnd.nextInt(3);
        if (r == 0){
            gepKez = "Ko";
        }else if (r == 1){
            gepKez = "Papir";
        }else{
            gepKez = "Ollo";
        }
    }
    private void jatekVege(){
        jatekVegeAlertDialog.setMessage("Szeretne új játékot játszani?");
        jatekVegeAlertDialog.setPositiveButton("Igen", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ujJatek();
            }
        });
        jatekVegeAlertDialog.setNegativeButton("Nem", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        if (emberNy == 3){
            jatekVegeAlertDialog.setTitle("Győzelem!");
            jatekVegeAlertDialog.create().show();
        }else if (computerNy == 3){
            jatekVegeAlertDialog.setTitle("Vereség!");
            jatekVegeAlertDialog.create().show();
        }
    }
    private void ujJatek(){
        computerNy = 0;
        emberNy = 0;
        emberKep.setImageResource(R.drawable.rock);
        gepKep.setImageResource(R.drawable.rock);
        eredmeny.setText("Eredmény: Ember: "+ emberNy +" Computer: "+ computerNy);
    }

}