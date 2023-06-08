public class Quad extends Shape {

    @Override
    public void draw() {
        System.out.println("Draw trong Quad");
    }

    @Override
    public void erase() {
        System.out.println("Erase trong Quad");
    }

    @Override
    public void move(int x, int y) {
        System.out.printf("Move(%d,%d) trong Quad%n",x,y);
    }
}
