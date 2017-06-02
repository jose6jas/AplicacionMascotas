package com.example.jose6jas.aplicacionmascotas;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class Favorite extends AppCompatActivity {
    private RecyclerView listaFavoritos;
    ArrayList<Mascota> favoritos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        listaFavoritos = (RecyclerView)findViewById(R.id.rvFavoritos);

        LinearLayoutManager llm2 = new LinearLayoutManager(this);
        llm2.setOrientation(LinearLayoutManager.VERTICAL);
        listaFavoritos.setLayoutManager(llm2);
        inicializarListaFavoritos();
        inicializarAdaptador2();



    }
    public void inicializarAdaptador2(){
        FavoritoAdaptador adaptador2 = new FavoritoAdaptador(favoritos);
        listaFavoritos.setAdapter(adaptador2);
    }

    public void inicializarListaFavoritos() {
        favoritos= new ArrayList<Mascota>();
        favoritos.add(new Mascota(getIntent().getExtras().getString("nombre1"), getIntent().getExtras().getInt("foto1"), getIntent().getExtras().getInt("count1")));
        favoritos.add(new Mascota(getIntent().getExtras().getString("nombre2"), getIntent().getExtras().getInt("foto2"), getIntent().getExtras().getInt("count2")));
        favoritos.add(new Mascota(getIntent().getExtras().getString("nombre3"), getIntent().getExtras().getInt("foto3"), getIntent().getExtras().getInt("count3")));
        favoritos.add(new Mascota(getIntent().getExtras().getString("nombre4"), getIntent().getExtras().getInt("foto4"), getIntent().getExtras().getInt("count4")));
        favoritos.add(new Mascota(getIntent().getExtras().getString("nombre5"), getIntent().getExtras().getInt("foto5"), getIntent().getExtras().getInt("count5")));

    }
}
