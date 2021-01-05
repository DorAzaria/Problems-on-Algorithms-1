package turtle_and_hare;

public class CircularList {

    Node head;
    private int size = 0;

    public CircularList(){
        this.head = null;
    }

    public void add(Node newNode) {
        if(head == null) {
            head = newNode;
            newNode.next = head;
        }
        else {
            Node current = head;
            for(int i = 0 ; i < size-1 ; i++) {
                current = current.next;
            }
            current.next = newNode;
            newNode.next = head;
        }
        size++;
    }

    public int size(){
        return this.size;
    }

    public void print() {
        Node current = head;
        for(int i = 0 ; i < size; i++) {
            System.out.print(current);
            current = current.next;
        }
        System.out.print(current);
        System.out.println();
    }

    public Node getNode(int id) {
        Node current = head;
        for(int i = 0 ; i < size ; i++) {
            if (current.id == id)
                return current;
            current = current.next;
        }
        return null;
    }
}
