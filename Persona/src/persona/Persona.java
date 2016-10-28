/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package persona;
 
import micalendar.FechaInvalidaException;
import micalendar.MiCalendar;

 
/**
 *
 * @author Franco Scarpello
 */
public class Persona
{
    public Persona() throws FechaInvalidaException
    {
        fechaNac = new MiCalendar(1, 1, 1900);
    }
     
     
    public Persona(int dni) throws Exception
    {
        setDni(dni);
         
        this.dni = dni;
         
        fechaNac = new MiCalendar(1, 1, 1900);
    }
     
     
     
    public Persona(int dni, String apyn, MiCalendar fechaNac, char sexo) throws Exception
    {
        this.dni = dni;
        this.apyn = apyn;
         
        if(fechaNac == null)
            throw new Exception("La fecha es nula");
         
        this.fechaNac = fechaNac;
        this.sexo = sexo;
    }
     
    public int getDni()
    {
        return dni;
    }
 
    public final void setDni(int dni) throws Exception
    {
        if(dni <= 0)
            throw new Exception("El DNI " + dni + " es inválido");
         
        this.dni = dni;
    }
 
    public String getApyn()
    {
        return apyn;
    }
 
    public void setApyn(String apyn)
    {
        this.apyn = apyn;
    }
 
    public MiCalendar getFechaNac()
    {
        return fechaNac;
    }
 
    public void setFechaNac(MiCalendar fechaNac)
    {
        this.fechaNac = fechaNac;
    }
 
    public char getSexo()
    {
        return sexo;
    }
 
    public void setSexo(char sexo)
    {
        this.sexo = sexo;
    }
 
    @Override
    public String toString()
    {
        return String.format("%08d", dni) + "\t" + 
               String.format("%-30s", apyn) + "\t" + 
                fechaNac.toString() + "\t" + 
                sexo;
    }
     
     
     
     
    private int dni;
    private String apyn;
    private MiCalendar fechaNac;
    private char sexo;
}