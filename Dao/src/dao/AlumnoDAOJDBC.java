   /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import calendar.MiCalendar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persona.Alumno;

/**
 *
 * @author Nestor
 */
public class AlumnoDAOJDBC extends DAO<Alumno, Integer>
{

    public AlumnoDAOJDBC() throws SQLException
    {
        //Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/universidad?user=root", "root", "Discus");
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/user=root", "root", "prisma");
        /** Sentencia de BUSCAR*/
        String sentencia = "SELECT * FROM persona.alumno WHERE dni = ?";

        pstmtBuscar = conexion.prepareStatement(sentencia);

        /** Sentencia de NUEVO*/
        sentencia =
                "INSERT INTO persona.alumno\n" +
                "(dni, apyn, fecha_nac, sexo, fec_ing, mat_aprob, promedio, carrera)\n" +
                "VALUES\n" +
                "(?, ?, ?, ?, ?, ?, ?, ?)";

        pstmtInsertar = conexion.prepareStatement(sentencia);

        /** Sentencia de GETTODOS*/

        sentencia = "SELECT * FROM persona.alumno";
        pstmtGetTodos = conexion.prepareStatement(sentencia);

        /** Sentencia de ELIMINAR */

        sentencia = "DELETE FROM persona.alumno\n" +
                    "WHERE dni = ?";

        pstmtEliminar = conexion.prepareStatement(sentencia);

        /** Sentencia de EXISTE*/

        sentencia = "SELECT dni FROM persona.alumno\n" +
                    "WHERE dni = ?\n";

        pstmtExiste = conexion.prepareStatement(sentencia);

        /** Sentencia de ACTUALIZAR*/

        sentencia = "UPDATE CROM persona.alumno\n" +
                    "SET\n" +
                        "dni = ?,\n" +
                        "apyn = ?\n" +
                        "fec_nac = ?\n" +
                        "sexo = ?\n" +
                        "fec_ing = ?\n" +
                        "mat_aprob = ?\n" +
                        "promedio = ?\n" +
                        "carrera = ?";

        pstmtActualizar = conexion.prepareStatement(sentencia);
    }

    @Override
    public void insertar(Alumno alu) throws Exception
    {
            pstmtInsertar.setInt(1, alu.getDni());
            pstmtInsertar.setString(2, alu.getApyn());
            pstmtInsertar.setDate(3, alu.getFechaNac().toDate());
            pstmtInsertar.setString(4, String.valueOf(alu.getSexo()));
            pstmtInsertar.setString(5, alu.getCarrera());

            pstmtInsertar.executeUpdate();
    }

    @Override
    public void actualizar(Alumno alu) throws Exception
    {
        pstmtActualizar.setInt(1, alu.getDni());
        pstmtActualizar.setString(2, alu.getApyn());
        pstmtActualizar.setDate(3, (alu.getFechaNac().toDate()));
        pstmtActualizar.setString(4, String.valueOf(alu.getSexo()));
        pstmtActualizar.setDate(5, (alu.getFechaIngr().toDate()));
        pstmtActualizar.setInt(6, alu.getCantMatAprob());
        pstmtActualizar.setDouble(7, alu.getPromedio());
        pstmtActualizar.setString(8, alu.getCarrera());
        
        pstmtActualizar.executeUpdate();
    }

    @Override
    public Alumno buscar(Integer id) throws Exception
    {
            pstmtBuscar.setInt(1, id);

            ResultSet rs = pstmtBuscar.executeQuery();

            if(!rs.next())
                return null;

            Alumno alu = new Alumno();

            alu.setDni(id);
            alu.setApyn(rs.getString("apyn"));
            alu.setFechaNac(new MiCalendar(rs.getDate("fecha_nac")));
            alu.setSexo(rs.getString("sexo").charAt(0));
            alu.setFechaIngr(new MiCalendar(rs.getDate("fecha_ing")));
            alu.setCantMatAprob(rs.getInt("mat_aprob"));
            alu.setPromedio(rs.getDouble("promedio"));
            alu.setCarrera(rs.getString("carrera"));

            return alu;
    }

    @Override
    public boolean existe(Integer id) throws Exception
    {
        pstmtExiste.setInt(1, id);

        ResultSet rs = pstmtExiste.executeQuery();
        
        boolean encontre = false;
         
        while(rs.next() && !encontre){
            if(rs.getInt(1) == id)
            {
                encontre = true;
            }   
        }
        
        return encontre;
    }

    @Override
    public void eliminar(Alumno alu) throws Exception
    {
        if(!existe(alu.getDni()))
            throw new DAOException("El alumno a eliminar no existe en la base de datos.");

        try {
            pstmtEliminar.setInt(1, alu.getDni());
            pstmtEliminar.execute();

        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Eliminar falló: " + ex.getMessage());
        }
    }

    @Override
    public List<Alumno> getTodos() throws Exception
    {
        ResultSet rs; 

        rs = pstmtGetTodos.executeQuery();
        try{
            while(rs.next()){
                Alumno alu = new Alumno();
                alu.setDni(rs.getInt(1));
                alu.setApyn(rs.getString(2));
                alu.setFechaNac(new MiCalendar(rs.getDate(3)));
                alu.setSexo(rs.getString(4).charAt(0));
                alu.setFechaIngr(new MiCalendar(rs.getDate(5)));
                alu.setCantMatAprob(rs.getInt(6));
                alu.setPromedio(rs.getDouble(7));
                alu.setCarrera(rs.getString(8));

                alumnos.add(alu);
            }
        } catch (SQLException | DAOException ex) {
            Logger.getLogger(AlumnoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Buscar falló: " + ex.getMessage());
        }    
        return alumnos;
    }
	
    private List<Alumno> alumnos = new ArrayList();
    private PreparedStatement pstmtBuscar;
    private PreparedStatement pstmtInsertar;
    private PreparedStatement pstmtActualizar;
    private PreparedStatement pstmtGetTodos;
    private PreparedStatement pstmtEliminar;
    private PreparedStatement pstmtExiste;
}
