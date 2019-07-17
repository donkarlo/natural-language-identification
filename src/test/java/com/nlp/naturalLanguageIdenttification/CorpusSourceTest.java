/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nlp.naturalLanguageIdenttification;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author donkarlo
 */
public class CorpusSourceTest {
    
    public CorpusSourceTest() {
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
     * Test of getDetail method, of class CorpusSource.
     */
    @org.junit.Test
    public void testGetDetail() {
        System.out.println("getDetail");
        CorpusSource instance = null;
        String expResult = "";
        String result = instance.getDetail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getText method, of class CorpusSource.
     */
    @org.junit.Test
    public void testGetText() throws Exception {
        System.out.println("getText");
        CorpusSource instance = null;
        Text expResult = null;
        Text result = instance.getText();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
