package fsm.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FsmTest {

    @Test
    public void setFirstNode() {
        Fsm testFsm = new Fsm("FSM for the unit tests");
        Node firstTest = new Node("First test node");

        testFsm.setFirstNode(firstTest);
        assertNotNull(testFsm.getPreviousNodes());
    }

    @Test
    public void getPreviousNodes() {
        Fsm testFsm = new Fsm("FSM for the unit tests");
        Node firstTest = new Node("First test node");

        testFsm.setFirstNode(firstTest);
        assertNotNull(testFsm.getPreviousNodes());
    }

    @Test
    public void setCharacters() {
        Fsm testFsm = new Fsm("FSM for the unit tests");

        testFsm.setCharacters("abba");
        assertEquals(testFsm.getCharacters(), "abba");
    }

    @Test
    public void getCharacters() {
        Fsm testFsm = new Fsm("FSM for the unit tests");

        testFsm.setCharacters("abba");
        assertEquals(testFsm.getCharacters(), "abba");
    }

    @Test
    public void transitions() {
        Fsm testFsm = new Fsm("FSM for the unit tests");
        Node firstTest = new Node("First test node");
        Node secondTest = new Node("Second test node");

        firstTest.addTriggerPoint('0', secondTest);
        firstTest.addTriggerPoint('9', firstTest);

        secondTest.addTriggerPoint('A', firstTest);
        secondTest.addTriggerPoint('B', secondTest);

        testFsm.setFirstNode(firstTest);

        testFsm.setCharacters("0A9B");

        testFsm.transitions();

        List<Node> wantedNodes = new ArrayList<>();
//        Add starting point
        wantedNodes.add(firstTest);
//        Trigger for the 0
        wantedNodes.add(secondTest);
//        Trigger for the A
        wantedNodes.add(firstTest);
//        Trigger for the 9
        wantedNodes.add(firstTest);
//        The trigger B is invalid so program stops

        assertEquals(testFsm.getPreviousNodes(), wantedNodes);
    }

    @Test
    public void readTxtFile() {
        Fsm testFsm = new Fsm("FSM for the unit tests");
        testFsm.readTxtFile("fsmTest.txt");

        assertNotNull(testFsm.getPreviousNodes());
    }
}