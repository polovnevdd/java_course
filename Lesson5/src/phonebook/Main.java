package phonebook;

import phonebook.Note;
import phonebook.PhoneBook;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add(new Note("Petr", "608418064"));
        phoneBook.add(new Note("Petr", "608949295"));
        phoneBook.add(new Note("Max", "608342153"));
        phoneBook.add(new Note("Arthur", "6087125732"));
        phoneBook.add(new Note("Petr", "0997382380"));
        //phoneBook.print();
        System.out.println(phoneBook.find("Max"));
        System.out.println(phoneBook.findAll("Petr"));
    }
}