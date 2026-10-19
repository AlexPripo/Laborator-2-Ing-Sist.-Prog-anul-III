import java.util.Comparator;

public class ByGradesComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if(o1.medie() == o2.medie()) {
            return 0;
        }

        return o1.medie() < o2.medie() ? 1 : -1;
    }
}