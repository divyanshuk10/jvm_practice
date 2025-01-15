package collection_fw;

import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class NavigableMapPractice {

    public static void main(String[] args) {
        NavigableMap<Double, String> navSet = new TreeMap<>();
        navSet.put(3.0, "Three");
        navSet.put(2.9, "Two");
        navSet.put(5.8, "Five");
        navSet.put(1.2, "One");
        navSet.put(6.3, "Six");
        navSet.put(9.9, "Nine");
        navSet.put(4.5, "Four");

        System.out.println(navSet);
        System.out.println("Ceiling : "+navSet.ceilingEntry(6.0));
        System.out.println("Floor : "+navSet.floorEntry(8.0));
        System.out.println("Higher : "+navSet.higherEntry(6.4));
        System.out.println("Lower : "+navSet.lowerEntry(4.9));
        System.out.println("Poll First : "+navSet.pollFirstEntry());
        System.out.println("Poll Last : "+navSet.pollLastEntry());
        System.out.println("First : "+navSet.firstEntry());
        System.out.println("Last : "+navSet.lastEntry());
    }
}
