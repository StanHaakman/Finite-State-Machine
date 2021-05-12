package fsm.domain;

import java.util.*;

public class Node {
    private String name;
    private Map<Character, Node> triggerPoints = new HashMap<Character, Node>();

    public Node(String name) {
        this.name = name;
    }

    public void addTriggerPoint(char trigger, Node node) {
        this.triggerPoints.put(trigger, node);
    }

    public Map<Character, Node> getTriggerPoints() {
        return triggerPoints;
    }

    @Override
    public String toString() {
        return "Node [" +
                "Naam: '" + name + '\'' +
                ' ' + triggerPoints.keySet() +
                ']';
    }

    public Node getNext(char test) {
        return triggerPoints.getOrDefault(test, null);
    }
}
