public class Rectangle extends Quad {
    @Override
    public void draw() {
        System.out.println("Draw trong Rectangle");
    }

    @Override
    public void erase() {
        System.out.println("Erase trong Rectangle");
    }

    @Override
    public void move(int x, int y) {
        System.out.printf("Move(%d,%d) trong Rectangle%n",x,y);
    }
}
