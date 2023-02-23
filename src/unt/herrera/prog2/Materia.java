/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package unt.herrera.prog2;

import java.util.Objects;

/**
 *
 * @author Rodrigo Miguel Kameyha
 */
public abstract class Materia implements Comparable<Materia>{
   private String nombre;
   private String codigo;


    public Materia(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
  /** metodo para mostrar materia */  
    public void mostrar(){
        System.out.println(this);
    }
    
    public String toString() {
    return  nombre ;
    }
    
/** Metodo para comparar si dos materias son iguales 
 por codigo*/
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.codigo);
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
        if ( getClass().getSuperclass() != obj.getClass().getSuperclass() ) {
            return false;
        }
        final Materia other = (Materia) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }
    
    
    public abstract String tipoMateria();  //metodo abstracto 

    
    @Override
    public int compareTo(Materia o) {
       return this.nombre.compareTo(o.nombre);
    }

   
    

}