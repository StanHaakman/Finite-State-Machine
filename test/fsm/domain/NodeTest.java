package fsm.domain;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class NodeTest {

    @Test
    public void addTriggerPoint() {
        Node s0 = new Node("Test trigger points");
        s0.addTriggerPoint('A', s0);

//        Create a map with the desired result
        Map<Character, Node> desiredResult = new HashMap<>();
        desiredResult.put('A', s0);

        assertEquals(s0.getTriggerPoints(), desiredResult);
    }

    @Test
    public void getTriggerPoints() {
        Node s0 = new Node("Test trigger points");
        s0.addTriggerPoint('A', s0);

//        Create a map with the desired result
        Map<Character, Node> desiredResult = new HashMap<>();
        desiredResult.put('A', s0);

        assertEquals(s0.getTriggerPoints(), desiredResult);
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