/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package unt.herrera.prog2;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Rodrigo Miguel Kameyha
 */
public class Principal{

    /**
     * @param args the command line arguments
     */
  public static void main(String[] args) {
    // niveles
      System.out.println(".................... Niveles ...................................\n");
      GestorNiveles gNivel= GestorNiveles.crear();
      
      gNivel.crearNivel("Primario", "descripcion_1");
      gNivel.crearNivel("Secundario", "descripcion_2");
      gNivel.crearNivel("Terciario", "descripcion_3");
      gNivel.crearNivel("Primario", "descripcion_4");//no deberia agregar nombre repetido 
      gNivel.crearNivel( null, null);    //no deberia agregar elementos nulos 
      gNivel.crearNivel("rodrigo", "descripcion_4q");//no deberia agregar nombre repetido 


   //Materias    
      System.out.println("\n.................... Materias  ...................................\n");
      GestorMaterias gMateria = GestorMaterias.crear();
      
      gMateria.crearMatExtra("Computacion", "111");
      gMateria.crearMatExtra("Ingles", "222");
      gMateria.crearMatExtra("Aleman", "333");
      gMateria.crearMatExtra("Natacion", "444");
      gMateria.crearMatExtra("Computacion", "444"); // no beberia agregar codigo repetido
      gMateria.crearMatExtra(null, "2332"); // no beberia agregar elemento nulo

      gMateria.crearMatObli("Calculo", "555");
      gMateria.crearMatObli("Algebra", "777");
      gMateria.crearMatObli("Fisica", "888");
      gMateria.crearMatObli("Quimica", "999");
      gMateria.crearMatObli("Quimica", "111"); // no beberia agregar codgo repetido 
     
            gMateria.crearMatObli("Fisica3", "99922");

      
      gMateria.cargarArchivoMAT( );
    //Planes 
     System.out.println("\n.................... Planes de Estudio  ...................................\n");
     GestorPlanEstudio gPlanEst = GestorPlanEstudio.crear();

     gPlanEst.crearPlanEstudio("plan_1", LocalDate.of(2011,03,01), LocalDate.now() );
     gPlanEst.crearPlanEstudio("plan_2", LocalDate.of(2014,03,01), LocalDate.of(2012,12,05) );
     gPlanEst.crearPlanEstudio("plan_3", LocalDate.of(2011,03,01), LocalDate.of(2011,12,05) );
     gPlanEst.crearPlanEstudio("plan_4", LocalDate.of(2015,03,01), LocalDate.of(2017,12,05) );
     gPlanEst.crearPlanEstudio("plan_5", LocalDate.of(2011,03,01), LocalDate.of(2220,12,03) );
     gPlanEst.crearPlanEstudio("plan_5", LocalDate.of(2012,03,01), LocalDate.of(2220,12,03) );// no deberia agregar repetida
     gPlanEst.crearPlanEstudio("plan_1", null, LocalDate.of(2220,12,03) );// no deberia agregar elemento null


//Establecimientos 
    System.out.println("\n.................... Establecimientos  ...................................\n");
    GestorEstablecimientos gEsta = GestorEstablecimientos.crear();
   
    gEsta.crearEstalecimiento(" San Miguel"," Rivadavia 444","111",TipoEstablecimiento.PRIVADO);
    gEsta.crearEstalecimiento(" Escuela 2 "," Av. Roca 312","222",TipoEstablecimiento.PRIVADO);
    gEsta.crearEstalecimiento(" Escuela 3 "," San Martin 325","333",TipoEstablecimiento.PUBLICO);
    gEsta.crearEstalecimiento(" Escuela 4 "," Junin 567 ","444",TipoEstablecimiento.PUBLICO);
    gEsta.crearEstalecimiento(" Escuela 5 "," San Juan 456 ","555",TipoEstablecimiento.PRIVADO);
    gEsta.crearEstalecimiento(" Escuela 5 "," San Juan 456 ","555",TipoEstablecimiento.PRIVADO);// no deberia agregar codigo repetido 
    gEsta.crearEstalecimiento(" Escuela 2 "," Av. Roca 312","226",TipoEstablecimiento.PRIVADO);

    
    System.out.println("\n.................... Ofertas Academicas  ...................................\n");
    GestorOfertasAcademicas gOferAcad = GestorOfertasAcademicas.crear();
    
    // creo ofertas academicas
    gOferAcad.crearOfertaAcademica( gNivel.buscarNivel("primario")  , gPlanEst.buscarPlanEstudio("plan_1") );
    gOferAcad.crearOfertaAcademica( gNivel.buscarNivel("secundario"), gPlanEst.buscarPlanEstudio("plan_2") );
    gOferAcad.crearOfertaAcademica( gNivel.buscarNivel("Terciario") , gPlanEst.buscarPlanEstudio("plan_3") );
    gOferAcad.crearOfertaAcademica( gNivel.buscarNivel("secundario"), gPlanEst.buscarPlanEstudio("plan_2") );// no deberia crear repetido 
    

     

    System.out.println("\n.................... Planes de Estudio  ...................................\n");

//Agrego materias a los planes de estudio   
   gPlanEst.buscarPlanEstudio("plan_1").agregarMateria( gMateria.buscarMatPorNombreOBLIG("cALCULO") , 222);
   gPlanEst.buscarPlanEstudio("plan_1").agregarMateria( gMateria.buscarMatPorNombreOBLIG("calculo") , 223); //no deberia agregar 
   gPlanEst.buscarPlanEstudio("plan_1").agregarMateria( gMateria.buscarMatPorNombreEXTRA("computacion") , 229,(float) 22.2 );
   gPlanEst.buscarPlanEstudio("plan_1").agregarMateria( gMateria.buscarMatPorNombreOBLIG("algebra") , 227);
   gPlanEst.buscarPlanEstudio("plan_1").agregarMateria( gMateria.buscarMatPorNombreOBLIG("fisica") , 225);
   gPlanEst.buscarPlanEstudio("plan_1").agregarMateria( gMateria.buscarMatPorNombreEXTRA("Aleman") , 2231,(float) 22.2 );
   gPlanEst.buscarPlanEstudio("plan_1").agregarMateria( gMateria.buscarMatPorNombreEXTRA("Aleman") , 2231,(float) 22.2 ); // no deberia agregar 
   gPlanEst.buscarPlanEstudio("plan_1").agregarMateria( gMateria.buscarMatPorNombreEXTRA("Natacion") , 2213,(float) 22.2 );
   gPlanEst.buscarPlanEstudio("plan_1").agregarMateria( gMateria.buscarMatPorNombreEXTRA("ingles") , 2232,(float) 22.2 );
  
   
   gPlanEst.buscarPlanEstudio("plan_2").agregarMateria( gMateria.buscarMatPorNombreEXTRA("computacion") , 223,(float) 22.2 ); 
   gPlanEst.buscarPlanEstudio("plan_2").agregarMateria( gMateria.buscarMatPorNombreEXTRA("aleman") , 223,(float) 22.2 );
   gPlanEst.buscarPlanEstudio("plan_2").agregarMateria( gMateria.buscarMatPorNombreEXTRA("ingles") , 223,(float) 22.2 );
   gPlanEst.buscarPlanEstudio("plan_2").agregarMateria( gMateria.buscarMatPorNombreOBLIG("cALCULO") , 222);
   gPlanEst.buscarPlanEstudio("plan_2").agregarMateria( gMateria.buscarMatPorNombreOBLIG("Fisica") , 225);


   System.out.println("\n................Cargo una oferta a un Establecimiento..................\n");
   
   gEsta.buscarPorCodigo( "111" ).agregarOferta( gOferAcad.buscarOferta(gNivel.buscarNivel("Primario"), gPlanEst.buscarPlanEstudio("plan_1")) );
   gEsta.buscarPorCodigo( "111" ).agregarOferta( gOferAcad.buscarOferta(gNivel.buscarNivel("Secundario"), gPlanEst.buscarPlanEstudio("plan_2")) );
   gEsta.buscarPorCodigo( "111" ).agregarOferta( gOferAcad.buscarOferta(gNivel.buscarNivel("Terciario"), gPlanEst.buscarPlanEstudio("plan_3")) );
   gEsta.buscarPorCodigo( "111" ).agregarOferta( gOferAcad.buscarOferta(gNivel.buscarNivel("Primario"), gPlanEst.buscarPlanEstudio("plan_1")) );
   //no deberia agregar oferta repetida
   
   gEsta.buscarPorCodigo( "333" ).agregarOferta( gOferAcad.buscarOferta(gNivel.buscarNivel("Primario"), gPlanEst.buscarPlanEstudio("plan_1")) );
   gEsta.buscarPorCodigo( "444" ).agregarOferta( gOferAcad.buscarOferta(gNivel.buscarNivel("Secundario"), gPlanEst.buscarPlanEstudio("plan_2")) );

   
   
   gEsta.buscarPorCodigo( "222" ).agregarOferta( gOferAcad.buscarOferta(gNivel.buscarNivel("primario"), gPlanEst.buscarPlanEstudio("plan_3")) ); 
   //no deberia agregar  oferta invalida
   gEsta.buscarPorCodigo( "222" ).agregarOferta( gOferAcad.buscarOferta(gNivel.buscarNivel("Secundario"), gPlanEst.buscarPlanEstudio("plan_78")) );
   //no deberia agregar  oferta invalida
   gEsta.buscarPorCodigo( "222" ).agregarOferta( gOferAcad.buscarOferta(gNivel.buscarNivel("Secundario"), gPlanEst.buscarPlanEstudio("plan_2")) );
   //deberia agregar oferta valida

     //pruebo el metodo que busca establecimientos por nombre 
   ArrayList<Establecimiento> nombres = gEsta.buscarPorNombre("Escuela 2");
   if(nombres !=null){
       System.out.println("Establecimientos con el mismo nombre: ");
       System.out.println(" Nombre\t\tCodigo");
       System.out.println("---------------------");
      for(Establecimiento es: nombres){
          System.out.println(es.getNombre()+"\t"+es.getCodigo());
        }
   }
   //agrego a los establecimientos buscados con el mismo nombre una misma oferta academica 
   if(nombres != null){
       for(Establecimiento est: nombres){
           est.agregarOferta(gOferAcad.buscarOferta( gNivel.buscarNivel( "primario"), gPlanEst.buscarPlanEstudio( "plan_1")) );
       }
   }
 
   
   
 //Muestro todos los array creados 
  
    System.out.println("\n::::::::::::::::::::: lista creados::::::::::::::::::::::::::::::::::\n");
  
    gNivel.mostrarNiveles();
        
    gMateria.mostrarMaterias( CriterioDeOrdenamiento.ASCENDENTE );
        
    gOferAcad.mostrarOfertasAcademicas();
        
    gPlanEst.mostrarPlanesEstudio( CriterioDeOrdenamiento.ASCENDENTE);
        
    gEsta.mostrarEstablecimientos( CriterioDeOrdenamiento.ASCENDENTE ,TipoCmpMateria.NOMBRE);

    gPlanEst.planesDeEstudioNoVigentes(CriterioDeOrdenamiento.ASCENDENTE);
    
    
    
    
      System.out.println("·············prctico 7.....");
      gEsta.modificarEstab( gEsta.buscarPorCodigo("11177"), "RODRIGO", "RODRIGO");
    
      
      
      gEsta.borrarEstab( gEsta.buscarPorCodigo("555"));
  gEsta.mostrarEstablecimientos(CriterioDeOrdenamiento.ASCENDENTE, TipoCmpMateria.CODIGO);
  
  
       gPlanEst.modificarPlan( gPlanEst.buscarPlanEstudio("plan_2"), LocalDate.now() );
       
       gPlanEst.borrarPlan( gPlanEst.buscarPlanEstudio("plan_4"));
       
       gPlanEst.mostrarPlanesEstudio(CriterioDeOrdenamiento.ASCENDENTE);
       
       
       
      try{ 
        gPlanEst.buscarPlanEstudio("plan_1").modificarMatOB(gMateria.buscarMatPorNombreOBLIG("fisica") ,22);
        gPlanEst.buscarPlanEstudio("plan_1").modificarMatEX(gMateria.buscarMatPorNombreEXTRA("computacion"), 50, (float)400.45);
 
        gPlanEst.buscarPlanEstudio("plan_1").borrarDetMatEX( gMateria.buscarMatPorNombreEXTRA("computacion") );
        
      }catch( NullPointerException r){
          System.out.println("No se puede modificar...");
      }
      gPlanEst.buscarPlanEstudio("plan_1").mostrar();
      
      gMateria.mostrarMaterias(CriterioDeOrdenamiento.ASCENDENTE);

      gMateria.modificarMateriaOB(gMateria.buscarMatPorNombreOBLIG("fisica"), "nombreNew");

      gMateria.borrarMateriaEX(gMateria.buscarMatPorNombre("nombreNew"), gPlanEst);

      gMateria.mostrarMaterias(CriterioDeOrdenamiento.ASCENDENTE);
      

      gNivel.mostrarNiveles();
      gNivel.borrarNivel(gNivel.buscarNivel("rodrigo"), gEsta,gPlanEst);
      gNivel.mostrarNiveles();
      
   }
}
