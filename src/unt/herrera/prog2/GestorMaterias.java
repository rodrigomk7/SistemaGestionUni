/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import static unt.herrera.prog2.GestorOfertasAcademicas.MSJ_LISTA_VACIA;

/**
 *
 * @author Rodrigo Miguel Kameyha 
 */
public class GestorMaterias {
    
    private List<Materia> listaMaterias = new ArrayList<>();
//  private ArrayList<Materia> listaMaterias = new ArrayList<>();
   
    private static GestorMaterias gestor; //null por defecto   
    public static  final String MSJ_MAT_ESTA_EN_LISTA = "La materia esta en la lista... \n";
    public static  final String MSJ_MAT_NO_ESTA_EN_LISTA = "La materia NO esta en la lista...\n ";
    public static final String MSJ_MATERIA_OK = "Materia Creada";
    public static final String MSJ_MATERIA_Error = "Materia No se pudo Crear, ya esta en la lista o se enviaron datos vacios";

    public static final String ARCH_MAT = "Materias.txt";

    private static final String SEPARADOR = "/";
     
//constructor 
    public GestorMaterias() { 
    
        this.leerArchivoMAT();
    
    }

    //crea solo un gestor de materia 
    public static GestorMaterias crear() {
    if (gestor == null)
     gestor = new GestorMaterias();
     return gestor;
    }
     public List<Materia> getListaMaterias() {
        return listaMaterias;
    }

    public void setListaMaterias(List<Materia> listaMaterias) {
        this.listaMaterias = listaMaterias;
    }
    /**Crea una materia obligatoria 
     @param  nombre 
     @param  codigo */
    public void crearMatObli(String nombre, String codigo){
        if( ( (nombre == null) || nombre.trim().isEmpty()) || (codigo== null) ||(codigo.trim().isEmpty()) ){ // control de elementos 
            System.out.println(MSJ_MATERIA_Error);
        }
        else{
            Materia obligatoria = new Obligatoria(nombre, codigo);
            if(!listaMaterias.contains(obligatoria)){  // controla que la materia no este en la lista x codigo
                listaMaterias.add(obligatoria);          
                System.out.println(MSJ_MATERIA_OK); 
            }else {
                System.out.println( MSJ_MATERIA_Error); 
            }
        }
    }
    /** Crea un materia extraprogramatica 
     @param  nombre
     @param  codigo */
    public void crearMatExtra(String nombre, String codigo){
        if((nombre==null) || (nombre.trim().isEmpty()) || (codigo==null) || (codigo.trim().isEmpty()) ){
            System.out.println(MSJ_MATERIA_Error);
        }
        else{
            Materia extra = new ExtraProgramatica(nombre, codigo); 
            if(!listaMaterias.contains(extra)){        //x codigo
                listaMaterias.add(extra);
                System.out.println(MSJ_MATERIA_OK);            
            }else 
                System.out.println(MSJ_MATERIA_Error);
            } 
    }
    
    
    /**Muestra  todas las Materias creadas
     @param  CriterioDeOrdenamiento */ 
    public void mostrarMaterias( CriterioDeOrdenamiento o){
          
//        ArrayList<Materia> listaMAT = leerArchivoMAT();//leo el archivo 
       
     if( !listaMaterias.isEmpty()){
    
         Collections.sort(listaMaterias); //ordena A-Z
        if(o == CriterioDeOrdenamiento.DESCENDENTE)
         Collections.reverse(listaMaterias); // invierte Z-A
        
     System.out.println("\n###Lista de Materias Creadas...\n");
        if(!listaMaterias.isEmpty()){    //controla que la lista no este vacia 
            for(Materia m: listaMaterias){
                System.out.println(m.getNombre()+" -> "+m.tipoMateria());
              }
        }else
            System.out.println(MSJ_LISTA_VACIA);
        }
    }
    
    /**Muestra solo materia obligatorias creadas 
     @param  CriterioDeOrdenamiento*/    
    public void mostrarObligatorias( CriterioDeOrdenamiento o){
        boolean b = false;
//        ArrayList<Materia> listaM = leerArchivoMAT();
 
        Collections.sort(listaMaterias);  //ordena A-Z
        if(o == CriterioDeOrdenamiento.DESCENDENTE)
                Collections.reverse(listaMaterias); //invierte el orden de ordemamiento (Z-A)
        
        System.out.println("Lista de Materias Obligatorias Creadas: ");
        if(!listaMaterias.isEmpty()){
            for(Materia m: listaMaterias){
                 if(m instanceof Obligatoria){
                 m.mostrar();
                 b = true;
                }
            }
            if(b ==false){ 
                 System.out.println(MSJ_LISTA_VACIA);
             }
        }else
            System.out.println(MSJ_LISTA_VACIA);
      
        }
    
    
    /**Muestra solo las materias obligatorias creadas 
     @param CrideterioDeOrdenamiento */
     public void mostrarExtraProgramaticas(CriterioDeOrdenamiento o){
         boolean b = false;  
//         ArrayList<Materia> listaM = leerArchivoMAT();
         
         Collections.sort(listaMaterias); //ordena A-Z
         if(o == CriterioDeOrdenamiento.DESCENDENTE)
                    Collections.reverse(listaMaterias); // invierte el orden (Z-A)
        
        System.out.println("Lista de Materias ExtraProgramaticas Creadas: ");
       
        if(!listaMaterias.isEmpty()){      // controla que la lista no este vacia 
            for(Materia m: listaMaterias){
                 if(m instanceof ExtraProgramatica){
                 m.mostrar();
                 b = true;    //Si hay materias ExtraProgramatica
                }
            }
            if(b ==false){
                 System.out.println(MSJ_LISTA_VACIA);
             }
       }else
            System.out.println(MSJ_LISTA_VACIA);
    }
     
     /**Busca materia por nombre y la devuelve 
      * null si no esta 
      * @param  nombre */
     public Materia buscarMatPorNombre(String nombre){
          boolean v = false;
          
//          ArrayList<Materia> listaM = leerArchivoMAT();
          
          Materia materia = null;
          for(Materia m: listaMaterias){
             if(m.getNombre().equalsIgnoreCase(nombre)){
                 v= true;    // materia encontrada 
                 materia = m;
             }
         }
         if( v ){
             System.out.println(MSJ_MAT_ESTA_EN_LISTA);
             return materia; //Materia = Materia
         }else{
             System.out.println(MSJ_MAT_NO_ESTA_EN_LISTA);
             return materia; // Materia = null 
         }
     }
     
      /**Busca materia Obligatoria por nombre y la devuelve 
      * null si no esta 
      * @param  nombre */
      public Obligatoria buscarMatPorNombreOBLIG(String nombre){
          boolean v = false;
          
//          ArrayList<Materia> listaM = leerArchivoMAT();
          
          Obligatoria obligatoria = null;
          for(Materia m: listaMaterias ){
               if(m  instanceof Obligatoria){
                        if(m.getNombre().equalsIgnoreCase(nombre)){
                        v= true;  //materia encontrada 
                        obligatoria = (Obligatoria) m;
                        }
             }
         }
         if( v ){
             System.out.println(MSJ_MAT_ESTA_EN_LISTA);
             return obligatoria; 
         }else{
             System.out.println(MSJ_MAT_NO_ESTA_EN_LISTA );
             return obligatoria; //obligatoria = null
         }
     }
       /**Busca materia ExtraProgramtica por nombre y la devuelve 
      * null si no esta 
      * @param  nombre */
      public ExtraProgramatica buscarMatPorNombreEXTRA(String nombre){
          boolean v = false;
//          ArrayList<Materia> listaM = leerArchivoMAT();
          ExtraProgramatica extra = null;
          for(Materia m: listaMaterias ){
               if(m  instanceof ExtraProgramatica){
                        if(m.getNombre().equalsIgnoreCase(nombre)){
                        v= true;
                        extra = (ExtraProgramatica) m;
                        }
                }
         }
         if(v){
             System.out.println(MSJ_MAT_ESTA_EN_LISTA);
             return extra;
         }else{
             System.out.println(MSJ_MAT_NO_ESTA_EN_LISTA);
             return extra; // null
         }
        }
      
      
      /**Modificar una materia
       *@param class
       *@param nombre*/
      public void modificarMateriaOB( Materia m , String nombreNew){
          
//          ArrayList<Materia> listaM = leerArchivoMAT();
          int pos ;
          
          if( m instanceof Obligatoria){
            pos = listaMaterias.indexOf( new Obligatoria(m.getNombre(), m.getCodigo()) );
            listaMaterias.get(pos).setNombre( nombreNew );
           }
//          else{
          
          if( m instanceof ExtraProgramatica ){
            pos = listaMaterias.indexOf( new ExtraProgramatica(m.getNombre(), m.getCodigo()) );
            listaMaterias.get(pos).setNombre( nombreNew );
           } 
          this.cargarArchivoMAT();
      }
      
      
      /**Borrar un materia */
      
      public void borrarMateriaEX(Materia m, GestorPlanEstudio plan ){
          
//          ArrayList<Materia> listMA = leerArchivoMAT();
          boolean b= false;
          if(m!=null){
                 if(m instanceof Obligatoria){
                      DetallePlanEstudio dpO = new DetallePlanEstudio( (Obligatoria)m ,0 );
                      for(PlanEstudio p: plan.getListaPlan()){
                        if  (p.getListadetalle().contains(dpO))
                            b = true;
                      }
                  if(b==false)
                      listaMaterias.remove((Obligatoria)m);
                  else
                      System.out.println("No se puede borrar...");
              }else{
               DetalleExtraProgramaticas dpE = new DetalleExtraProgramaticas((ExtraProgramatica)m,0, 0);
                for(PlanEstudio p : plan.getListaPlan()){
                    if(p.getListaDetalleExtraProgramaticas().contains(dpE))
                        b=true;
                }
                if(b==false)
                    listaMaterias.remove((ExtraProgramatica)m);
                else
                    System.out.println("No se puede borrar...");                        
              }
             this.cargarArchivoMAT();
             
          }else
              System.out.println("No se puede borrar, no existe..");
      }
      
      /**cargar un archivo de materias a partir de una list */
  public void cargarArchivoMAT(){    
      
      
      try ( BufferedWriter bw = new BufferedWriter(new FileWriter(  new File(ARCH_MAT)) ) ){
                for(Materia m: this.listaMaterias ){
                
                 if(m instanceof Obligatoria){
                    bw.write( m.getNombre() +SEPARADOR+m.getCodigo()+SEPARADOR+"Obligatoria");
                    bw.newLine(); //salto de linea 
                 }else{
                    bw.write( m.getNombre() +SEPARADOR+m.getCodigo()+SEPARADOR+"ExtraProgramatica");
                    bw.newLine(); 
                 }
                 
             }
       }catch (IOException ioe) {
            System.out.println("Error en la escritura del  archivo...");
        }
   }
      
      /**leer el archivo
         @return  ArrayList
        */
        public void leerArchivoMAT(){
           
//            ArrayList<Materia> leeMateria = new ArrayList<>();
          
            String Obli= "Obligatoria";
          File f =  new File( ARCH_MAT );
          if(f.exists()){
            try ( BufferedReader br = new BufferedReader(new FileReader( f) ) ){
                String cadena = null;

                while(( cadena  = br.readLine()) != null ) {
                     String[] cads = cadena.split( SEPARADOR );
                       
                     if( cads[2].equalsIgnoreCase(Obli) ){
                        listaMaterias.add( new Obligatoria(cads[0], cads[1]));
                     }else{
                       listaMaterias.add( new ExtraProgramatica(cads[0], cads[1]));

                        }
                }   
            }catch (IOException ioe) {
                    System.out.println("Error en la escritura del  archivo..."); }
         
           }
   
        }
   
}
      


      /** carga un archivo de materias */
//      public void cargarArchivoMATOB( String nombre, String codigo){
//      
//    //con try con recursos
//    
//        try ( BufferedWriter bw = new BufferedWriter(new FileWriter(  new File(ARCH_MAT_OBLI)  ,true) ) ){
//                
//                bw.write( nombre +SEPARADOR+codigo);
//                bw.newLine(); //salto de linea
//                this.cargarArchivoMAT(nombre, codigo);
//                    
//        }
//        catch (IOException ioe) {
//            System.out.println("Error en la escritura del  archivo...");
//        }
//      }
      
      
//con buffer y try normal 
//        BufferedWriter bw = null;
//        File file = new File(ARCH_MAT_OBLI);
//        try {
//                FileWriter fw = new FileWriter(file,true);
//                bw = new BufferedWriter(fw);
//                bw.write( nombre +"/"+codigo);
//                bw.newLine(); //salto de linea 
//        }catch (IOException ioe) {
//            System.out.println("Error en la escritura del  archivo...");
//        }  
//        finally {
//                    if (bw != null) {
//                        try {
//                        bw.close();
//                        }catch (IOException ioe) {
//                        ioe.printStackTrace();//mostraria el error q se produjo 
//                    }}
//}
          
//sin buffer
//          try {
//               FileWriter fw = new FileWriter(ARCH_MAT_OBLI ,true);
//                  fw.write(nombre +"/"+codigo);
//                  fw.write("\n");
//                  fw.close();
//          }catch(IOException ioe) { }
//      }   
      
//      public void cargarArchivoMATEX( String nombre, String codigo){    
//        try ( BufferedWriter bw = new BufferedWriter(new FileWriter(  new File(ARCH_MAT_EXTRA)  ,true) ) ){
//                bw.write( nombre +SEPARADOR+codigo);
//                bw.newLine(); //salto de linea 
//                this.cargarArchivoMAT(nombre, codigo);
//        }
//        catch (IOException ioe) {
//            System.out.println("Error en la escritura del  archivo...");
//        }
//      }
   
    /** carga todas las materias en un archivo */
     
//}