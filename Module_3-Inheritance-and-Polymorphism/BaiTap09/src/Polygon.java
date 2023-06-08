public class Polygon extends Shape {
    @Override
    public void draw() {
        System.out.println("Draw trong Polygon");
    }

    @Override
    public void erase() {
        System.out.println("Erase trong Polygon");
    }

    @Override
    public void move(int x, int y) {
        System.out.printf("Move(%d,%d) trong Polygon%n",x,y);
    }
}
