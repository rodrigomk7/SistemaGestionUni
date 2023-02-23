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
public class DetallePlanEstudio  implements Comparable<DetallePlanEstudio>{
    private int horas = 0;
    private Obligatoria matPlanEstudio;   

    public DetallePlanEstudio(Obligatoria matPlanEstudio, int horas){
        this.matPlanEstudio = matPlanEstudio;
        this.horas=horas;
    }
    
    
    public Materia getMatPlanEstudio() {
        return matPlanEstudio;
    }

    public void setMatPlanEstudio(Obligatoria matPlanEstudio) {
        this.matPlanEstudio = matPlanEstudio;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }
    
 /**Metodo para mostrar detallles de plan de estudio*/ 
    public void mostrar(){
        System.out.println(this);
    }
     public String toString() {
    return  matPlanEstudio +"\t\t"+horas;
      }
 /**Metodo para comparar si dos detalles de plan de estudio 
  * son iguales por materias  */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.matPlanEstudio);
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
        final DetallePlanEstudio other = (DetallePlanEstudio) obj;
        if (!Objects.equals(this.matPlanEstudio, other.matPlanEstudio)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(DetallePlanEstudio o) {
          //return this.getMatPlanEstudio().getNombre().compareTo(o.getMatPlanEstudio().getNombre());
          
        return this.matPlanEstudio.compareTo(o.getMatPlanEstudio());
               //llama al metodo compareto() de materia 
    }

     
    
}
