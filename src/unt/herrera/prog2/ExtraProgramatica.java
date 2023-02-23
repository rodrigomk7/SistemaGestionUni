/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2;

/**
 *
 * @author Rodrigo Miguel Kameyha
 */
public class ExtraProgramatica extends Materia{

    public ExtraProgramatica(String nombre, String codigo) {
        super(nombre, codigo);
    }
    
    @Override
    public void mostrar(){ 
        System.out.println(super.getNombre());
      } 

    @Override
    public String tipoMateria() {
       return "  Es EXTRAPROGRAMATICA... ";
    }
    
    
}
