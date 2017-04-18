/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_3;

import java.util.Iterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vlad
 */
public class LettersTest {
    
    public LettersTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of toString method, of class Letters.
     */
    @Test
    public void testToString() {
         Letters l = new Letters("lalala");
        assertEquals("lalala", l.toString());

        l.setStr("letter collection");
        assertEquals("letter collection", l.toString());
    }

    /**
     * Test of clear method, of class Letters.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        Letters l = new Letters("lalala");
        l.clear();
        assertEquals("",l.getStr() );
    }

    /**
     * Test of retainAll method, of class Letters.
     */
    @Test
    public void testRetainAll() {
         System.out.println("retainAll");
        Letters l = new Letters();
        l.setStr("letter collection");
        l.retainAll("lr");
        assertEquals("lrll", l.getStr());
    }

    /**
     * Test of addAll method, of class Letters.
     */
    @Test
    public void testAddAll() {
         System.out.println("addAll");
        Letters l = new Letters() {};
        l.setStr("letter collection");
        l.addAll(" lalala");
        assertEquals("letter collection lalala", l.getStr());
    }

    /**
     * Test of containsAll method, of class Letters.
     */
    @Test
    public void testContainsAll() {
       System.out.println("containsAll");
        Letters l = new Letters();
        l.setStr("letter");
        assertEquals(false, l.containsAll("lets"));
        assertEquals(true, l.containsAll("letter"));
    }

    /**
     * Test of removeAll method, of class Letters.
     */
    @Test
    public void testRemoveAll() {
         System.out.println("removeAll");
        Letters l = new Letters();
        l.setStr("letter collection");
        l.removeAll("lr");
        assertEquals("", l.getStr());
    }

    /**
     * Test of remove method, of class Letters.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        Letters l = new Letters();
        l.setStr("letter collection");
        l.remove('l');
        assertEquals("etter coection", l.toString());
    }

    /**
     * Test of add method, of class Letters.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Letters l = new Letters();
        l.setStr("letter collection");
        l.add('s');
        assertEquals("letter collections", l.toString());
    }

    /**
     * Test of toArray method, of class Letters.
     */
    @Test
    public void testToArray() {
         System.out.println("toArray");
        Letters l = new Letters();
        l.setStr("let");
        Character[] arr = new Character[]{'l','e','t'};
        Assert.assertArrayEquals(arr, l.toArray());
    }

    /**
     * Test of contains method, of class Letters.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        Letters l = new Letters();
        l.setStr("letter collection");
        assertEquals(false, l.contains('k'));
        assertEquals(true, l.contains('l'));
    }

    /**
     * Test of isEmpty method, of class Letters.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        Letters l = new Letters();
        l.setStr("");
        assertEquals(true, l.isEmpty());
        l.setStr("lalala");
        assertEquals(false, l.isEmpty());
    }

    /**
     * Test of size method, of class Letters.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        Letters l = new Letters("lalala") {};
        assertEquals(6, l.size());
        l.setStr("letter collection");
        assertEquals(17, l.size());
    }

    /**
     * Test of iterator method, of class Letters.
     */
    @Test
    public void testIteratorNext() {
       System.out.println("iteratorNext");
       Iterator l1 = new Letters("lalala").iterator();
       assertEquals("l",l1.next().toString());
       
    }
    @Test
    public void testIteratorHasNext() {
       System.out.println("iteratorHasNext");
       Iterator l1 = new Letters("l").iterator();
       assertEquals(true,l1.hasNext());
       l1.next();
       assertEquals(false,l1.hasNext());
       
    }
    
}
