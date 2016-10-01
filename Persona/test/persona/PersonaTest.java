/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package persona;

import micalendar.MiCalendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author laboratorios
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
    public void testSetDni() {
        System.out.println("setDni");
        int dni = 0;
        Persona instance = new Persona();
        instance.setDni(dni);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDni method, of class Persona.
     */
    @Test
    public void testGetDni() {
        System.out.println("getDni");
        Persona instance = new Persona();
        int expResult = 0;
        int result = instance.getDni();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setApyn method, of class Persona.
     */
    @Test
    public void testSetApyn() {
        System.out.println("setApyn");
        String apyn = "";
        Persona instance = new Persona();
        instance.setApyn(apyn);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getApyn method, of class Persona.
     */
    @Test
    public void testGetApyn() {
        System.out.println("getApyn");
        Persona instance = new Persona();
        String expResult = "";
        String result = instance.getApyn();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGenero method, of class Persona.
     */
    @Test
    public void testSetGenero() {
        System.out.println("setGenero");
        char genero = ' ';
        Persona instance = new Persona();
        instance.setGenero(genero);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGenero method, of class Persona.
     */
    @Test
    public void testGetGenero() {
        System.out.println("getGenero");
        Persona instance = new Persona();
        char expResult = ' ';
        char result = instance.getGenero();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        fail("The test case is a prototype.");
    }
    
}
