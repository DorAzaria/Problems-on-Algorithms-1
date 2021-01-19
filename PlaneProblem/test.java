package PlaneProblem;

public class test {

    public static Node[][] getTest1() {
        Node[][] mat = new Node[4][4];
        mat[0][0] = new Node(3,1);
        mat[0][1] = new Node(4,8);
        mat[0][2] = new Node(8,3);
        mat[0][3] = new Node(4,0);
        mat[1][0] = new Node(5,2);
        mat[1][1] = new Node(11,5);
        mat[1][2] = new Node(1,3);
        mat[1][3] = new Node(2,0);
        mat[2][0] = new Node(10,4);
        mat[2][1] = new Node(1,3);
        mat[2][2] = new Node(4,1);
        mat[2][3] = new Node(8,0);
        mat[3][0] = new Node(0,5);
        mat[3][1] = new Node(0,3);
        mat[3][2] = new Node(0,5);
        mat[3][3] = new Node(0,0);
        return mat;
    }

    public static Node[][] getTest2() {
        Node[][] mat = new Node[4][4];
        mat[0][0] = new Node(3, 0);
        mat[0][1] = new Node(4, 1);
        mat[0][2] = new Node(7, 2);
        mat[0][3] = new Node(1, 0);
        mat[1][0] = new Node(5, 2);
        mat[1][1] = new Node(11, 5);
        mat[1][2] = new Node(1, 3);
        mat[1][3] = new Node(2, 0);
        mat[2][0] = new Node(4, 4);
        mat[2][1] = new Node(1, 3);
        mat[2][2] = new Node(4, 1);
        mat[2][3] = new Node(2, 0);
        mat[3][0] = new Node(0, 5);
        mat[3][1] = new Node(0, 3);
        mat[3][2] = new Node(0, 5);
        mat[3][3] = new Node(0, 0);
        return mat;
    }

    public static Node[][] getTest3() {
        Node[][] mat = new Node[4][4];
        mat[0][0] = new Node(1, 5);
        mat[0][1] = new Node(4, 3);
        mat[0][2] = new Node(7, 5);
        mat[0][3] = new Node(3, 0);
        mat[1][0] = new Node(2, 2);
        mat[1][1] = new Node(11, 5);
        mat[1][2] = new Node(1, 3);
        mat[1][3] = new Node(5, 0);
        mat[2][0] = new Node(2, 4);
        mat[2][1] = new Node(1, 3);
        mat[2][2] = new Node(4, 1);
        mat[2][3] = new Node(4, 0);
        mat[3][0] = new Node(0, 0);
        mat[3][1] = new Node(0, 1);
        mat[3][2] = new Node(0, 2);
        mat[3][3] = new Node(0, 0);
        return mat;
    }
}
