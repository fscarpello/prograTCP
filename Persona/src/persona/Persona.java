/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package persona;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import micalendar.MiCalendar;

/**
 *
 * @author Franco Scarpello
 */

public class Persona{

    public Persona(int dni, String apyn, char genero, MiCalendar fechaNacimiento) throws Exception{
        setDni(dni);
        this.apyn = apyn;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
    }

    Persona() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getDni() {
        return dni;
    }
    
    public void setDni(int dni) throws Exception {
        if(dni < 1)
            throw new Exception("El DNI " + dni + " es inválido.");
        
        this.dni = dni;
    }

    public String getApyn() {
        return apyn;
    }
    
    public void setApyn(String apyn) {
        this.apyn = apyn;
    }
    
    public char getGenero() {
        return genero;
    }
    
    public void setGenero(char genero) throws Exception {
        if(genero != 'M' && genero != 'F')
            throw new Exception("El género " + genero + " es inválido.");

        this.genero = genero;
    }

    public MiCalendar getFechaNacimiento() {
        return fechaNacimiento;
    }  
    
    public void setFechaNacimiento(MiCalendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /* ESTO NO LO PIDIÓ TODAVÍA (si se pide se descomenta el còdigo)
    @Override
    public String toString() {
        String an = apyn;
        if(an.length()>30)
            an = apyn.substring(0,30);
        
        return String.format("%08d\t%-30s\t%c\t%10s", dni, an, genero, fechaNacimiento.toString());
    }
   
    public String getTextoFijo(){
        return String.format("%08d\t%-30s\t%c\t%10s", dni, apyn, genero, fechaNacimiento.toString());
    }
    
    public void setTextoFijo(String linea){
        dni = Integer.valueOf(linea.substring(0,8));
        apyn = linea.substring(8,38).trim();
        genero = linea.charAt(38);
        
        try{
            fechaNacimiento = new MiCalendar(Integer.valueOf(linea.substring(43,47).trim()),
                                             Integer.valueOf(linea.substring(41,43).trim()),
                                             Integer.valueOf(linea.substring(39,41).trim()));
        }
        catch(NumberFormatException | MiCalendar.ExcFechaInvalida ex)
        {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
    }

    
    private int dni;
    private String apyn;
    private char genero;
    private MiCalendar fechaNacimiento;
}
