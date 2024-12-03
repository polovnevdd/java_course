public class Cat extends Animals {
    private static int MAX_RUN_DISTANCE = 200;
    static int count = 0;

    public Cat(String name) {
        super(name);
        count++;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public void run(int distance) {
        if (0 <= distance && distance <= MAX_RUN_DISTANCE) {
            System.out.println(name + " пробежал " + distance + "м");
        } else {
            System.out.println(name + " не может пробежать такое расстояние!");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать!");
    }
}
