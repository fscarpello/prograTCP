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
 * @author Franco Scarpello
 */
public class MiCalendar extends GregorianCalendar {
     
    public MiCalendar(int dia, int mes, int año) throws FechaInvalidaException {
        super(año, mes-1, dia);
        this.setLenient(false);
         
        try {
            getDia();
            getMes();
            getAño();
        } catch (Exception e) {
            throw new FechaInvalidaException("La fecha no es válida");
        }
    }
 
    public MiCalendar()
    {
        this.setLenient(false);
    }
 
    public int getDia() {
        return this.get(Calendar.DAY_OF_MONTH);
    }
     
    public int getMes() {
        return this.get(Calendar.MONTH)+1;
    }
     
    public int getAño() {
        return this.get(Calendar.YEAR);
    }
     
    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", getDia(), getMes(), getAño());
    }
     
     
    public void setFechaTxt(String fechaTxt) throws FechaInvalidaException
    {
        String[] dma = fechaTxt.split("/");
         
        set(DAY_OF_MONTH, Integer.valueOf(dma[0]));
        set(MONTH, Integer.valueOf(dma[1]));
        set(YEAR, Integer.valueOf(dma[2]));
         
        try {
            getDia();
            getMes();
            getAño();
        } catch (Exception e) {
            throw new FechaInvalidaException("La fecha no es válida");
        }       
    }
}
     
     