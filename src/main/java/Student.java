import java.util.ArrayList;

public class Student {
    private String nume;
    private String prenume;
    private String grupa;
    private ArrayList<Integer> note = new ArrayList<Integer>();

    public Student(String n, String p, String g) {
        nume = n;
        grupa = g;

        java.util.Random rand = new java.util.Random();
        for(int i = 0 ; i < 5; i++) {
            note.add(rand.nextInt(4, 11));
        }
    }

    @Override
    public String toString() {
        String s = "Nume: " + nume + "\nPrenume: " + prenume + "\nGrupa: " + grupa + "\nNote: ";
        for(int i = 0; i < 5; i++) {
            s = s.concat(note.get(i) + " ");
        }
        return s;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getGrupa() {
        return grupa;
    }

    public void addNota(int n) {
        note.add(n);
    }

    public ArrayList<Integer> getNote() {
        return note;
    }
}
