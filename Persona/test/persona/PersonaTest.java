/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persona;

import java.util.logging.Level;
import java.util.logging.Logger;
import micalendar.MiCalendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Franco Scarpello
 */
public class PersonaTest {

   
    public PersonaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setDni method, of class Persona.
     */
    @Test
    public void testSetDni() throws Exception {
        System.out.println("setDni");
        int dni = 37842567;
        Persona instance = new Persona();
        instance.setDni(dni);
        if(dni < 1)
            fail("El dni " + dni + " es inválido");

    }
    
    /**
     * Test of getDni method, of class Persona.
     */
    @Test
    public void testGetDni() {
        System.out.println("getDni");
        Persona instance = new Persona();
        int expResult = 37842567;
        int result = instance.getDni();
        assertEquals(expResult, result);
        if(expResult != result)
            fail("El dni obtenido no coincide");

    }



    /**
     * Test of getApyn method, of class Persona.
     */
    @Test
    public void testGetApyn() {
        System.out.println("getApyn");
        Persona instance = new Persona();
        String expResult = "Franco Scarpello";
        String result = instance.getApyn();
        assertEquals(expResult, result);

    }

    /**
     * Test of setApyn method, of class Persona.
     */
    @Test
    public void testSetApyn() throws Exception {
        System.out.println("setApyn");
        String apyn = "Franco Scarpello";
        Persona instance = new Persona();
        instance.setApyn(apyn);
        if("".equals(apyn))
            fail("Completar Apellido y Nombre");

    }

    /**
     * Test of getGenero method, of class Persona.
     */
    @Test
    public void testGetGenero() {
        System.out.println("getGenero");
        Persona instance = new Persona();
        char expResult = 'M';
        char result = instance.getGenero();
        assertEquals(expResult, result);

    }

    /**
     * Test of setGenero method, of class Persona.
     */
    @Test
    public void testSetGenero() {
        System.out.println("setGenero");
        char genero = 'M';
        Persona instance = new Persona();
        try {
            instance.setGenero(genero);
        } catch (Exception ex) {
            Logger.getLogger(PersonaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(genero != 'M' && genero != 'F')
            fail("El género " + genero + " es inválido.");

    }

    /**
     * Test of getFechaNacimiento method, of class Persona.
     */
    @Test
    public void testGetFechaNacimiento() {
        System.out.println("getFechaNacimiento");
        Persona instance = new Persona();
        MiCalendar expResult = null;
        MiCalendar result = instance.getFechaNacimiento();
        assertEquals(expResult, result);

    }

    /**
     * Test of setFechaNacimiento method, of class Persona.
     */
    @Test
    public void testSetFechaNacimiento() {
        System.out.println("setFechaNacimiento");
        MiCalendar fechaNacimiento = null;
        Persona instance = new Persona();
        instance.setFechaNacimiento(fechaNacimiento);

    }

    /**
     * Test of main method, of class Persona.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Persona.main(args);
        // TODO review the generated test code and remove the default call to fail.

    }
}
    

