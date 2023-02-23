/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package unt.herrera.prog2;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Rodrigo Miguel Kameyha
 */
public class Nivel implements Serializable{
        private String nombre;    
        private String descripcion;

    public Nivel(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
public void mostrar(){
        System.out.println(this);
    }
    
    public String toString() {
    return "\n Nivel:"+ nombre +"\n Descripcion: "+descripcion;
      }  
    
/** Metodo para comparar si dos niveles son iguales 
 por nombre*/
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Nivel other = (Nivel) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }  
}