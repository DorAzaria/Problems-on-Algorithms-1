package turtle_and_hare_with_arm;

public class TurtleAndHareWithArm {

    static Node theKiss = null;

    public static boolean isCycled(LinkedList list) {
        if(list.head == null)
            return false;

        Node hare = list.head;
        Node turtle = list.head;

        while (hare.next.next != null) {
            hare = hare.next.next;
            turtle = turtle.next;
            if(hare == turtle) {
                theKiss = hare;
                return true;
            }
        }

        return false;
    }

    public static int lengthOfArm(LinkedList list) {
        if(list.head == null)
            return 0;

        int counter = 0;
        Node turtle = theKiss;
        Node hare = list.head;

        while (hare.next != null) {
            if (turtle != null) {
                turtle = turtle.next;
            }
            counter++;
            hare = hare.next;
            if(hare == turtle) {
                return counter;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        for(int i = 0 ; i < 6 ; i++)
            list.add(new Node());

        list.print();
        System.out.println("isCycled?: " + isCycled(list) + ", arm length: "+lengthOfArm(list));
        list.tail.next = list.getNode(2);
        System.out.println("isCycled?: " + isCycled(list) + ", arm length: "+lengthOfArm(list));
    }
}
