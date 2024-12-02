public abstract class Animals {

    public abstract void run(int distance);
    public abstract void swim(int distance);
    public static int getAnimalsCount(){
        return Dog.getDogCount() + Cat.getCatCount();
    }
}
