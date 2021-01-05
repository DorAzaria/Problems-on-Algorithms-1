package parking;

public class CircularList {
    Node head, tail;
    int size;

    public CircularList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void add(Node newNode) {
        if(head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
            newNode.prev = tail;
        }else {
            Node current = tail;
            current.next = newNode;
            newNode.prev = current;
            newNode.next = head;
            tail = newNode;
        }
        size++;
    }

    public int size() {
        return this.size;
    }

    public Node getNode(int id) {
        Node current = head;
        while (current != tail) {
            if(current.id == id)
                return current;
            current = current.next;
        }
        if(tail.id == id)
            return tail;
        return null;
    }

    public void print(){
        Node current = head;
        while(current != tail) {
            System.out.print(current.id+"->");
            current = current.next;
        }
        System.out.print(tail.id+"->");
        System.out.println();
    }
}
