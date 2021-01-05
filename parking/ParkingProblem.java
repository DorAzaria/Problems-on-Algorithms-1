package parking;
// we need to count how many cars there is in the circular parking lot.
// we'll mark a visited car as 'V', if we'll see another mark v without any other
// strange mark so we're done, else, we'll keep count the cars and mark the relevant.
public class ParkingProblem {

    public static int solution(CircularList list) {
        if(list.head == null)
            return 0;

        Node current = list.head;
        current.signed = "v";
        int current_counter = 1;
        int main_counter = 0;
        boolean flag = false;

        while(!flag) {

            while (!current.next.signed.equals("v")) {
                current_counter++;
                current = current.next;
            }
            current.next.signed = "w";
            current_counter++;
            main_counter = current_counter;
            while (current_counter != 0) {
                current_counter--;
                current = current.prev;
            }
            if(current.signed.equals("w")) {
                flag = true;
            }
        }

        return main_counter;
    }


    public static void main(String[] args) {
        CircularList list = new CircularList();
        list.add(new Node());
        list.add(new Node());
        list.add(new Node());
        list.add(new Node());
        list.add(new Node());
        list.getNode(1).signed = "v";
        list.getNode(3).signed = "v";
        list.print();
        System.out.println(solution(list));
    }
}
