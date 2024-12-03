public class Dog extends Animals {
    private static int MAX_RUN_DISTANCE = 500;
    private static int MAX_SWIM_DISTANCE = 10;
    static int count = 0;

    public Dog(String name) {
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
        if (0 <= distance && distance <= MAX_SWIM_DISTANCE) {
            System.out.println(name + " проплыл " + distance + "м");
        } else {
            System.out.println(name + " не может проплыть такое расстояние!");
        }
    }
}
