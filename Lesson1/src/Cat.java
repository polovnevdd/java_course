public class Cat extends Animals{
    int maxRunDistance = 200;
    int maxSwimDistance = 0;
    String getName;
    static int catCount = 0;
    public Cat(String name){
        getName = name;
        catCount++;
    }
    public static int getCatCount(){
        return catCount;
    }
    @Override
    public void run(int distance){
        if(distance <= maxRunDistance){
            System.out.println(getName + " пробежал " + distance + "м");
        }else{
            System.out.println(getName + " не может пробежать такое расстояние!");
        }
    }
    @Override
    public void swim(int distance){
        if(distance <= maxSwimDistance){
            System.out.println(getName + " проплыл " + distance + "м");
        }else{
            System.out.println(getName + " не умеет плавать!");
        }
    }
}
