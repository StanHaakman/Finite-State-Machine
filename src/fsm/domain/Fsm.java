package fsm.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Fsm {
    private String name;
    private String characters;
    private List<Node> previousNodes = new ArrayList<>();

    public Fsm(String name) {
        this.name = name;
    }

    public void setFirstNode(Node firstNode) {
        this.previousNodes.add(firstNode);
    }

    public void setCharacters(String characters) {
        this.characters = characters;
    }

    public void transitions () {
        for (char trigger : this.characters.toUpperCase(Locale.ROOT).toCharArray()) {
            Node current = previousNodes.get(previousNodes.size() - 1);
            Node next = current.getNext(trigger);
            if (next == null) {
                break;
            }
            this.previousNodes.add(next);
        }
    };

    @Override
    public String toString() {
        return "Fsm { " +
                "name='" + name + '\'' +
                ", characters='" + characters + '\'' +
                ", previousNodes= \n" + previousNodes +
                '}';
    }
}
