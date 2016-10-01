/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package micalendar;

import java.util.Calendar;
import java.util.GregorianCalendar;


/**
 *
 * @author laboratorios
 */
public class MiCalendar extends GregorianCalendar {

    public MiCalendar(int dia, int mes, int año) throws ExcFechaInvalida   {
        
        super(año,mes,dia);
        super.setLenient(false);
        
        try{
            super.get(Calendar.YEAR);
        }
        catch(Exception ex){
            throw new ExcFechaInvalida("El año es inválido");
        }
        
        try{
            super.get(Calendar.MONTH);
        }
        catch(Exception ex){
            throw new ExcFechaInvalida("El mes es inválido");
        }
        
        try{
            super.get(Calendar.DAY_OF_MONTH);
        }
        catch(Exception ex){
            throw new ExcFechaInvalida("El año es inválido");
        }
        
    }

    public static class ExcFechaInvalida extends Exception{
        public ExcFechaInvalida(String msg){
            super(String.format("El %s es inválido", msg));
        }
    }
    
    
    @Override
    public String toString() {
        return String.format("%2d/%2d/%4d", get(Calendar.DAY_OF_MONTH), get(Calendar.MONTH), get(Calendar.YEAR));
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
