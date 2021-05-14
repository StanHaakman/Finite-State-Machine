package fsm;

import fsm.domain.Fsm;
import fsm.domain.Node;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Node s0 = new Node("Node nummer 0");
        Node s1 = new Node("Node nummer 1");
        Node s2 = new Node("Node nummer 2");
        Node s3 = new Node("Node nummer 3");

        s0.addTriggerPoint('A', s2);
        s0.addTriggerPoint('B', s1);

        s1.addTriggerPoint('A', s1);
        s1.addTriggerPoint('B', s2);

        s2.addTriggerPoint('B', s3);

        s3.addTriggerPoint('A', s3);
        s3.addTriggerPoint('B', s0);

        Fsm fsm = new Fsm("Finite State Machine");
        fsm.setFirstNode(s0);

        Scanner myScanner = new Scanner(System.in);
        System.out.println("Vul uw letter reeks in:");

        String letterReeks = myScanner.nextLine();
        fsm.setCharacters(letterReeks);

        fsm.transitions();

        System.out.println(fsm);

        Fsm textBasedFsm = new Fsm("Text based Fsm");

        textBasedFsm.readTxtFile("fsmOpzet.txt");

        System.out.println("Vul uw letter reeks in:");

        letterReeks = myScanner.nextLine();
        textBasedFsm.setCharacters(letterReeks);
        textBasedFsm.transitions();

        System.out.println(textBasedFsm);
    }
}
