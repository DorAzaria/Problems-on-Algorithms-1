package HareAndTortoise;

public class HareAndTortoiseProblem {

    public static boolean isCycled(CircularList list) {
        if(list.head == null)
            return false;
        Node turtle = list.head;
        Node hare = list.head;

        while(hare.next.next != null) {
            hare = hare.next.next;
            turtle = turtle.next;
            if(hare == turtle)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        CircularList list = new CircularList();

        for(int i = 0 ; i < 8 ; i++)
            list.add(new Node());

        list.print();
        System.out.println(isCycled(list));
        list.getNode(7).next = null;
        System.out.println(isCycled(list));

    }
}
