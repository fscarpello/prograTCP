/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persona;
 
import calendar.FechaInvalidaException;
import calendar.MiCalendar;
 
/**
 *
 * @author Franco Scarpello
 */
public class Alumno extends Persona
{
    public Alumno() throws FechaInvalidaException
    {
    }
     
 
    public int getCantMatAprob()
    {
        return cantMatAprob;
    }
 
    public void setCantMatAprob(int cantMatAprob)
    {
        this.cantMatAprob = cantMatAprob;
    }
 
    public String getCarrera()
    {
        return carrera;
    }
 
    public void setCarrera(String carrera)
    {
        this.carrera = carrera;
    }
 
    public MiCalendar getFechaIngr()
    {
        return fechaIngr;
    }
 
    public void setFechaIngr(MiCalendar fechaIngr)
    {
        this.fechaIngr = fechaIngr;
    }
 
    public double getPromedio()
    {
        return promedio;
    }
 
    public void setPromedio(double promedio)
    {
        this.promedio = promedio;
    }
     
     
    @Override
    public String toString()
    {
        return super.toString() + "\t" +
               fechaIngr.toString() + "\t" +
               String.format("%02d", cantMatAprob) + "\t" +
               String.format("%02.2f", promedio) + "\t" +
               carrera;
    }
     
 
    public void setFromTxt(String linea) throws Exception
    {
        String[] campos = linea.split("\t");
         
        setDni(Integer.valueOf(campos[0]));
        
        setApyn(campos[1]);

        String[] fechaNacStr = campos[2].split("/");
        MiCalendar fechaNac = new MiCalendar(Integer.valueOf(fechaNacStr[0]), Integer.valueOf(fechaNacStr[1]), Integer.valueOf(fechaNacStr[2]));
        setFechaNac(fechaNac);

        setSexo(campos[3].charAt(0));

        String[] fechaIngrStr = campos[4].split("/");
        MiCalendar fechaIngr = new MiCalendar(Integer.valueOf(fechaIngrStr[0]), Integer.valueOf(fechaIngrStr[1]), Integer.valueOf(fechaIngrStr[2]));
        setFechaIngr(fechaIngr);

        setCantMatAprob(Integer.valueOf(campos[5]));
        
        setPromedio(Double.valueOf(campos[6].replace(',', '.')));
        
        setCarrera(campos[7]);
    }
    
    
    private int cantMatAprob;
    private String carrera;
    private MiCalendar fechaIngr;
    private double promedio;
}