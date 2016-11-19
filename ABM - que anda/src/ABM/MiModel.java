/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ABM;

import Alumno.Alumno;
import MiCalendar.MiCalendar;
import Persona.PersonaInvalidaException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nico
 */
public class MiModel extends AbstractTableModel {
    
    private List <Alumno> alumnos;
    private String[] encabezados = {"Estado","DNI","Apellido y Nombre","F. Nacimiento","Sexo","F. Ingreso","Cant. materias aprobadas"," Promedio","Carrera"};

    public MiModel() {
        alumnos = new ArrayList<>();
    }
        
    public void setAlumnos(List <Alumno> alumnos) {
        this.alumnos = alumnos;
        fireTableDataChanged();
    }
    
            
    @Override
    public int getRowCount() {
        return alumnos.size();        
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public Object getValueAt(int fila, int col) {
        Alumno alu = alumnos.get(fila);
        switch(col){
            case 1: return alu.getDni();
            case 2: return alu.getApyn();
            case 3: return alu.getFechaNac();
            case 4: return alu.getSexo();
            case 5: return alu.getFechaIngreso();
            case 6: return alu.getCantMatAprob();
            case 7: return alu.getPromedio();
            case 8: return alu.getCarrera();
            case 0: return alu.getEstado();
            default: return null;            
        }            
    }            
    
    @Override
    public String getColumnName(int i) {
        return encabezados[i];
    }

    @Override
    public Class<?> getColumnClass(int i) {        
        return super.getColumnClass(i);
    }
     
    
    
}
