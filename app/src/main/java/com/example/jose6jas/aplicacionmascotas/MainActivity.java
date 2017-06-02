package com.example.jose6jas.aplicacionmascotas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;

    private RecyclerView listaMascotas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        listaMascotas = (RecyclerView)findViewById(R.id.rvMascotas);
        //Aqui marcamos como nos va a funcionar
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();

    }
    public MascotaAdaptador adaptador;
    public void inicializarAdaptador(){

        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,this);

        listaMascotas.setAdapter(adaptador);

    }

    public void inicializarListaMascotas(){

        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Penelope",R.drawable.mascota1,0));
        mascotas.add(new Mascota("Princesa",R.drawable.mascota2,0));
        mascotas.add(new Mascota("Catumpi",R.drawable.mascota3,0));
        mascotas.add(new Mascota("Lucky",R.drawable.mascota4,0));
        mascotas.add(new Mascota("Firulais",R.drawable.mascota5,0));
        mascotas.add(new Mascota("Ice",R.drawable.mascota6,0));

    }

    @Override
//aqui agregamos el menu a la vista
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.mAbout:
                Intent about = new Intent(this,About.class);
                startActivity(about);
                break;
            case R.id.mSettings:
                Intent settings = new Intent(this,Settings.class);
                startActivity(settings);
                break;
            case R.id.mFavorite:

                class likeComparator implements Comparator<Mascota> {
                    @Override
                    public int compare(Mascota a, Mascota b) {
                        return a.getCount() > b.getCount() ? -1 : a.getCount() == b.getCount() ? 0 : 1;
                    }
                }
                Collections.sort(mascotas, new likeComparator());
                // Log.i("Mesage",mascotas.get(0).getNombre()+mascotas.get(0).getCount());
                // Log.i("Mesage",mascotas.get(1).getNombre()+mascotas.get(1).getCount());
                // Log.i("Mesage",mascotas.get(2).getNombre()+mascotas.get(2).getCount());
                // Log.i("Mesage",mascotas.get(3).getNombre()+mascotas.get(3).getCount());
                // Log.i("Mesage",mascotas.get(4).getNombre()+mascotas.get(4).getCount());


                Intent favorite = new Intent(this, Favorite.class);
                //Esto se debe mejorar aqui paso los 5 favoritos
                favorite.putExtra("nombre1", mascotas.get(0).getNombre());
                favorite.putExtra("foto1", mascotas.get(0).getFoto());
                favorite.putExtra("count1", mascotas.get(0).getCount());

                favorite.putExtra("nombre2", mascotas.get(1).getNombre());
                favorite.putExtra("foto2", mascotas.get(1).getFoto());
                favorite.putExtra("count2", mascotas.get(1).getCount());

                favorite.putExtra("nombre3", mascotas.get(2).getNombre());
                favorite.putExtra("foto3", mascotas.get(2).getFoto());
                favorite.putExtra("count3", mascotas.get(2).getCount());

                favorite.putExtra("nombre4", mascotas.get(3).getNombre());
                favorite.putExtra("foto4", mascotas.get(3).getFoto());
                favorite.putExtra("count4", mascotas.get(3).getCount());

                favorite.putExtra("nombre5", mascotas.get(4).getNombre());
                favorite.putExtra("foto5", mascotas.get(4).getFoto());
                favorite.putExtra("count5", mascotas.get(4).getCount());



                startActivity(favorite);
                break;


        }
        return true;
    }
}
