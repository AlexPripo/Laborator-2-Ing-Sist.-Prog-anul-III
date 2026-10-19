import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public void ex1() {
        List<Integer> x = new ArrayList();
        List<Integer> y = new ArrayList();
        List<Integer> xPlusY = new ArrayList(); //a
        Set<Integer> zSet = new TreeSet(); //b
        List<Integer> xMinusY = new ArrayList();//c
        int p = 4;
        List<Integer> xPlusYLimitedByP = new ArrayList(); //d

        java.util.Random rand = new java.util.Random();
        IntStream.range(0,5).forEach(i -> x.add(rand.nextInt(10)));
        Collections.sort(x);

        IntStream.range(0,7).forEach(i -> y.add(rand.nextInt(10)));
        Collections.sort(y);

        xPlusY.addAll(x);
        xPlusY.addAll(y);
        Collections.sort(xPlusY);

        zSet.addAll(x);
        zSet.retainAll(y);

        xMinusY.addAll(x);
        xMinusY.removeAll(y);
        Collections.sort(xMinusY);

        xPlusYLimitedByP = xPlusY.stream().filter(i -> i <= p).collect(Collectors.toList());
        Collections.sort(xPlusYLimitedByP);

        System.out.print("x: ");
        for(Integer i : x) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.print("y: ");
        for(Integer i : y) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.print("xPlusY: ");
        for(Integer i : xPlusY) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.print("zSet: ");
        for(Integer i : zSet) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.print("xMinusY: ");
        for(Integer i : xMinusY) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.print("xPlusYLimitedByP: ");
        for(Integer i : xPlusYLimitedByP) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public void ex2()  {
        ArrayList<Student> studentList = new ArrayList<>();

        studentList.add(new Student("Popescu", "Marian", "225_3"));
        studentList.add(new Student("Popescu", "Maria", "225_3"));
        studentList.add(new Student("Popa", "Marian", "225_3"));
        studentList.add(new Student("Bica", "Irina", "225_3"));
        studentList.add(new Student("Badea", "Ion", "225_1"));
        studentList.add(new Student("Cacoveanu", "Andreea", "225_1"));
        studentList.add(new Student("Onofrei", "Mircea", "225_1"));

        System.out.println("Sortati crescator dupa grupa: \n");
        studentList.sort(new ByGroupComparator());
        for(Student s: studentList) {
            System.out.println(s + "\n");
        }

        ArrayList<Student> studentiIntegralisti = new ArrayList<>();
        for(Student s : studentList) {
            if(s.esteIntegralist()) {
                studentiIntegralisti.add(s);
            }
        }
        System.out.println("Sortare studenti integralisti descrescator dupa media notelor: ");
        studentiIntegralisti.sort(new ByGradesComparator());
        for(Student s: studentiIntegralisti) {
            System.out.println(s + "\n");
        }

        ArrayList<Student> studentiRestantieri = new ArrayList<>();
        for(Student s : studentList) {
            if(!s.esteIntegralist()) {
                studentiRestantieri.add(s);
            }
        }
        System.out.println("Sortare studenti restantieri crescator dupa numarul de restante:");
        studentiRestantieri.sort(new ByFailedSubjectCountComparator());
        for(Student s: studentiRestantieri) {
            System.out.println(s + "\n");
        }
    }

    public void main() {
        ex1();
        ex2();
    }
}