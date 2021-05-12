package fsm.domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLSyntaxErrorException;
import java.util.*;
import java.util.regex.PatternSyntaxException;

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

    public void readTxtFile() {
        try {
            Map<String, Node> nodes= new HashMap<>();
            File myFile = new File("fsmOpzet.txt");
            System.out.println(myFile.getName() + " Gebruiken om de Fsm op te zetten");

            Scanner myReader = new Scanner(myFile);

//            Skip the first line of the document. This is for convention
            if (myReader.hasNextLine()) {
                myReader.nextLine();
            }
            while (myReader.hasNextLine()) {
                String textData = myReader.nextLine();

//                Check if the next line is empty
                if (textData.startsWith("//")) {
                    break;
                } else if (textData.isBlank()) {
//                    Empty lines are skipped
                    continue;
                }
                String[] nodeValues = textData.split(",");
//                Check for valid input data
                if (nodeValues.length != 2) {
                    System.out.println("Geen juiste syntaxt in het textbestand. Lees nogmaals je readme.md voor de juiste syntax.");
                    System.exit(0);
                }
                nodes.put(nodeValues[0], new Node(nodeValues[1]));
            }

            System.out.println(nodes);

            while (myReader.hasNextLine()) {
                String textData = myReader.nextLine();
                System.out.println(textData);

                String[] transitionValues = textData.split(">");
                Node targetNode = nodes.get(transitionValues[0]);
                System.out.println(transitionValues[2].charAt(0));
                targetNode.addTriggerPoint(transitionValues[2].charAt(0), nodes.get(transitionValues[1]));
            }

//            Set starting point
            this.previousNodes.add((Node) nodes.values().toArray()[0]);
            System.out.println(previousNodes);
        } catch (FileNotFoundException e) {
            System.out.println("File niet gevonden");
        }

    }

    @Override
    public String toString() {
        return "Fsm { " +
                "name='" + name + '\'' +
                ", characters='" + characters + '\'' +
                ", previousNodes= \n" + previousNodes +
                '}';
    }
}
