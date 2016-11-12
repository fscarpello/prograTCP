/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import micalendar.FechaInvalidaException;
import micalendar.MiCalendar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import persona.Alumno;

/**
 *
 * @author Franco Scarpello
 */
public class AlumnoDAOJDBC extends DAO<Alumno, Integer>
{

	public AlumnoDAOJDBC() throws SQLException
	{
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/universidad?user=root", "root", "Discus");
		
		String sentencia = "SELECT * FROM alumno WHERE dni = ?";
		
		pstmtBuscar = conexion.prepareStatement(sentencia);
		
		sentencia =
			"INSERT INTO alumno\n" +
			"(dni, apyn, fecha_nac, sexo, carrera)\n" +
			"VALUES\n" +
			"(?, ?, ?, ?, ?)\n";
				
		pstmtInsertar = conexion.prepareStatement(sentencia);
	}
	
	@Override
	public void insertar(Alumno alu) throws Exception
	{
		pstmtInsertar.setInt(1, alu.getDni());
		pstmtInsertar.setString(2, alu.getApyn());
		//pstmtInsertar.setDate(3, alu.getFechaNac().toDate());
		pstmtInsertar.setString(4, String.valueOf(alu.getSexo()));
		pstmtInsertar.setString(5, alu.getCarrera());
		
		pstmtInsertar.executeUpdate();
	}

	@Override
	public void actualizar(Alumno obj) throws Exception
	{
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
		//alu.setFechaNac(new MiCalendar(rs.getDate("fecha_nac")));
		alu.setSexo(rs.getString("sexo").charAt(0));
		alu.setCarrera(rs.getString("carrera"));
		
		return alu;
	}

	@Override
	public boolean existe(Integer id) throws Exception
	{
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void eliminar(Alumno obj) throws Exception
	{
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public List<Alumno> getTodos() throws Exception
	{
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
	
	private PreparedStatement pstmtBuscar;
	private PreparedStatement pstmtInsertar;

    @Override
    public void darDeBaja(Alumno obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
