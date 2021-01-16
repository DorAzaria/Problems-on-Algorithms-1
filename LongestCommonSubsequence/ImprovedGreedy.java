package LongestCommonSubsequence;

public class ImprovedGreedy {

    public static String improvedGreedy(String x,String y) {
        int[] occurrences = new int[26];

        for (int i = 0; i < y.length(); i++)
            occurrences[y.charAt(i)-'a']++;

        String answer = "";
        int limit = 0;

        for(int i = 0; i < x.length(); i++) {
            int place = (x.charAt(i)-'a');
            if(occurrences[place]>0) {
                int index = y.indexOf(x.charAt(i),limit);
                if(index != -1) {// if the char does occur
                    answer += x.charAt(i);
                    limit = index + 1; // reduce the limit
                    occurrences[place]--;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        String X = "cbab", Y = "ababcb";
        System.out.println(improvedGreedy(X,Y));
    }
}
