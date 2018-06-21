package Singleton;

public class Point {
    private int point = 0;
    private static Point instance = null;

    public static Point Instance() {
        if(instance == null) {
            instance = new Point();
        }
        return instance;
    }

    public static void Deinit() {
        if(instance != null) {
            instance = null;
        }
    }

    public int getPoint() {
        return point;
    }

    public void add(int i) {
        point += i;
    }

    public void minus(int i) {
        point -= i;
    }

}
