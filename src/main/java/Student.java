import java.util.ArrayList;

public class Student {
    private String nume;
    private String prenume;
    private String grupa;
    private ArrayList<Integer> note = new ArrayList<Integer>();

    public Student(String n, String p, String g) {
        nume = n;
        prenume = p;
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

    public int medie() {
        Double medie = (double) 0;
        for(Integer i: this.note) {
            medie += i;
        }
        medie /= note.size();

        return (int) Math.round(medie);
    }

    public boolean esteIntegralist() {
        boolean integralist = true;
        for(Integer i : note) {
            if (i < 5) {
                integralist = false;
                break;
            }
        }
        return integralist;
    }

    public int getNrRestante() {
        int contor = 0;
        for(Integer i : note) {
            if(i < 5) {
                contor++;
            }
        }

        return contor;
    }
}
