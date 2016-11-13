/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendar;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Nestor
 */
public class MiCalendar extends GregorianCalendar
{
	public MiCalendar(int dia, int mes, int año) throws FechaInvalidaException
	{
		super(año, mes-1, dia);
		
		super.setLenient(false);
		
		try
		{
			super.get(Calendar.DAY_OF_MONTH);
			super.get(Calendar.MONTH);
			super.get(Calendar.YEAR);
		}
		catch(Exception ex)
		{
			throw new FechaInvalidaException("La fecha " + dia + "/" + mes + "/" + año + " es inválida");
		}
	}

	public MiCalendar(Date date) throws FechaInvalidaException
	{
		setTime(date);
		
		super.setLenient(false);
		
		try
		{
			super.get(Calendar.DAY_OF_MONTH);
			super.get(Calendar.MONTH);
			super.get(Calendar.YEAR);
		}
		catch(Exception ex)
		{
			throw new FechaInvalidaException("La fecha " + date.getDate() + "/" + date.getMonth() + "/" + date.getYear() + " es inválida");
		}		
	}
	
	
	public int getDia()
	{
		return get(Calendar.DAY_OF_MONTH);
	}
	
	
	public int getMes()
	{
		return get(Calendar.MONTH) + 1;
	}
	
	
	public int getAño()
	{
		return get(Calendar.YEAR);
	}
	
	
	@Override
	public String toString()
	{
		return String.format("%02d/%02d/%04d", getDia(), getMes(), getAño());
	}
	
	
	public Date toDate()
	{
		return new Date(getTimeInMillis());
	}
}
