public class Dog extends Animals{
    int maxRunDistance = 500;
    int maxSwimDistance = 10;
    String getName;
    static int dogCount = 0;
    public Dog(String name){
        getName = name;
        dogCount++;
    }
    public static int getDogCount(){
     return dogCount;
    }
    @Override
    public void run(int distance){
        if(0 <= distance && distance<= maxRunDistance){
            System.out.println(getName + " пробежал " + distance + "м");
        }else{
            System.out.println(getName + " не может пробежать такое расстояние!");
        }
    }
    @Override
    public void swim(int distance){
        if(0 <= distance && distance <= maxSwimDistance){
            System.out.println(getName + " проплыл " + distance + "м");
        }else{
            System.out.println(getName + " не может проплыть такое расстояние!");
        }
    }
}
