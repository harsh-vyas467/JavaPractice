import com.Implementing.java.eight.MyInterface;
import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        MyInterface interfac = ()-> "Hello";
        System.out.println(interfac.sayHello());
        System.out.println("----------------------------------------------------");

//        Runnable r = ()-> {
//            for (int i = 0; i < 10; i++) {
//                System.out.println("Hello " + i);
//            }
//        };
//
//        Thread t = new Thread(r);
//        t.start();

        System.out.println("----------------------------------------------------");

        List<Integer> list = new ArrayList<>() ;
        list.add(2);
        list.add(45);
        list.add(256);
        list.add(9);
        list.add(4);
        list.add(2);
        System.out.println("Before sorting"+list);
        Collections.sort(list,(a,b)-> b-a);

        System.out.println("After Sorting" +list);

        System.out.println("=====================================================");

        Set<Integer> s = new TreeSet<>((a,b)->b-a);
        s.addAll(list);
        System.out.println(s);

        List<Student> students=  new ArrayList<>();
        students.add(new Student(1, "Ram"));
        students.add(new Student(9, "Shyam"));
        students.add(new Student(3, "Shiv"));
        students.add(new Student(7, "Kaal Bhairav"));
        students.add(new Student(5, "Maha Kali"));

        Collections.sort(students, (a,b)-> b.id - a.id);
        System.out.println(students);

        Employee employee = new Employee() {
            @Override
            public String salary() {
                return "1200000000";
            }

            @Override
            public String employeeName() {
                return "Raghuveer";
            }
        };

        System.out.println(employee.employeeName());
        System.out.println(employee.salary());















    }
}