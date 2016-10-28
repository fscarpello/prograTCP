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
import javax.swing.JFileChooser;
import persona.Alumno;
 
/**
 *
 * @author Nestor
 */
public class AlumnoDAOTxt extends DAO<Alumno, Integer>
{
    public AlumnoDAOTxt(File archivo) throws FileNotFoundException
    {
        archivoRAF = new RandomAccessFile(archivo, "rws");
    }
     
     
    @Override
    public void insertar(Alumno alu) throws Exception
    {
        if(existe(alu.getDni()))
            throw new Exception("Clave " + alu.getDni() + " Duplicada.");
         
        archivoRAF.seek(archivoRAF.length());
        archivoRAF.writeBytes(alu.toString() + System.lineSeparator());

    }
 
    @Override
    public void actualizar(Alumno obj) throws IOException
    {
            archivoRAF.seek(0);
         
            String linea;
            long lineaArchivo = 0;
            boolean encontro = false;
            while((linea = archivoRAF.readLine()) != null && !encontro)
            {
                String[] campos = linea.split("\t");
                if(Integer.valueOf(linea.substring(0, 8)) == obj.getDni() && !"B".equals(campos[8]) )
                {                   
                    archivoRAF.seek(lineaArchivo);
                    archivoRAF.writeBytes(obj.toString() + System.lineSeparator());
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
            if(Integer.valueOf(linea.substring(0, 8)).equals(id))
            {
                encontre = true;
                alu = new Alumno();
                alu.setFromTxt(linea);
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
    public void eliminar(Alumno obj) throws IOException
    {
        archivoRAF.seek(0);
        
        String linea;
        long lineaArchivo = 0;
        boolean encontro = false;
        while((linea = archivoRAF.readLine()) != null && !encontro)
        {
            if(Integer.valueOf(linea.substring(0, 8)) == obj.getDni()){
                archivoRAF.writeChar(' ');
                encontro = true;
                System.out.println("Se ha eliminado el usuario");
                
            } else
            {
                lineaArchivo = archivoRAF.getFilePointer();
            }                
        }
    }
 
    @Override
    public List<Alumno> getTodos() throws IOException
    {
        archivoRAF.seek(0);
         
        String linea;
        List<Alumno> alumnos = new ArrayList<>();
        while((linea = archivoRAF.readLine()) != null && !"B".equals(linea.substring(56, 57)) )
        {
            try
            {
                Alumno alu = new Alumno();
                alu.setFromTxt(linea);
                 
                alumnos.add(alu);
            }
            catch(Exception ex)
            {
                Logger.getLogger(AlumnoDAOTxt.class.getName()).log(Level.SEVERE, null, ex);                
            }
        }          
        return alumnos;
    }
     
     
    private RandomAccessFile archivoRAF;
 
}