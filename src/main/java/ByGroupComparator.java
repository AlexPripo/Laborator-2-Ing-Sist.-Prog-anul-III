import java.util.Comparator;

public class ByGroupComparator implements Comparator<Student> {
    @Override

    public int compare(Student o1, Student o2) {
        int comp1 = o1.getGrupa().compareTo(o2.getGrupa());
        if(comp1 == 0) {
            int comp2 = o1.getNume().compareTo(o2.getNume());
            if(comp2 == 0) {
                return o1.getPrenume().compareTo(o2.getPrenume());
            }
            return comp2;
        }
        return comp1;
    }
}
