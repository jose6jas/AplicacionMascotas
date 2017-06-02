package com.example.jose6jas.aplicacionmascotas;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by jose6jas on 5/31/17.
 */

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{


    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas,Activity activity){

        this.mascotas = mascotas;
        this.activity = activity;

    }

     // aqui declaro la lista que viene de la clase Mascota
    // Infla el layout
    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {
//Aqui seteamos cada uno de la lista a el reciclerview
        final Mascota mascota = mascotas.get(position);

        mascotaViewHolder.imgMascota.setImageResource(mascota.getFoto());
        mascotaViewHolder.tv_nombre.setText(mascota.getNombre());
        mascotaViewHolder.tv_count.setText(String.valueOf(mascota.getCount()));
        mascotaViewHolder.btn_BoneLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(activity, "Diste BoneLike a " + mascota.getNombre(),Toast.LENGTH_SHORT).show();
                int count=mascota.getCount();
                count = count +1;
                mascota.setCount(count);
                //Volvemos a cargar los count
                mascotaViewHolder.tv_count.setText(String.valueOf(mascota.getCount()));
            }

        });

    }

    @Override
    public int getItemCount() { // cantidad de elementos que contiene la lista

        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgMascota;
        private TextView tv_nombre;
        private TextView tv_count;
        private ImageButton btn_BoneLike;


        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgMascota    = (ImageView) itemView.findViewById(R.id.imgMascota);
            tv_nombre     = (TextView) itemView.findViewById(R.id.tv_nombre);
            tv_count      = (TextView) itemView.findViewById(R.id.tv_count);
            btn_BoneLike  = (ImageButton) itemView.findViewById(R.id.btn_BoneLike);
        }
    }
}
