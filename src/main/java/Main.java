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

        studentList.add(new Student("Popescu","Marius", "TI"));
        studentList.add(new Student("Stanciu","Anca", "ISM"));
        studentList.add(new Student("Fieraru","David", "C"));
        studentList.add(new Student("Popa","Antonia", "TI"));
        studentList.add(new Student("Milea","Claudiu", "ISM"));

        System.out.println("Sortati dupa grupa: \n");
        studentList.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int comp1 = o1.getGrupa().compareTo(o2.getGrupa());
                if(comp1 == 0) {
                    int comp2 = o1.getNume().compareTo(o2.getNume());
                    if(comp2 == 0) {
                        int comp3 = o1.getPrenume().compareTo(o2.getPrenume());
                        return comp3;
                    }
                    return comp2;
                }
                return comp1;
            }
        });
        for(Student s: studentList) {
            System.out.println(s + "\n\n");
        }

        System.out.println("Sortati dupa media notelor: ");
        studentList.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                ArrayList<Integer> note1 = o1.getNote();
                double medie1 = 0;
                for (Integer i : note1) {
                    medie1 = medie1 + i;
                }
                medie1 = medie1 / note1.size();

                ArrayList<Integer> note2 = o1.getNote();
                double medie2 = 0;
                for (Integer i : note2) {
                    medie2 = medie2 + i;
                }
                medie2 = medie2 / note2.size();

                if(medie1 > medie2) {
                    return 1;
                }

                if(medie1 < medie2) {
                    return -1;
                }

                return 0;
            }
        });
    }

    public void main() {
        ex1();
        ex2();
    }
}