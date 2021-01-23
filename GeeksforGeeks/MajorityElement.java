package GeeksforGeeks;

public class MajorityElement {
    /**
     * Majority Element in array
     * Complexity: O(n)
     */
    public static double majority(double[] arr) {
        int count = 1;
        double majority = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] == majority) {
                count++;
            }
            else {
                count--;
                if(count == 0) {
                    majority = arr[i];
                    count = 1;
                }
            }
        }
        count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == majority) {
                count++;
            }
        }
        if(count > arr.length/2) return majority;
        return Double.NEGATIVE_INFINITY;
    }

    public static void main(String[] args) {
        /// tt
        System.out.println(majority(new double[] {3,3,4,2,4,4,2,4,4}));
        System.out.println(majority(new double[] {3,3,4,2,4,4,2,4}));
    }
}
