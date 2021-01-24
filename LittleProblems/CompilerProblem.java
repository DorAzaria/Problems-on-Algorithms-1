package LittleProblems;

public class CompilerProblem {
    public static void getOptimalOrder(nodeData[] programs){
        mergeSort(programs,0,programs.length);
        //ממינים לפי זמן חלקי תדירות. כי זה המדד שביקשו ממנו
        int totalTime = 0;
        int totalTimeReturn = 0;

        int temp = 0;
        //בדיוק כמו בעית המזכירה
        for (int i = 0; i < programs.length; i++) {
            System.out.println(programs[i]);
            totalTimeReturn += (totalTime+programs[i].lengthInt);
            totalTime +=programs[i].lengthInt;

        }
        System.out.println("total time : "+totalTimeReturn);
    }
    private static void mergeSort(nodeData[] p, int low, int high) {
        int n = high - low;
        if(n <= 1) return;
        int mid = (low + high)/2;
        mergeSort(p,low,mid);
        mergeSort(p,mid,high);
        int i = low, j = mid, k = 0;
        nodeData[] temp = new nodeData[n];
        while(i<mid && j<high) {
            double t1 = (double) p[i].freq/p[i].lengthInt;
            double t2 = (double)p[j].freq/p[j].lengthInt;

//ממיין מהגדול לקטן
            if(t1 > t2) temp[k++] = p[i++];
            else temp[k++] = p[j++];
        }
        while(i<mid) temp[k++] = p[i++];
        while(j<high) temp[k++] = p[j++];
        for (int l = 0; l < n; l++) {
            p[low + l] = temp[l];
        }
    }

    public static void main(String[] args) {
        nodeData a = new nodeData("one",5,2);
        nodeData b = new nodeData("two", 2,5);
        nodeData c = new nodeData("therd", 7,3);
        nodeData d = new nodeData("for", 11,2);
        nodeData[] p = {a,c,b,d};
        getOptimalOrder(p);


    }
}







