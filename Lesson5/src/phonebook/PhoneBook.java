package phonebook;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
    private List<Note> notes;

    public PhoneBook() {
        this.notes = new ArrayList<>();
    }

    public void add(Note note) {
        notes.add(note);
    }

    public Note find(String name) {
        for (Note note : notes) {
            if (note.getName().equals(name)) {
                return note;
            }
        }
        return null;
    }

    public List<Note> findAll(String name) {
        List<Note> allFounded = new ArrayList<>();
        for (Note note : notes) {
            if (note.getName().equals(name)) {
                allFounded.add(note);
            }
        }
        if (allFounded.isEmpty()) {
            return null;
        }
        return allFounded;
    }

    public void print() {
        for (Note note : notes) {
            System.out.println(note);
        }
    }
}
