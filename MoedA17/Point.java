package MoedA17;

public class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;

    }

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }
}