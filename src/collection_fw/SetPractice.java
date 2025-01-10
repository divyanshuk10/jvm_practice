package collection_fw;

import java.util.*;

public class SetPractice {

    public static void main(String[] args) {
        ///  Duplicate elements are not allowed in any set order is not maintained
        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        var ans = hashSet.add(1);
        hashSet.add(2);
        hashSet.add(2);
        hashSet.add(3);
        hashSet.add(4);
        hashSet.add(5);
        System.out.println(hashSet.size());
        System.out.println(hashSet);

        System.out.println(hashSet.remove(4));
        System.out.println(hashSet);

        System.out.println(hashSet.isEmpty());
        System.out.println(hashSet);

        System.out.println(hashSet.contains(3));
        System.out.println(hashSet);

        hashSet.clear();
        System.out.println(hashSet);
        System.out.println(hashSet.isEmpty());


        ///  Duplicate elements are not allowed in any set order of insertion is maintained
        Set<Integer> linkedHashSet = new LinkedHashSet<>();

        linkedHashSet.add(1);
        linkedHashSet.add(2);
        linkedHashSet.add(5);
        linkedHashSet.add(1);
        linkedHashSet.add(3);
        linkedHashSet.add(4);
        linkedHashSet.add(2);
        System.out.println(linkedHashSet.size());
        System.out.println(linkedHashSet);

        ///  Duplicate elements are not allowed in any set order in sorted order
        Set<Integer> treeHashSet = new TreeSet<>();
        treeHashSet.add(1);
        treeHashSet.add(2);
        treeHashSet.add(5);
        treeHashSet.add(1);
        treeHashSet.add(3);
        treeHashSet.add(4);
        treeHashSet.add(2);
        System.out.println(treeHashSet.size());
        System.out.println(treeHashSet);

        Set<Student> stu = new TreeSet<>(Comparator.comparingInt(Student::getRollNo).reversed());
        stu.add(new Student(1, "A"));
        stu.add(new Student(2, "B"));
        stu.add(new Student(3, "C"));
        // this object will not be added to set since the set uses the hash to compare two objects
        stu.add(new Student(1, "A"));

        System.out.println(stu);
    }
}



class Student implements Comparable<Student>{
    private int rollNo;
    private String name;

    public Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return rollNo == student.rollNo;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(rollNo);
    }


    @Override
    public int compareTo(Student o) {
        return this.getName().compareTo(o.getName());
    }
}