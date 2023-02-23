/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Rodrigo Miguel Kameyha
 */
public class GestorEstablecimientos {
   
    private List<Establecimiento> lista_Establecimientos = new ArrayList<>();
   // private ArrayList<Establecimiento> lista_Establecimientos = new ArrayList<>();
    private static GestorEstablecimientos gestor; //= null por defecto 
    
    public static final String MSJ_EST_OK = "Establecimiento Creado...";
    public static final String MSJ_EST_ERR = "Establecimiento NO Creado, datos invalidos ó el mismo ya esta cargado...";
    public static final String MSJ_EST_lis_OK = "\nEl Establecimiento SI esta en la lista...";
    public static final String MSJ_EST_lis_ERR = "\nEl Establecimiento NO esta en la Lista...";

    //constructor 
    public GestorEstablecimientos() {}
    
    //permite crear solo un gestor de establecimientos 
    public static GestorEstablecimientos crear() {
    if (gestor == null)
     gestor = new GestorEstablecimientos();
     return gestor;
    }
  
    /**Crea un establecimiento 
     * @param nombre
     * @param domicilio
     * @param codigo
     * @param tipo
     */
    public void crearEstalecimiento(String nombre, String domicilio, String codigo, TipoEstablecimiento tipo){
        if( (nombre==null) || (nombre.trim().isEmpty()) || (domicilio.trim().isEmpty()) || (codigo.trim().isEmpty()) || (codigo==null) || (domicilio==null) ){
            System.out.println(MSJ_EST_ERR);
        }
        else{
            Establecimiento establecimiento = new Establecimiento(nombre, domicilio, codigo, tipo);
            if(!lista_Establecimientos.contains(establecimiento)){
                lista_Establecimientos.add(establecimiento);
                System.out.println(MSJ_EST_OK);
            }
            else
                System.out.println(MSJ_EST_ERR);
            
        }
    }
 
    
    /**Muestra todos los establecimientos creados
     * @param criterio
     * @param tipoCmp   
     */
    public void mostrarEstablecimientos( CriterioDeOrdenamiento crit , TipoCmpMateria tipoCmp){

//con expresiones lambda
        Comparator<Establecimiento> cmp;
          if( tipoCmp == TipoCmpMateria.NOMBRE )
             cmp = (e1, e2) -> e1.getNombre().compareTo(e2.getNombre());
          else
             cmp = (e1, e2) ->  e1.getCodigo().compareTo(e2.getCodigo());

          Collections.sort(lista_Establecimientos, cmp); //ordena de A-Z 
         if( crit == CriterioDeOrdenamiento.DESCENDENTE)
              Collections.reverse(lista_Establecimientos); //invierte de Z-A 
//fin expresiones lambda 


//con referencia a metodos 
//        Comparator<Establecimiento> est;
//         if( tipoCmp == TipoCmpMateria.NOMBRE )
//             est = Establecimiento::compararNombre;
//          else
//             est = Establecimiento::compararCodigo;
// 
//       Collections.sort(lista_Establecimientos,est); //ordena de A-Z 
//          if( crit == CriterioDeOrdenamiento.DESCENDENTE)
//              Collections.reverse(lista_Establecimientos); //invierte de Z-A
//fin de referencia a metodos
          
          

       System.out.println("\n### Lista de Establecimientos creados...");
       if(!lista_Establecimientos.isEmpty()){  //controla que no este vacia la lista 
                for(Establecimiento e: lista_Establecimientos){
                      System.out.println("Nombre: " + e.getNombre() + "\tCodigo: "+e.getCodigo() );
                        e.mostrar();
                     }
       }else
            System.out.println( GestorOfertasAcademicas.MSJ_LISTA_VACIA);
    }
    
    
    
  /**busca un establecimiento por nombre
   * @return  un Array de los nombres q encontro
   * @param nombre
   */ 
    public ArrayList<Establecimiento> buscarPorNombre(String nombre){
        ArrayList<Establecimiento> lista_de_nombres = new ArrayList<>();
        
        for(Establecimiento e: lista_Establecimientos){
            if( e.getNombre().trim().equalsIgnoreCase(nombre.trim()) ){
                lista_de_nombres.add(e);
                
            }
        }
        if( !lista_de_nombres.isEmpty() ){ //controla que no este vacia la lista 
            System.out.println(MSJ_EST_lis_OK);
            return lista_de_nombres;
        }
        else{
            System.out.println(MSJ_EST_lis_ERR);
            return null;
        }
    }

    /**busca un establecimiento por codigo
   * @param codigo
     * @return algo del tipo establecimiento
   */ 
    public Establecimiento buscarPorCodigo( String codigo ){
        for(Establecimiento e: lista_Establecimientos){
            if( e.getCodigo().equals(codigo) ){
                System.out.println(MSJ_EST_lis_OK);
                return e; //devuelve el establecimiento q encontro
            } 
        }
        System.out.println(MSJ_EST_lis_ERR);
        return null;       // no esta el establecimiento 
    }
    
    
    
    /**Metodo para modificar un establecimiento
     */
    public void modificarEstab(Establecimiento es, String nombre, String domicilio ){
        if(es != null){

                        if((nombre!=null) || (nombre.trim().isEmpty()) ){
                            es.setNombre(nombre);
                            System.out.println("Nombre MODIFICADO...");
                        }
                        else{
                            System.out.println("Nombre invalido...");
                        }

                        if((domicilio !=null) || (domicilio.trim().isEmpty())){
                            es.setDomicilio(domicilio);
                            System.out.println("Domicilio Modificado...");
                            }
                        else {
                        System.out.println("Domicilio invalido");
                         }
        }else
            System.out.println("El Establecimiento no esta creado...");
        
        
    }
    
    
    /** Borrar un Establecimiento 
     */
    public void borrarEstab(Establecimiento est){
        if(!lista_Establecimientos.isEmpty()){
             
            if( est.getListaOferta().isEmpty() ){// controla q no tenga ofertas academicas 
               this.lista_Establecimientos.remove(est);//elimina el objeto de la lista 
               System.out.println("Establecimiento borrado... ");
             }else
               System.out.println("No se puede borrar...");
         
        }else
            System.out.println("La lista de Establecimientos esta vacia...");
   }

    public List<Establecimiento> getLista_Establecimientos() {
        return lista_Establecimientos;
    }

    public void setLista_Establecimientos(List<Establecimiento> lista_Establecimientos) {
        this.lista_Establecimientos = lista_Establecimientos;
    }
    
}

        
