/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package persona;
import micalendar.MiCalendar;

/**
 *
 * @author laboratorios
 */
public class Persona{
    private int dni;
    private String apyn;
    private char genero;
    private MiCalendar fechaNacimiento;

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getDni() {
        return dni;
    }
    
    public void setApyn(String apyn) {
        this.apyn = apyn;
    }
    
    public String getApyn() {
        return apyn;
    }
    
    public void setGenero(char genero) {
        this.genero = genero;
    }

    public char getGenero() {
        return genero;
    }
    
    public void setFechaNacimiento(MiCalendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
   
    public MiCalendar getFechaNacimiento() {
        return fechaNacimiento;
    }  

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
