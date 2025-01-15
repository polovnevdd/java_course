package practiceoflists;

public class WordOccurrence {
    private String name;
    private int count;

    public WordOccurrence(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String toString() {
        return "name: " + name + " count: " + count;
    }
}
