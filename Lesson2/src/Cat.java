package animals;

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
        if (distance >= 0 && distance <= MAX_RUN_DISTANCE) {
            System.out.println(String.format(runDist, name, distance));
        } else {
            System.out.println(String.format(errorRunDist, name));
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать!");
    }
}
