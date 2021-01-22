package GeeksforGeeks;

public class SumDigits {

    public static int sum(int sum) {

        int[] numbers = new int[sum+1];
        for(int i = 0 ; i < numbers.length; i++) {
            numbers[i] = i;
        }

        int count = 0;

        for(int i = 1; i < numbers.length; i++) {
            for(int j = 0; j < numbers.length; j++) {
                if(numbers[i] + numbers[j] == sum){
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int sum = 5;
        System.out.println(sum(sum));
    }
}
