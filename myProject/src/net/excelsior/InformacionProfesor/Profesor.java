/*
 * Esta clase en este paquete es SUPER TENTATIVO!
 */
package net.excelsior.InformacionProfesor;

import java.util.ArrayList;

/**
 *
 * @author marcos 
 */
public class Profesor extends Usuario{
    
     private ArrayList<String> titulos = new ArrayList<String>();
     private ArrayList<String> materialApoyo = new ArrayList<String>();
    
     public ArrayList getTitulos(){
         return this.titulos;
     }
     
     public ArrayList getMaterialApoyo(){
         return this.materialApoyo;
     }
     
}
