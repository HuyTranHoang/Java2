public class Circle extends Shape {

    @Override
    public void draw() {
        System.out.println("Draw trong Circle");
    }

    @Override
    public void erase() {
        System.out.println("Erase trong Circle");
    }

    @Override
    public void move(int x, int y) {
        System.out.printf("Move(%d,%d) trong Circle%n",x,y);
    }
}
