/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_3;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Iterator;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author HP
 */
public class LettersTest {

    Letters l;

    public LettersTest() {
    }

    @Test
    public void testEmptySize() {
        l = new Letters();
        assertEquals(0, l.size());
        l = new Letters("");
        assertEquals(0, l.size());
    }

    @Test
    public void testSize() {
        l = new Letters("12345");
        assertEquals(5, l.size());
    }

    @Test
    public void testLettersType() {
        l = new Letters("12345");
        if (!(l.iterator().next() instanceof Character)) {
            fail("Returned value is not a Character");
        }
    }

    @Test
    public void testIteratorNext() {
        Iterator cl = new Letters("123").iterator();
        assertEquals("1", cl.next().toString());
        assertEquals("2", cl.next().toString());
    }

    @Test
    public void testIteratorHasNext() {
        Iterator cl = new Letters("1").iterator();
        assertEquals(true, cl.hasNext());
        cl.next();
        assertEquals(false, cl.hasNext());
        Iterator c2 = new Letters().iterator();
        assertEquals(false, c2.hasNext());
    }

    @Test(expected = Exception.class)
    public void testIteratorException() {
        Iterator<Character> cl = new Letters("12").iterator();
        assertEquals("1", cl.next().toString());
        assertEquals("2", cl.next().toString());
        assertEquals("1", cl.next().toString());
    }

    @Test
    public void testDoubleUsing() {
        l = new Letters("12345");
        int i = 0;
        for (Object c : l) {
            i++;
        }
        for (Object c : l) {
            i++;
        }
        assertEquals(10, i);
    }

    @Test
    public void testRemove() {
        l = new Letters("12345");
        l.removeAll(new Letters("4"));
        assertEquals("12345", l.toString());
    }

//    @Test
//    public void testIllegalIteratorRemove() {
//        l = new Letters("123");
//        Iterator<Character> cl = l.iterator();
//        try {
//            cl.remove();
//        } catch (Exception e) {
//        }
//        assertEquals(3, l.size());
//        cl.next();
//        cl.remove();
//        try {
//            cl.remove();
//        } catch (Exception e) {
//        }
//        assertEquals(2, l.size());
//    }

    @Test
    public void testCorrectRemoving() {
        l = new Letters("qwerty");
        l.retainAll(new Letters("bgtredcv"));
        assertEquals("ert", l.toString());
    }

    @Test
    public void testAdd() {
        l = new Letters("qw");
        l.addAll(new Letters("123"));
        assertEquals("qw123", l.toString());
    }
}
