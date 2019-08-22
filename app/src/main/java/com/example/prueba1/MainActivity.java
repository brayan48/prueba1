package com.example.prueba1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            fun(50,30);
        }
    }
    void fun(int x , int y ){
        String suma = String.valueOf(x+y);
        Toast.makeText(MainActivity.this,"Sum: "+suma,Toast.LENGTH_LONG).show();
        final AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
        dialogo.setTitle("Resultado Suma");
        dialogo.setMessage("Sum "+suma);
        dialogo.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Prueba Finalizada!", Toast.LENGTH_LONG).show();
                dialog.cancel();
            }
        });
        dialogo.create();
        dialogo.show();
    }
}
