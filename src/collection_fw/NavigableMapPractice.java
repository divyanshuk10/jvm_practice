package collection_fw;

import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class NavigableMapPractice {

    public static void main(String[] args) {
        NavigableMap<Integer, String> navSet = new TreeMap<>();
        navSet.put(3, "Three");
        navSet.put(2, "Two");
        navSet.put(5, "Five");
        navSet.put(1, "One");
        navSet.put(6, "Six");
        navSet.put(9, "Nine");
        navSet.put(4, "Four");

        System.out.println(navSet);
        System.out.println("Ceiling : "+navSet.ceilingEntry(5));
        System.out.println("Floor : "+navSet.floorEntry(8));
        System.out.println("Higher : "+navSet.higherEntry(6));
        System.out.println("Lower : "+navSet.lowerEntry(4));
        System.out.println("Poll First : "+navSet.pollFirstEntry());
        System.out.println("Poll Last : "+navSet.pollLastEntry());
        System.out.println("First : "+navSet.firstEntry());
        System.out.println("Last : "+navSet.lastEntry());
    }
}
