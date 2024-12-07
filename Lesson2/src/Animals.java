package animals;

public abstract class Animals {
    String name;
    String runDist = "%s пробежал %d м";
    String swimDist = "%s проплыл %d м";
    String errorRunDist = "%s не может пробежать такое расстояние!";
    String errorSwimDist = "%s не может проплыть такое расстояние!";
    static int count = 0;

    public abstract void run(int distance);

    public abstract void swim(int distance);

    public Animals(String name) {
        this.name = name;
        count++;
    }

    public static int getAnimalsCount() {
        return count;
    }
}
