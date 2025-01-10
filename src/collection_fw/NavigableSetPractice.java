package collection_fw;

import java.util.NavigableSet;
import java.util.TreeSet;

public class NavigableSetPractice {

    public static void main(String[] args) {
        NavigableSet<Integer> navSet = new TreeSet<>();
        navSet.add(3);
        navSet.add(2);
        navSet.add(5);
        navSet.add(1);
        navSet.add(6);
        navSet.add(9);
        navSet.add(4);

        System.out.println(navSet);
        System.out.println("Ceiling : "+navSet.ceiling(5));
        System.out.println("Floor : "+navSet.floor(8));
        System.out.println("Higher : "+navSet.higher(6));
        System.out.println("Lower : "+navSet.lower(4));
        System.out.println("Poll First : "+navSet.pollFirst());
        System.out.println("Poll Last : "+navSet.pollLast());
        System.out.println("First : "+navSet.first());
        System.out.println("Last : "+navSet.last());
    }
}
