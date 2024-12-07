package area;

public class Triangle implements Area {
    double height;
    double side;
    double area;

    public Triangle(double side, double height) {
        this.side = side;
        this.height = height;
    }

    @Override
    public double getArea() {
        area = 0.5 * side * height;
        return area;
    }
}
