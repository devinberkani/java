public class Point {
    private int x;
    private int y;

    public Point() {
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double distance() {
        double xB = 0;
        double yB = 0;
        double xA = this.x;
        double yA = this.y;
        double distance = Math.sqrt((xB - xA) * (xB - xA) + (yB - yA) * (yB - yA));
        return distance;
    }

    public double distance(int x, int y) {
        double xB = x;
        double yB = y;
        double xA = this.x;
        double yA = this.y;
        double distance = Math.sqrt((xB - xA) * (xB - xA) + (yB - yA) * (yB - yA));
        return distance;
    }

    public double distance(Point point) {
        double xB = point.getX();
        double yB = point.getY();
        double xA = this.x;
        double yA = this.y;
        double distance = Math.sqrt((xB - xA) * (xB - xA) + (yB - yA) * (yB - yA));
        return distance;
    }
}

