public class Main {
    public static void main(String[] args) {
        Animals dogBobik = new Dog("Бобик");
        Animals dogRotor = new Dog("Ротор");
        Animals catBublik = new Cat("Бублик");
        Animals catSharik = new Cat("Шарик");
        dogBobik.swim(11);
        dogBobik.run(300);
        dogRotor.run(550);
        catBublik.run(150);
        catSharik.swim(0);
        System.out.println("Количество собак: " + Dog.getCount());
        System.out.println("Количество котов: " + Cat.getCount());
        System.out.println("Количество животных: " + Animals.getAnimalsCount());
    }
}