public class Rectangle {
    public double height;
    public double width;
    Vector2D position;

    public Rectangle(double height, double width, Vector2D position){
        this.height = height;
        this.width = width;
        this.position = position;
    }
    double top() {
        return this.position.y;
    }
    double bottom() {
        return this.top() + this.height;
    }
    double left() {
        return this.position.x;
    }
    double right() {
        return this.left() + this.width;
    }


    public boolean intersects(Rectangle other){

        return this.right() >= other.left()
                && this.left() <= other.right()
                && this.bottom() >= other.top()
                && this.top() <= other.bottom();

    }
    public static void main(String[] args) {
        Rectangle Gamer = new Rectangle(20, 50, new Vector2D(10, 10));
        Rectangle bullet = new Rectangle(5, 5, new Vector2D(20, 20));
        System.out.println(Gamer.intersects(bullet));
    }

}
