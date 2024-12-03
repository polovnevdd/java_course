public abstract class Animals {
    String name;
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
