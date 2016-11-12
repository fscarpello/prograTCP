/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
 
import micalendar.FechaInvalidaException;
import micalendar.MiCalendar;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persona.Alumno;
 
/**
 *
 * @author Franco Scarpello
 */
public class AlumnoDAOTxt extends DAO<Alumno, Integer>
{
    public AlumnoDAOTxt(File archivo) throws FileNotFoundException
    {
        archivoRAF = new RandomAccessFile(archivo, "rws");
    }
     
     

 
    @Override
    public void actualizar(Alumno obj) throws IOException, Exception
    {
            archivoRAF.seek(0);
         
            String linea;
            long lineaArchivo = 0;
            boolean encontro = false;
            while((linea = archivoRAF.readLine()) != null && !encontro)
            {
                String[] campos = linea.split("\t");
                if(Integer.valueOf(linea.substring(0, 8)) == obj.getDni())
                {                   
                    archivoRAF.seek(lineaArchivo);
                    archivoRAF.writeBytes(obj.toString() + "\tA");
                    encontro = true;
                }
                else 
                {
                    lineaArchivo = archivoRAF.getFilePointer();
                }             
            }
    }
 
    @Override
    public Alumno buscar(Integer id) throws Exception
    {
        archivoRAF.seek(0);
        String linea;
        boolean encontre = false;
        Alumno alu = null;
         
        while((linea = archivoRAF.readLine()) != null && !encontre)
        {
            String[] campos = linea.split("\t");
            if(Integer.valueOf(linea.substring(0, 8)).equals(id))
            {
                encontre = true;
                alu = new Alumno();
                alu.setFromTxt(linea);
                
                setAlumno(alu, campos);    

            }   
        }
         
        return alu;
  
    }
     
     
 
    @Override
    public boolean existe(Integer id) throws Exception
    {
        archivoRAF.seek(0);
         
        String linea;
        boolean encontre = false;
         
        while((linea = archivoRAF.readLine()) != null && !encontre)
        {
            if(Integer.valueOf(linea.substring(0, 8)).equals(id))
            {
                encontre = true;
            }   
        }
         
        return encontre;
    }
 
    @Override
    public void darDeBaja(Alumno obj) throws Exception
    {
           archivoRAF.seek(0) ;
           
           String linea;
           long lineaArchivo = 0;
           boolean encontro = false;
           while((linea = archivoRAF.readLine()) != null && !encontro){
               String[] campos = linea.split("\t");
               if(Integer.valueOf(linea.substring(0,8)) == obj.getDni()){
                   archivoRAF.seek(lineaArchivo);
                   archivoRAF.writeBytes(obj.toString() + "\tB");
                   encontro = true;
               }
               else
                   lineaArchivo = archivoRAF.getFilePointer();
           }
    }
    
    @Override
    public void eliminar(Alumno obj) throws IOException
    {

    }
 
    @Override
    public List<Alumno> getTodos() throws IOException
    {
        alumnos = new ArrayList();
        archivoRAF.seek(0);
        String linea;
        
        while((linea = archivoRAF.readLine()) != null)
        {
            String[] campos = linea.split("\t");
            try
            {
                if (!"B".equals(campos[8])) {
                    Alumno alu = new Alumno();  
                    
                    setAlumno(alu, campos);

                    alumnos.add(alu);
                }

            }
            catch(Exception ex)
            {
                Logger.getLogger(AlumnoDAOTxt.class.getName()).log(Level.SEVERE, null, ex);                
            }
        }        
        return alumnos;
    }

    private void setAlumno(Alumno alu, String[] campos) throws Exception, FechaInvalidaException, NumberFormatException {
        alu.setDni(Integer.valueOf(campos[0]));
        alu.setApyn(campos[1]);
        String[] fechaNac = campos[2].split("/");
        alu.setFechaNac(new MiCalendar(Integer.valueOf(fechaNac[0]),Integer.valueOf(fechaNac[1]) ,Integer.valueOf(fechaNac[2]) ));
        alu.setSexo(campos[3].charAt(0));
        String[] fechaIng = campos[4].split("/");
        alu.setFechaIngr(new MiCalendar(Integer.valueOf(fechaIng[0]),Integer.valueOf(fechaIng[1]) ,Integer.valueOf(fechaIng[2]) ));
        alu.setCantMatAprob (Integer.valueOf(campos[5]));
        alu.setPromedio(Double.valueOf(campos[6].replace(",",".")));
        alu.setCarrera(campos[7]);
    }
     
    @Override
    public void insertar(Alumno alu) throws Exception
    {
        if(existe(alu.getDni()))
            throw new Exception("Clave " + alu.getDni() + " Duplicada.");

        archivoRAF.seek(archivoRAF.length());
        alumnos.add(alu);
        archivoRAF.writeBytes(alu.toString() + "\tA" + System.lineSeparator());
    }
     
    private RandomAccessFile archivoRAF;
    private List<Alumno> alumnos = new ArrayList();
    
}