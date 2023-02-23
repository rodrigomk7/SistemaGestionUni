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
public class Establecimiento {
    private String nombre;
    private String domicilio;
    private String codigo;
    private TipoEstablecimiento tipo;

    private ArrayList<OfertaAcademica> listaOferta= new ArrayList<OfertaAcademica>();



    public Establecimiento(String nombre, String domicilio, String codigo, TipoEstablecimiento tipo) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.codigo = codigo;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public TipoEstablecimiento getTipo() {
        return tipo;
    }

    public void setTipo(TipoEstablecimiento tipo) {
        this.tipo = tipo;
    }
    public ArrayList<OfertaAcademica> getListaOferta() {
        return listaOferta;
    }

    public void setListaOferta(ArrayList<OfertaAcademica> listaOferta) {
        this.listaOferta = listaOferta;
    }

    /** Agregar una OfertaAcademica a un Establecimiento
     * @param oferta
      */

    public void agregarOferta(OfertaAcademica oferta){
       if(oferta != null){
        if(!listaOferta.contains(oferta)){
         this.listaOferta.add(oferta);
         oferta.agregarEstablecimiento(this);
         }
       }
    }

    /** Muestra un establecimiento con su oferta academica*/

    public void mostrar(){
        System.out.println("Lista de Ofertas Academicas: ");
        if(!listaOferta.isEmpty()){
                for(OfertaAcademica L : listaOferta )
                L.mostrar();
                System.out.println("\n\n");
        }else
          System.out.println("La lista esta VACIA...\n");
    }
    

    @Override
    public String toString() {
    return  "Código: "+ codigo +"\t\t\t Nombre:" + nombre + "\nDomicilio: " +domicilio+"\t\tTipo: "+tipo ;
        }
/**Metodo para comparar si dos establecimientos
   * son iguales por codig
     * @return o*/
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.codigo);
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
        final Establecimiento other = (Establecimiento) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }
    
    
    // metodos para comparara y usar referencia a metodos
     public int compararNombre(Establecimiento e) {
       return this.nombre.compareTo(e.nombre);
    }

     public int compararCodigo(Establecimiento e) {
       return this.codigo.compareTo(e.codigo);
    }

     
     /**Borra una Oferta Academica de un Establecimiento
      @param OfertaAcademica */
     public void borrarOferta( OfertaAcademica oferta ){
         if( oferta != null){
             if( !listaOferta.isEmpty() )
             this.listaOferta.remove(oferta);
         }
     }
}











