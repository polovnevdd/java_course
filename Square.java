package area;

public class Square implements Area {
    double side;
    double area;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        area = side * side;
        return area;
    }
}
