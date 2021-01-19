package PlaneProblem;

import java.util.HashSet;
import java.util.Vector;

public class Node {
    int goRight, goDown; // the price for get up (goUpPrice) or right (goRightPrice)
    int entry; // the best price from (0,0) to this node
    int numOfPaths; // number of shortest paths until this node
    int entryFromTheEnd; // same as entry, but from the end to (0,0)
    HashSet<Vector<Node>> myShortestPath;
    int i , j; // used to init the location in the matrix when using generate methods.

    public Node(int i_down, int j_right) {
        this.goDown = i_down;
        this.goRight = j_right;
        entry = 0;
        entryFromTheEnd = 0;
        numOfPaths = 1;
        myShortestPath = new HashSet<>();
        this.i = 0;
        this.j = 0;
    }

    public void setLocation(int mi, int mj) {
        this.i = mi;
        this.j = mj;
    }

    @Override
    public String toString() {
        return "("+i+","+j+")";
    }
}
