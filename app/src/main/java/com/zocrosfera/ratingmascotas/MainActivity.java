package com.zocrosfera.ratingmascotas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(toolbar);

        listaContactos = (RecyclerView)findViewById(R.id.rvContactos);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaContactos.setLayoutManager(llm);
        inicializarListaContatos();
        inicializarAdaptador();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_favorito) {
            irAlFavoritosActivity();
            return true;
        }
        else
            // If we got here, the user's action was not recognized.
            // Invoke the superclass to handle it.
            return super.onOptionsItemSelected(item);

    }

    public void irAlFavoritosActivity(){
        Intent intent = new Intent(this, MascotasFavoritos.class);
        startActivity(intent);
    }

    public void inicializarAdaptador(){
        MascotasAdaptador adaptador = new MascotasAdaptador(mascotas, this);
        listaContactos.setAdapter(adaptador);
    }

    public void inicializarListaContatos(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Zion", "3", R.drawable.dog));
        mascotas.add(new Mascota("Zorrito", "5", R.drawable.foxy));
        mascotas.add(new Mascota("Brown", "4", R.drawable.lion));
        mascotas.add(new Mascota("NinjaX", "2", R.drawable.panda));
        mascotas.add(new Mascota("Pisquila", "5", R.drawable.tucano));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.favoritos, menu);
        return true;
    }
}
