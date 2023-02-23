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
import java.util.List;

/**
 *
 * @author Rodrigo Miguel Kameyha
 */
public class GestorPlanEstudio {
    private List<PlanEstudio> listaPlan = new ArrayList<>();
    //private ArrayList<PlanEstudio> listaPlan = new ArrayList<>();
   
    private static GestorPlanEstudio gestor;  // = null  por defecto
   
    public static final String MSJ_OK_Plan = "Plan de Estudio CREADO";
    public static final String MSJ_Err_plan = "Plan de estudio NO creado, datos invalidos ó el plan ya se encuentra en la lista... ";
    public static final String MSJ_BUSQUEDA_OK = "Plan de estudio encontrado...";
    public static final String MSJ_BUSQUEDA_ERR = "Plan de estudio NO encontrado, no esta en la lista...";
    
    public GestorPlanEstudio() {
    }
 
   //permite crear solo un gestor de paln de estuido
    public static GestorPlanEstudio crear() {
    if (gestor == null)
     gestor = new GestorPlanEstudio();
     return gestor;
    }
    
    /** crear un plan de estudio 
     * @param nombre 
     * @param fechaInicio 
     * @param fechaFin 
     */
    public void crearPlanEstudio(String nombre, LocalDate fechaInicio, LocalDate fechaFin){
        if( (nombre.trim().isEmpty()) || (fechaInicio == null) || (fechaFin== null) || (fechaFin == fechaInicio) ){
            System.out.println(MSJ_Err_plan);
        }else{
            PlanEstudio plan = new PlanEstudio(nombre, fechaInicio , fechaFin);
            if(!listaPlan.contains(plan)){      //controla si no esta en la lista 
                listaPlan.add(plan);
                System.out.println(MSJ_OK_Plan);
            }else
                System.out.println(MSJ_Err_plan);
        }
    }
    /**Muestra todos los planes de estudio creados 
     @param CriterioDeOrdenamiento*/
    public void mostrarPlanesEstudio( CriterioDeOrdenamiento o){
        
         Collections.sort(listaPlan); //ordena A-Z 
         if(o == CriterioDeOrdenamiento.DESCENDENTE)
                      Collections.reverse(listaPlan); //invierte el orden (Z-A) 
         
        System.out.println("\n##Lista de planes de estudio creados...\n ");
        if(!listaPlan.isEmpty()){   //controla q no este vacio 
                for(PlanEstudio p: listaPlan)
                    p.mostrar();
        }else
            System.out.println(GestorOfertasAcademicas.MSJ_LISTA_VACIA);
    }
    
    /**Busca un plan de estudio por nombre en la lista ya cargada de planes de estudio
     * @param nombre 
    */
    public PlanEstudio buscarPlanEstudio( String nombre ){
          boolean v = false;
          PlanEstudio plan = null;
        
          for(PlanEstudio p: listaPlan){
            if(  p.getNombre().equals(nombre) ){ // si es true deberia entrar 
                v = true;     //plan encontrado 
                plan = p;
            }
        }
        
        if(v){
            System.out.println(MSJ_BUSQUEDA_OK);
            return plan; 
        }
        else{
            System.out.println(MSJ_BUSQUEDA_ERR);
            return plan; //devuelve null si nunca entra en el if del for  
        }
    }
    
    /**Muestra los planes de estudio que ya no están vigentes 
     * (fecha de finalización anterior a la fecha actual).
     * 
     @param CriterioDeOrdenamiento 
     */
    public void planesDeEstudioNoVigentes( CriterioDeOrdenamiento cri){

       boolean ban =false;
       String patron = "dd/MM/yyyy";
       
          Collections.sort(listaPlan);
        if(cri == CriterioDeOrdenamiento.DESCENDENTE)
           Collections.reverse(listaPlan); 
       
        System.out.println("\n\n### Lista de planes que ya NO estan Vigentes (  "+ LocalDate.now().format( DateTimeFormatter.ofPattern( patron )) +"  )");
       for(PlanEstudio p: listaPlan){
           if( 0 > p.getFechaHasta().compareTo(LocalDate.now())){ // filtra las fechas menores 
               p.mostrar();
               ban = true;
           }
               
       }
       if(ban==false)
            System.out.println("No existen  planes no vigentes");
    }
    
    
    /**Metodo para modificar un Plan de Estudio */
    public void modificarPlan( PlanEstudio plan, LocalDate fechaNueva ){
    if( (plan!=null)){
        
        if(fechaNueva!= null && !fechaNueva.equals(plan.getFechaDesde()) ){
            
            plan.setFechaHasta( fechaNueva ); 
            System.out.println("Fecha Modificada");
        }
        else
            System.out.println("Fecha invalida... no se puede modificar ");
      }
    }
    
    
    /** Metodo para borrar un plan de estudio
     */
    //borrar unicamente un plan de estudio si no continen nada de detalle de plan de estudio 
    //y ni de detalle de extraprogramatica
    public void borrarPlan(PlanEstudio plan ){
        if(plan != null){
        
         if( (!listaPlan.isEmpty()) && (plan.getListadetalle().isEmpty()) && (plan.getListaDetalleExtraProgramaticas().isEmpty()) ){
            listaPlan.remove(plan);
             System.out.println("Plan de estudio borrado...");
         }
         else
                System.out.println("No se pudo Borrar...");
        
        }
    }

    public List<PlanEstudio> getListaPlan() {
        return listaPlan;
    }

    public void setListaPlan(List<PlanEstudio> listaPlan) {
        this.listaPlan = listaPlan;
    }
    
}