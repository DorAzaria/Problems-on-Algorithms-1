package PlaneProblem;

import java.util.HashSet;
import java.util.Vector;

public class Node {
    int goRight, goDown; // the price for get up (goUpPrice) or right (goRightPrice)
    int entry; // the best price from (0,0) to this node
    int numOfPaths; // number of shortest paths until this node
    int entryFromTheEnd; // same as entry, but from the end to (0,0)
    HashSet<Vector<Node>> myShortestPath;

    public Node(int i, int j) {
        this.goDown = i;
        this.goRight = j;
        entry = 0;
        entryFromTheEnd = 0;
        numOfPaths = 1;
        myShortestPath = new HashSet<>();
    }

    @Override
    public String toString() {
        return "(entry: " + this.entry+")-> ";
    }
}
