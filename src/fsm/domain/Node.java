package fsm.domain;

import java.util.*;

public class Node {
    private String name;
    private Map<Character, Node> triggerPoints = new HashMap<>();

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
        return "Node [" + name + ']';
    }

    public Node getNext(char trigger) {
        return triggerPoints.getOrDefault(trigger, null);
    }

    public void setTriggerPoints(Map<Character, Node> triggerPoints) {
        this.triggerPoints = triggerPoints;
    }
}
