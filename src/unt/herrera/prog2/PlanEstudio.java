/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/**
 *
 * @author Rodrigo Miguel Kameyha
 */
public class PlanEstudio implements Comparable<PlanEstudio>{

    private String nombre;
    private LocalDate fechaDesde;
    private LocalDate fechaHasta;
    
    ArrayList<DetallePlanEstudio> listadetalle = new ArrayList<DetallePlanEstudio>();
    private ArrayList<DetalleExtraProgramaticas> listaDetalleExtraProgramaticas = new ArrayList<DetalleExtraProgramaticas>();

    public PlanEstudio(String nombre, LocalDate fechaDesde, LocalDate fechaHasta) {
        this.nombre = nombre;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<DetallePlanEstudio> getListadetalle() {
        return listadetalle;
    }

    public void setListadetalle(ArrayList<DetallePlanEstudio> listadetalle) {
        this.listadetalle = listadetalle;
    }
     public ArrayList<DetalleExtraProgramaticas> getListaDetalleExtraProgramaticas() {
        return listaDetalleExtraProgramaticas;
    }

    public void setListaDetalleExtraProgramaticas(ArrayList<DetalleExtraProgramaticas> listaDetalleExtraProgramaticas) {
        this.listaDetalleExtraProgramaticas = listaDetalleExtraProgramaticas;
    }
    public LocalDate getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(LocalDate fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public LocalDate getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(LocalDate fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    /**
     * Metodo para agregar materias y hora a un plan de estudio
     *
     * @param materia
     * @param horas
     */
    public void agregarMateria(Obligatoria materia, int horas) {
        if(materia != null){
        DetallePlanEstudio plan = new DetallePlanEstudio(materia, horas);

        if (!listadetalle.contains(plan)) {
            listadetalle.add(plan);
        }
      }
    }

    /**
     * Metodo para agregar materias ExtraProgramaticas
     */
    public void agregarMateria(ExtraProgramatica materia, int horas, float arancel) {
        if(materia != null){
            DetalleExtraProgramaticas plan = new DetalleExtraProgramaticas(materia, horas, arancel);
            if (!listaDetalleExtraProgramaticas.contains(plan)) {
               listaDetalleExtraProgramaticas.add(plan);
         }
        }
    }

    /**
     * Metodo para mostrar planes de estudio
     */
    public void mostrar() { 
         
       System.out.println(this);// llama al toString 
      
       System.out.println("-Materias Obligatorias:"); 
       if(!listadetalle.isEmpty()){ //verifica q la lista no este vacia
                Collections.sort(listadetalle); //ordena A-Z 
                System.out.println("Materia\t\tHoras");
                System.out.println("------------------------");
                for (DetallePlanEstudio r : listadetalle)
                    r.mostrar();  
            }else
                System.out.println(GestorOfertasAcademicas.MSJ_LISTA_VACIA);
       

       System.out.println("\n-Materias ExtraProgramticas:");
           if(!listaDetalleExtraProgramaticas.isEmpty()){  //verifica q la lista no este vacia
                Collections.sort(listaDetalleExtraProgramaticas); //ordena A-Z
                System.out.println("Materia\t\tHoras\t\tArancel");
                System.out.println("--------------------------------------------");
                for (DetalleExtraProgramaticas detalle : listaDetalleExtraProgramaticas)
                    detalle.mostrar();
           }else
                System.out.println(GestorOfertasAcademicas.MSJ_LISTA_VACIA);
    }

    public String toString() {
        String patron = "dd/MM/yyyy";
        return "\nPlanEstudio: " + nombre + "\n Fecha Inicio: " + fechaDesde.format( DateTimeFormatter.ofPattern( patron )) + "    Fecha Hasta: " + fechaHasta.format( DateTimeFormatter.ofPattern( patron ));                     
    }

    /**
     * Metodo para comparar si dos planes de estudio son iguales por nombre
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.nombre);
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
        final PlanEstudio other = (PlanEstudio) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(PlanEstudio o) {
        int ban = this.fechaDesde.compareTo(o.fechaDesde);
        
        if(ban == 0){
            return this.nombre.compareTo(o.nombre);
        }else
            return ban;
    }

    /**Modificar una materia obligatoria 
     */
    public void modificarMatOB( Obligatoria oblig,int horasNueva ){
       
        int pos = this.listadetalle.indexOf(new DetallePlanEstudio(oblig, 0 )); 
        this.listadetalle.get( pos).setHoras(horasNueva);
        
       
    }
 
    /**Modificar una materia ExtraProgramatica 
     @param  horas
     @param arancel*/
    public void modificarMatEX( ExtraProgramatica extra,int horasNew, float arancelNew ){
     
        int pos = this.listaDetalleExtraProgramaticas.indexOf(new DetalleExtraProgramaticas(extra, 0,0 )); 
        this.listaDetalleExtraProgramaticas.get( pos).setHoras(horasNew);
        this.listaDetalleExtraProgramaticas.get( pos).setArancel(arancelNew); 
    }
  
     /**Modificar una materia ExtraProgramatica 
     @param  horasNew 
    */
    public void modificarMatEX( ExtraProgramatica extra,int horasNew){
     
        if(extra!=null){
        
            int pos = this.listaDetalleExtraProgramaticas.indexOf(new DetalleExtraProgramaticas(extra, 0,0 )); 
            this.listaDetalleExtraProgramaticas.get( pos).setHoras(horasNew);
         }
    }

    
    /**borra un detalle de obligatoria */
     public void borrarDetMatOB( Obligatoria oblig){
     
        this.listaDetalleExtraProgramaticas.remove(new DetallePlanEstudio(oblig, 0)); 
    }
    
    /**borra un detalle de extraprogramatica */
     public void borrarDetMatEX( ExtraProgramatica extra){
     
        this.listaDetalleExtraProgramaticas.remove(new DetalleExtraProgramaticas(extra, 0,0 )); 
    }
}






