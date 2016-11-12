/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abm.alumnos;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import persona.Alumno;
 
/**
 *
 * @author Franco Scarpello
 */
public class MiModeloTabla extends AbstractTableModel
{
    public MiModeloTabla()
    {
        alumnos = new ArrayList<>();
    }
     
     
    void setAlumnos(List<Alumno> alumnos)
    {
        this.alumnos = alumnos;
        fireTableDataChanged();
    }
     
     
    @Override
    public int getRowCount()
    {
        return alumnos.size();
    }
     
     
    @Override
    public int getColumnCount()
    {
        return 8;
    }
    
     
     
    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        Alumno alumno = alumnos.get(rowIndex);
         
        switch(columnIndex)
        {
            case 0: return alumno.getDni();
            case 1: return alumno.getApyn();
            case 2: return alumno.getFechaNac();
            case 3: return alumno.getSexo();
            case 4: return alumno.getFechaIngr();
            case 5: return alumno.getCantMatAprob();
            case 6: return alumno.getPromedio();
            case 7: return alumno.getCarrera();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return nomColumnas[column];
    }

     
    private List<Alumno> alumnos;
    private static final String[] nomColumnas = {"DNI", "Apellido y Nombre", "Fecha de Nacimiento", "Sexo", "Fecha de Ingreso", "Cantidad de Materias Aprobadas", "Promedio", "Carrera"};
}