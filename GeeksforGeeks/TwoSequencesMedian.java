package GeeksforGeeks;

public class TwoSequencesMedian {
    //find the median of two sorted array such that |A| != |B| in logn
    public double BinarySearchMedian(int A[], int B[]) {
        if (B.length < A.length) return BinarySearchMedian(B, A);
        int maxLeftA = -1, minRightA = -1, maxLeftB = -1, minRightB = -1;
        int a = A.length;
        int b = B.length;
        // find the current partition such that ai < ai+1 and bi < ai+1 and ai < bi+1
        int low = 0, high = a;
        while (low <= high) {

            int partitionOfA = (low + high) / 2;
            int partitionOfB = (a + b + 1) / 2 - partitionOfA;

            //check if the partition of A is valid
            if (partitionOfA == 0) {
                maxLeftA = (Integer.MIN_VALUE);
            } // its means that is no left side of A
            else {
                maxLeftA = A[partitionOfA - 1];
            }
            if (partitionOfA == a) {
                minRightA = (Integer.MAX_VALUE);
            } // its means that is no right side of A
            else {
                minRightA = A[partitionOfA];

                //check if the partition of B is valid
                if (partitionOfB == 0) {
                    maxLeftB = (Integer.MIN_VALUE);
                } // its means that is no left side of B
                else {
                    maxLeftB = B[partitionOfB - 1];
                }
                if (partitionOfB == b) {
                    minRightB = (Integer.MAX_VALUE);
                } // its means that is no right side of B
                else {
                    minRightB = B[partitionOfB];
                }

                // check if this is the correct partition
                if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                    //check if the length is even
                    if (a + b % 2 == 0) {
                        return ((double) Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2;
                    } else return (double) Math.max(maxLeftA, maxLeftB);
                }
                // if the term fail - its means that this is not the correct position
                else if (maxLeftA > minRightB) high = partitionOfA - 1;
                else low = partitionOfA + 1;
            }
        }
        return -1;

    }
}

