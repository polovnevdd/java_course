package phonebook;

public class Note {
    private String name;
    private String phone;

    public Note(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String toString() {
        return name + " " + phone;
    }
}
