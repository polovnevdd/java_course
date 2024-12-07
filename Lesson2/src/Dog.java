package animals;

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
        if (distance >= 0 && distance <= MAX_RUN_DISTANCE) {
            System.out.println(String.format(runDist, name, distance));
        } else {
            System.out.println(String.format(errorRunDist, name));
        }
    }

    @Override
    public void swim(int distance) {
        if (distance >= 0 && distance <= MAX_SWIM_DISTANCE) {
            System.out.println(String.format(swimDist, name, distance));
        } else {
            System.out.println(String.format(errorSwimDist, name));
        }
    }
}
