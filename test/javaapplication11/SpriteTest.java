/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication11;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nurcan
 */
public class SpriteTest {
    
    public SpriteTest() {
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
     * Test of getImage method, of class Sprite.
     */
    @Test
    public void testGetImage() {
        System.out.println("getImage");
        Sprite instance = null;
        Image expResult = null;
        Image result = instance.getImage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setImage method, of class Sprite.
     */
    @Test
    public void testSetImage() {
        System.out.println("setImage");
        Image image = null;
        Sprite instance = null;
        instance.setImage(image);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPositionX method, of class Sprite.
     */
    @Test
    public void testGetPositionX() {
        System.out.println("getPositionX");
        Sprite instance = null;
        double expResult = 0.0;
        double result = instance.getPositionX();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPositionX method, of class Sprite.
     */
    @Test
    public void testSetPositionX() {
        System.out.println("setPositionX");
        double positionX = 0.0;
        Sprite instance = null;
        instance.setPositionX(positionX);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPositionY method, of class Sprite.
     */
    @Test
    public void testGetPositionY() {
        System.out.println("getPositionY");
        Sprite instance = null;
        double expResult = 0.0;
        double result = instance.getPositionY();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPositionY method, of class Sprite.
     */
    @Test
    public void testSetPositionY() {
        System.out.println("setPositionY");
        double positionY = 0.0;
        Sprite instance = null;
        instance.setPositionY(positionY);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of render method, of class Sprite.
     */
    @Test
    public void testRender() {
        System.out.println("render");
        GraphicsContext gc = null;
        Sprite instance = null;
        instance.render(gc);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
