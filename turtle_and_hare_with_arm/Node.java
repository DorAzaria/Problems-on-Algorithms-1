package turtle_and_hare_with_arm;

public class Node {

    int id;
    static int id_counter = 0;
    Node next;

    public Node() {
        this.next = null;
        this.id = id_counter++;
    }

    @Override
    public String toString() {
        return "("+id+")->" ;
    }
}
