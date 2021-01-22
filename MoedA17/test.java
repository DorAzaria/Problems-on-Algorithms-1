package MoedA17;

public class test {

    public static Node[][] test1Q1() {
        Node[][] nodes = new Node[4][4];
        nodes[0][0] = new Node(1,3);
        nodes[0][1] = new Node(8,4);
        nodes[0][2] = new Node(3,8);
        nodes[0][3] = new Node(0,4);
        nodes[1][0] = new Node(2,5);
        nodes[1][1] = new Node(5,11);
        nodes[1][2] = new Node(3,1);
        nodes[1][3] = new Node(0,2);
        nodes[2][0] = new Node(4,10);
        nodes[2][1] = new Node(3,1);
        nodes[2][2] = new Node(1,4);
        nodes[2][3] = new Node(0,8);
        nodes[3][0] = new Node(2,0);
        nodes[3][1] = new Node(3,0);
        nodes[3][2] = new Node(5,0);
        nodes[3][3] = new Node(0,0);
        return nodes;
    }

    public static void main(String[] args) {

        System.out.println("Q1 =========");
        Node[][] nodes = test1Q1();
        Q1 q1 = new Q1(nodes,new Point(1,1));
        System.out.println(q1.belongsToCheapestPath()); // true
        q1.A = new Point(0,0);
        System.out.println(q1.belongsToCheapestPath()); // true
        q1.A = new Point(3,3);
        System.out.println(q1.belongsToCheapestPath()); // true
        q1.A = new Point(3,0);
        System.out.println(q1.belongsToCheapestPath()); // false
        q1.A = new Point(1,3);
        System.out.println(q1.belongsToCheapestPath()); // false
        ////////////////////////////////////////
        System.out.println("Q2 =========");

        System.out.println(Q2.longestSubseqWithDiffOne(new int[]{1,2,3,4,3,2})); // 6
        System.out.println(Q2.longestSubseqWithDiffOne(new int[]{10,9,4,5,4,8,6})); // 3
        System.out.println(Q2.longestSubseqWithDiffOne(new int[]{100})); // 1
        System.out.println(Q2.longestSubseqWithDiffOne(new int[]{8, 5, 6, 4, 5, 4, 6, 2, 6, 4, 2, 1, 4, 4, 2, 5, 7, 8, 7, 2})); // 8
        System.out.println(Q2.longestSubseqWithDiffOne(new int[]{1,2,1})); // 3
        System.out.println(Q2.longestSubseqWithDiffOne(new int[]{6, 16, 19, 9, 18, 18, 3, 5, 13, 12, 19, 13, 13, 3, 3, 7, 19, 1, 11, 16})); // 5

        ////////////////////////////////////////
        System.out.println("Q3 =========");
        System.out.println("LIS");
        System.out.println(Q3.lis(new int[]{1,11,2,10,4,5,2,1})); // 4
        System.out.println(Q3.lis(new int[]{8,1,100,101,2,3,4,102,100,101,50}));// 6
        System.out.println(Q3.lis(new int[]{0, 1, 101, 9, 10, 11, 2, 3, 100, 4, -1, 5, 6})); // 7
        System.out.println(Q3.lis(new int[]{1, 2, 9, 13, 15, 17, 24, 26, 35, 37})); // 10
        System.out.println("LDS");
        System.out.println(Q3.lds(new int[]{1,11,2,10,4,5,2,1})); // 5
        System.out.println(Q3.lds(new int[]{8,1,100,101,2,3,4,102,100,101,50})); // 3
        System.out.println(Q3.lds(new int[]{0, 1, 101, 9, 10, 11, 2, 3, 100, 4, -1, 5, 6})); // 4
        System.out.println(Q3.lds(new int[]{1, 2, 9, 13, 15, 17, 24, 26, 35, 37})); // 1
        System.out.println("LBS");
        System.out.println(Q3.lbs(new int[]{1,11,2,10,4,5,2,1})); // 6
        System.out.println(Q3.lbs(new int[]{8,1,100,101,2,3,4,102,100,101,50})); // 7
        System.out.println(Q3.lbs(new int[]{0, 1, 101, 9, 10, 11, 2, 3, 100, 4, -1, 5, 6})); // 8
        System.out.println(Q3.lbs(new int[]{1, 2, 9, 13, 15, 17, 24, 26, 35, 37})); // 10
    }
}
