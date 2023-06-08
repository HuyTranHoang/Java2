public class Triangle extends Shape {
    @Override
    public void draw() {
        System.out.println("Draw trong Triangle");
    }

    @Override
    public void erase() {
        System.out.println("Erase trong Triangle");
    }

    @Override
    public void move(int x, int y) {
        System.out.printf("Move(%d,%d) trong Triangle%n",x,y);
    }
}
