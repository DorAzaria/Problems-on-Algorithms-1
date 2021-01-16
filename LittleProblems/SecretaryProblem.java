package LittleProblems;

import java.util.Arrays;

public class SecretaryProblem {

    public static double getAverageTime(int[] times) {
        Arrays.sort(times);
        double avg = 0;

        for(int i = 0 ; i < times.length ; i++){

            double temp_avg = 0;

            for(int j = 0 ; j <= i ; j++) {
                temp_avg += times[j];
            }
            avg += temp_avg;
        }

        return avg/times.length;
    }

    public static void main(String[] args) {
        System.out.println(getAverageTime(new int[]{10,1,8}));
    }
}
