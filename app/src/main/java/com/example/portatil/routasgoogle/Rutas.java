package com.example.portatil.routasgoogle;

import android.app.FragmentTransaction;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class Rutas extends AppCompatActivity implements cambiInformacio{

    //Comencem per fer unes variables que ens serviran per inflar els fragments y que es mostrin en la nostra app
    //en el main activiti
    PeticioRutas peticio;//primer fragment que mostrem per demanar coses al usuari i pasar al seguent<mostrarrutas>
    MostrarRutas mapa;//fragment que mostrarem si tot es correcta en el primer fragment <peticioruta>
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rutas);
        //si tot ess correcte mostrarem el nostre fragment <peticiorutas>
        if (savedInstanceState == null) {
            peticio = new PeticioRutas ();
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.add(R.id.c1, peticio);
            transaction.commit();
            //per deixar bonic el toolbar o posarem aixi
            getSupportActionBar().setTitle("Peticio de rutas");
        }


    }

    //metode de la interficie que utilitzem per poder establir comunicacio entre els fragments
    //en el cas del mapa rebirem uns paramatres per tal d'inicar un mapa amb la ruta que volem
    //en el meu cas i degut a dificultat tecniques simplement pasem valors que serian els demanats
    //per crear la ruta al seguent fragment y els mostrem
    @Override
    public void calculRuta(String a ,String b) {

        Bundle bundle = new Bundle();
        bundle.putString("origen", b);
        bundle.putString("desti", a);


        mapa= new MostrarRutas();
        mapa.setArguments(bundle);
        //Se hace el cambio de Fragment entre el Main y el Map empleando FragmentTransaction
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.c1, mapa);
        transaction.commit();
        getSupportActionBar().setTitle("Mostrar ruta");

    }
}
