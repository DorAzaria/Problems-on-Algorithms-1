package parking;

public class Node {

    String signed;
    Node next,prev;
    static int id_counter = 0;
    int id;
    public Node() {
        this.signed = "null";
        this.next = null;
        this.prev = null;
        this.id = id_counter++;
    }

    @Override
    public String toString() {
        return "{id=" + id +
                ", next= " + this.next.id +
                ", prev= " + this.prev.id +
                ", signed= " + signed + "}->\n";
    }
}
