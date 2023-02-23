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
public class DetalleExtraProgramaticas implements Comparable<DetalleExtraProgramaticas>{
    private ExtraProgramatica extraProgramatica;
   
    private  int horas;
    private float arancel;

    public DetalleExtraProgramaticas(ExtraProgramatica extraProgramatica,int horas,float arancel) {
        this.extraProgramatica = extraProgramatica;
        this.horas=horas;
        this.arancel=arancel;
    }

    public ExtraProgramatica getExtraProgramatica() {
        return extraProgramatica;
    }

    public void setExtraProgramatica(ExtraProgramatica extraProgramatica) {
        this.extraProgramatica = extraProgramatica;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public float getArancel() {
        return arancel;
    }

    public void setArancel(float arancel) {
        this.arancel = arancel;
    }
/**muestra Horas y Arancel*/
    public void mostrar(){
        
        System.out.println(this);
    }
    
     public String toString() {
    return  getExtraProgramatica() +"\t\t"+horas+"\t\t"+arancel;
      }
    
 /**metodo para saber si dos materias extra son iguales por el nombre *
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.extraProgramatica);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DetalleExtraProgramaticas other = (DetalleExtraProgramaticas) obj;
        if (!Objects.equals(this.extraProgramatica, other.extraProgramatica)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(DetalleExtraProgramaticas o) {
               // return this.getExtraProgramatica().getNombre().compareTo(o.getExtraProgramatica().getNombre());
               return this.extraProgramatica.compareTo(o.getExtraProgramatica()); 
               //llama al metodo compareto() de materia 
    }

     
}
