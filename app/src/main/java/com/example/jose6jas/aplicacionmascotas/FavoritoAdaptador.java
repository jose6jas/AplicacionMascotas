package com.example.jose6jas.aplicacionmascotas;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jose6jas on 6/2/17.
 */

public class FavoritoAdaptador extends RecyclerView.Adapter<FavoritoAdaptador.FavoritoViewHolder>{

    ArrayList<Mascota> favoritos;

    public FavoritoAdaptador(ArrayList<Mascota> favoritos){
    this.favoritos = favoritos;
    }



    @Override
    public FavoritoViewHolder onCreateViewHolder(ViewGroup parent2, int viewType2) {
        View v2 = LayoutInflater.from(parent2.getContext()).inflate(R.layout.cardview_favoritos,parent2,false);
        return new FavoritoViewHolder(v2);

    }

    @Override
    public void onBindViewHolder(FavoritoViewHolder favoritoViewHolder, int position2) {
        final Mascota favorito = favoritos.get(position2);


        favoritoViewHolder.imgMascota2.setImageResource(favorito.getFoto());
        favoritoViewHolder.tv_nombre2.setText(favorito.getNombre());
        favoritoViewHolder.tv_count2.setText(String.valueOf(favorito.getCount()));

    }

    @Override
    public int getItemCount() {
        return favoritos.size();
    }

    public static class FavoritoViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgMascota2;
        private TextView tv_nombre2;
        private TextView tv_count2;
        private ImageButton btn_BoneLike2;

        public FavoritoViewHolder(View itemView2) {
            super(itemView2);
            imgMascota2    = (ImageView) itemView.findViewById(R.id.imgMascota2);
            tv_nombre2     = (TextView) itemView.findViewById(R.id.tv_nombre2);
            tv_count2      = (TextView) itemView.findViewById(R.id.tv_count2);
            btn_BoneLike2  = (ImageButton) itemView.findViewById(R.id.btn_BoneLike2);
        }
    }
}
