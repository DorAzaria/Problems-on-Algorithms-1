package turtle_and_hare;

public class Node {

    Node next;
    int id;
    static int unique_id = 0;

    public Node() {
        this.next = null;
        this.id = unique_id++;
    }

    @Override
    public String toString() {
        return "("+this.id+")->";
    }
}
