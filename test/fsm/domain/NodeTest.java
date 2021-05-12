package fsm.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class NodeTest {

    @Test
    public void addTriggerPoint() {
    }

    @Test
    public void getTriggerPoints() {
    }

    @Test
    public void getNext() {
        Node s0 = new Node("Nummer 0");
        Node s1 = new Node("Numemr 1");
        s0.addTriggerPoint('A', s1);
        assertEquals(s1, s0.getNext('A'));
        assertNull(s0.getNext('B'));
    }
}