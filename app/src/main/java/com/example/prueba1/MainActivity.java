package com.example.prueba1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            fun(50,30);
        }
        */
        Thread tp = new Thread() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        time time = new time();
                        time.execute();
                    }
                });
            }
        };
        tp.start();
    }
    String fun(int x , int y ){
        String suma = String.valueOf(x+y);
        return suma;
    }

    public void hilo()
    {
        try{
            Thread.sleep(1000);//1000 = 1 Seg.
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void ejecutar()
    {
        time time = new time();
        time.execute();
    }

    public class time extends AsyncTask<Void,Integer,Boolean>
    {
        @Override
        protected Boolean doInBackground(Void... voids) {
            for(int i=1; i <= 3; i++)
            {
                hilo();
            }
            return true;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            ejecutar();
            Toast.makeText(MainActivity.this,"Obteniendo Resultado...",Toast.LENGTH_SHORT).show();
            String suma = fun(50,30);
            Toast.makeText(MainActivity.this,"Sum: "+suma,Toast.LENGTH_SHORT).show();
        }
    }
}
