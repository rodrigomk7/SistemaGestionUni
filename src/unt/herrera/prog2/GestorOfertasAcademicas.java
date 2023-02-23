/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rodrigo Miguel Kameyha
 */
public class GestorOfertasAcademicas {
    private List<OfertaAcademica> lista_OfertasAcademicas = new ArrayList<>();
    //private ArrayList<OfertaAcademica> lista_OfertasAcademicas = new ArrayList<>();
   
    
    private static GestorOfertasAcademicas gestor;
    public static final String MSJ_OFERTA_OK = "Oferta Academica CREADA...";
    public static final String MSJ_OFERTA_ERR = "Oferta Academica NO CREADA, datos invalidos ó la oferta ya esta en la lista...";
    public static final String MSJ_LISTA_VACIA = "Lista vacia...";
    public static final String MSJ_LISTA = "\n#Lista de Ofertas Academicas creadas....\n";
    public static final String MSJ_Plan_LIST_OK= "La Oferta SI esta en la lista...\n";
    public static final String MSJ_Plan_LIST_ERR= "La Oferta NO esta en la lista...\n";

    //constructor
    public GestorOfertasAcademicas() { }
    
    // permitecrear  solo un GestorOfertasAcademicas
    public static GestorOfertasAcademicas crear(){
        if(gestor == null)
            gestor =new GestorOfertasAcademicas();
        return gestor;
    }
    /**Crea una oferta academica
     * @param Nivel
     * @param PlanEstudio
     */
    public void crearOfertaAcademica(Nivel nivel, PlanEstudio planEs){
       if( (nivel == null) || (planEs== null)){
           System.out.println(MSJ_OFERTA_ERR);
       }
       else{
           OfertaAcademica oferta = new OfertaAcademica(nivel, planEs);
                 if(!lista_OfertasAcademicas.contains(oferta)){
                    lista_OfertasAcademicas.add(oferta);
                    System.out.println(MSJ_OFERTA_OK);
                }else
                    System.out.println(MSJ_OFERTA_ERR);
            }
    }
    
    /**Muestra Ofertas Academicas que va creando */
    public void mostrarOfertasAcademicas(){
      
       if(!lista_OfertasAcademicas.isEmpty()){    // verifica que la lista  no este vacia
           System.out.println(MSJ_LISTA);
           for(OfertaAcademica o: lista_OfertasAcademicas)
           o.mostrar();
       }else
           System.out.println(MSJ_LISTA_VACIA);
   }
   
  /**Busca una oferta acdemica por nombre,si esta la retorna 
   * si no devuelve null
   * @param Nivel
   * @param PlanEstudio
   */ 
   public OfertaAcademica buscarOferta(Nivel nivel, PlanEstudio plan){
       OfertaAcademica oferta= null;
       for(OfertaAcademica o: lista_OfertasAcademicas){
           if( (o.getNivel().equals(nivel)) && (o.getPlanEs().equals(plan)) ){
               System.out.println("El Nivel y el  Plan estan en la lista !!!");
               oferta = o;
           }
       }
           if(oferta != null){
               System.out.println(MSJ_Plan_LIST_OK);
               return oferta;
           }else{
               System.out.println(MSJ_Plan_LIST_ERR);
               return oferta; // = null
           }
           
       }
   
   /**Modica una oferta academica 
    */
     public void modificarOferta(OfertaAcademica oferta,Nivel nivel, PlanEstudio plan){
         if( oferta != null){
             if( nivel != null)
                 oferta.setNivel(nivel);
             if( plan != null)
                 oferta.setPlanEs(plan);
         }
     }
     
     
     /**Borra una Oferta Academica 
      @param  OfertaAcademica*/
     //borrar una oferta cademica si esta no esta en ningun establecimiento 
     public void borrarOferta(OfertaAcademica oferta ){
      if(oferta != null){
          if( oferta.getListaEstOfer().isEmpty() )//pregunta si la oferta esta en algun establecimiento 
             this.lista_OfertasAcademicas.remove(oferta);
      }
     }

    public List<OfertaAcademica> getLista_OfertasAcademicas() {
        return lista_OfertasAcademicas;
    }

    public void setLista_OfertasAcademicas(List<OfertaAcademica> lista_OfertasAcademicas) {
        this.lista_OfertasAcademicas = lista_OfertasAcademicas;
    }
     
     
   
   }