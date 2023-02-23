/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package unt.herrera.prog2;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Rodrigo Miguel Kameyha
 */
public class OfertaAcademica {
    private Nivel nivel;
    private PlanEstudio planEs;
    private ArrayList<Establecimiento> listaEstOfer= new ArrayList<Establecimiento>();

    
    public OfertaAcademica(Nivel nivel, PlanEstudio planEs) {
        this.nivel = nivel;
        this.planEs = planEs;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public PlanEstudio getPlanEs() {
        return planEs;
    }

    public void setPlanEs(PlanEstudio planEs) {
        this.planEs = planEs;
    }

    public ArrayList<Establecimiento> getListaEstOfer() {
        return listaEstOfer;
    }

    public void setListaEstOfer(ArrayList<Establecimiento> listaEstOfer) {
        this.listaEstOfer = listaEstOfer;
    }
    
   /** Agrega un Establecimiento a una lista de ofertas Academicas */ 
    public void agregarEstablecimiento(Establecimiento es){
       if(es != null){
       if( !listaEstOfer.contains(es) ){
           this.listaEstOfer.add(es);
           es.agregarOferta(this);
            }
      }
    }
    
    
    
    /**Muestra una oferta academica */
      public void mostrar(){
        System.out.println(this);
      }
      
     public String toString() {
     return "\tNivel: "+nivel.getNombre() +"\t Plan de Estudio: " +planEs.getNombre();
      }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.nivel);
        hash = 53 * hash + Objects.hashCode(this.planEs);
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
        final OfertaAcademica other = (OfertaAcademica) obj;
        if (!Objects.equals(this.nivel, other.nivel)) {
            return false;
        }
        if (!Objects.equals(this.planEs, other.planEs)) {
            return false;
        }
        return true;
    }
    /**Metodo para comparar si dos ofertas academicas son iguales
     por nivel y plan */
     
     
     
     
     /**muestra lista con los establecimientos q tienen 
      una misma oferta academica*/
     public void mostrar_lista(){
         System.out.println("\n Oferta Academica:");
         mostrar();
          for(Establecimiento es: listaEstOfer)  
              System.out.println("Establecimiento: " +es.getNombre());
          
          
  
    }
     
}
