package HareAndTortoiseWithArm;

public class LinkedList {

    Node head, tail;
    int size;

    public LinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void add(Node newNode){
        if(head == null) {
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next = newNode;
            tail = tail.next;
        }
        size++;
    }

    public int size(){
        return size;
    }

    public void print() {
        Node current = head;
        while (current != tail) {
            System.out.print(current);
            current = current.next;
        }
        System.out.print(current);
        System.out.println();
    }

    public Node getNode(int id) {
        Node current = head;
        if(tail.id == id)
            return tail;

        while (current != tail) {
            if(current.id == id)
                return current;
            current = current.next;
        }
        return null;
    }
}

