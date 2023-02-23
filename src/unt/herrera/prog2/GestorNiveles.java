/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import static unt.herrera.prog2.GestorOfertasAcademicas.MSJ_LISTA_VACIA;

/**
 *
 * @author Rodrigo Miguel Kameyha
 */
public class GestorNiveles {
    
    private Set<Nivel> lista_niveles = new HashSet<>(); // no se puede ordenar esta colleccion 
//    private ArrayList<Nivel> lista_niveles = new ArrayList<>();
    
    private static GestorNiveles gestor;  // = null  por defecto
    public static final String MSJ_NIVEL_OK = "El Nivel se Cargo...";
    public static final String MSJ_NIVEL_ERR = "El NO Nivel se Cargo, se enviaron datos vacios ó el Nivel ya esta en la lista";
    public static final String MSJ_NIVEL_OK_LISTA = "El Nivel SI esta en la lista...";
    public static final String MSJ_NIVEL_ERR_LISTA = "El Nivel NO esta en la lista...";
    private static final String ARCHIVO = "Niveles.bin";
   
//constructor 
    public GestorNiveles() {
     this.Deserealizar(); //leo el archivo 
    }
    
//permite crear solo un gestor de niveles 
    public static GestorNiveles crear() {
    if (gestor == null)
     gestor = new GestorNiveles();
     return gestor;
    }
    
//Crea objetos del tipo nivel y los guarda en una coleccion 
    public void crearNivel( String nombre ,String descripcion){
       if(  (nombre == null )|| (nombre.trim().isEmpty()) || (descripcion==null) || (descripcion.trim().isEmpty()) ){
           System.out.println(MSJ_NIVEL_ERR);
       }
       else {
        Nivel nivel = new Nivel(nombre, descripcion);
//        if(!lista_niveles.contains(nivel)){  // ya no haria falta al cambiar de coleccion  
           if(  lista_niveles.add(nivel)){      //HashSet no permite duplicados
               
               this.Serializar(); // serializo el objeto en el archivo,
                                 //en realidad se serializa la lista como llega hasta aqui
               
               System.out.println(MSJ_NIVEL_OK);
           } 
           else
               System.out.println(MSJ_NIVEL_ERR);
        }    
    }
 
    //muestra los nivles creados 
   public void mostrarNiveles(){
       
       System.out.println("### Lista de niveles creados...");
       if(!lista_niveles.isEmpty()){       //verifico q no este vacia la lista de niveles 
               for(Nivel n: lista_niveles){
                 n.mostrar();    //llama al metodo mostrar de nivel 
                }
       }else
           System.out.println(MSJ_LISTA_VACIA);
   }
   
   /** Busca un nivel por nombre y lo devuelve
    * si lo encuentra de lo contrario devuleve null
    @param nombre del nivel   */
   public Nivel buscarNivel(String nombre){
      boolean v = false;
      Nivel nivel= null;
      for(Nivel n: lista_niveles){
          if(n.getNombre().trim().equalsIgnoreCase(nombre.trim())){ // compara por nombre 
              v = true;
              nivel = n;
          }
      }
      if(v){
          System.out.println(MSJ_NIVEL_OK_LISTA);
          return nivel; // Nivel = Nivel
      }else{
          System.out.println(MSJ_NIVEL_ERR_LISTA);
          return nivel; // Nivel = null
      }     
  }
   /**Borra un nivel */
   public void borrarNivel(Nivel nivel , GestorEstablecimientos gestor,GestorPlanEstudio plan){
       boolean b= false;
       if(nivel!=null){

               for(PlanEstudio pla : plan.getListaPlan()){

                       OfertaAcademica oferta = new OfertaAcademica(nivel, pla );
                       for( Establecimiento est: gestor.getLista_Establecimientos() ){
                            if(est.getListaOferta().contains(oferta))
                                b=true;
                       }
               }
               if(b==false){
                   this.lista_niveles.remove(nivel);
                   this.Serializar();
               }else
                   System.out.println("No se puede borrar...");
       }else
           System.out.println("No se puede borrar, no existe...");
    }
   
   //persistencia con serializacion 
   
   /**cargar un archivo */
   public void Serializar(){
       File f= new File(ARCHIVO);
       try( ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f)) ){
 
          oos.writeObject(this.lista_niveles);
        
       }catch (FileNotFoundException fnte) {
            System.out.println("No existe el archivo... " + ARCHIVO);
        }
        catch (NotSerializableException nse) {
            System.out.println("La clase Tipo no es serializable...");
        }
        catch (IOException ioe) {
            System.out.println("Error al escribir en el archivo... " + ARCHIVO);
        }
   }
   
   /**leer archivo */
   public void Deserealizar(){
       File f = new File(ARCHIVO);
       
       if(f.exists()){
               try( ObjectInputStream ois = new ObjectInputStream( new FileInputStream(f))){
                  
                   this.lista_niveles = (HashSet<Nivel>)ois.readObject();
                   //asigno la lista que leo a la lista de niveles 
                   
               }catch (ClassNotFoundException cnfe) {
                 JOptionPane.showMessageDialog(null, "Error al leer del archivo " + ARCHIVO, "Nivel", JOptionPane.ERROR_MESSAGE);                                                        
               }
               catch (IOException ioe) {
                JOptionPane.showMessageDialog(null, "Error al leer del archivo " + ARCHIVO, "Nivel", JOptionPane.ERROR_MESSAGE);                                                        
               }
       }
   }


}
       
