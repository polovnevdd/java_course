public class Main {
    public static void main(String[] args) {
        Dog dogBobik = new Dog("Бобик");
        Dog dogRotor = new Dog("Ротор");
        Cat catBublik = new Cat("Бублик");
        Cat catSharik = new Cat("Шарик");
        dogBobik.swim(11);
        dogBobik.run(300);
        dogRotor.run(550);
        catBublik.run(150);
        catSharik.swim(0);
        System.out.println("Количество собак: " + Dog.getDogCount());
        System.out.println("Количество котов: " + Cat.getCatCount());
        System.out.println("Количество животных: " + Animals.getAnimalsCount());
    }
}