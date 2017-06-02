package com.example.jose6jas.aplicacionmascotas;

import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by jose6jas on 5/31/17.
 */

public class Mascota implements  Comparable<Mascota>{
    private String nombre;
    private int foto;
    private int count;

    public Mascota(String nombre, int foto, int count){
        this.nombre = nombre;
        this.foto = foto;
        this.count = count;


    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


    @Override
    public int compareTo(Mascota o) {
        if (count < o.count) {
            return -1;
        }
        if (count > o.count) {
            return 1;
        }
        return 0;
    }

}
