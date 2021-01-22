package MoedA17;

import java.util.HashSet;
import java.util.Vector;

public class Q1 {

    Point A;
    Node[][] nodes;

    public Q1(Node[][] nodes, Point A) {
        this.nodes = nodes;
        this.A = A;
    }

    public boolean belongsToCheapestPath(){
        generate(); // O(N*M)
        HashSet<Vector<Node>> path = new HashSet<>();
        getPath(nodes.length-1,nodes[0].length-1,path,new Vector<>()); // O( (N+M)*P )

        for(Vector<Node> vector : path) { // O ( ? )
            if(vector.contains(nodes[A.x()][A.y()])) // O( a path size )
                return true;
        }
        return false;
    }

    public void getPath(int i, int j, HashSet<Vector<Node>> set, Vector<Node> vec) {
        vec.add(nodes[i][j]);
        if(i == 0 && j == 0) {
            set.add(vec);
            return;
        }
        if(i == 0) {
            getPath(i,j-1,set,vec);
        }
        else if(j == 0) {
            getPath(i-1,j,set,vec);
        } else {
            int fromAbove = nodes[i-1][j].price + nodes[i-1][j].y;
            int fromLeft = nodes[i][j-1].price + nodes[i][j-1].x;

            if(fromAbove > fromLeft) {
                getPath(i,j-1,set,vec);
            } else if(fromAbove < fromLeft) {
                getPath(i-1,j,set,vec);
            } else {
                getPath(i,j-1,set,new Vector<>(vec));
                getPath(i-1,j,set,new Vector<>(vec));
            }
        }
    }

    private void generate() {
        for(int i = 1; i < this.nodes.length; i++) { // O(N)
            this.nodes[i][0].price = nodes[i-1][0].price + nodes[i-1][0].y;
        }
        for(int i = 1; i < this.nodes[0].length; i++) { // O(M)
            this.nodes[0][i].price = nodes[0][i-1].price + nodes[0][i-1].x;
        }
        for(int i = 1 ; i < nodes.length; i++) { // O(N*M)
            for(int j = 1; j < nodes[0].length; j++) {
                int fromAbove = nodes[i-1][j].price + nodes[i-1][j].y;
                int fromLeft = nodes[i][j-1].price + nodes[i][j-1].x;
                nodes[i][j].price = Math.min(fromAbove,fromLeft);
            }
        }
    }
}
