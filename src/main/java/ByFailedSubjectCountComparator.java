import java.util.Comparator;

public class ByFailedSubjectCountComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        if(o1.getNrRestante() == o2.getNrRestante()) {
            return 0;
        }

        return o1.getNrRestante() > o2.getNrRestante() ? 1 : -1;
    }
}
