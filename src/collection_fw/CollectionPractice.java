package collection_fw;

import java.util.*;

public class CollectionPractice {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(4);
        arrayList.add(88);
        arrayList.add(2);
        arrayList.add(34);
        arrayList.add(2);
        arrayList.add(9);
        arrayList.add(6);
        arrayList.add(6);
        arrayList.add(6);

        Collections.sort(arrayList);
        int maxElement = Collections.max(arrayList);
        int minElement = Collections.min(arrayList);
        int frequencyOf6 = Collections.frequency(arrayList, 6);

        System.out.println(maxElement);
        System.out.println(minElement);
        System.out.println(frequencyOf6);

        ArrayList<MyElement> elementsList = new ArrayList<>();
        elementsList.add(new MyElement(4, "Four"));
        elementsList.add(new MyElement(2, "Two"));
        elementsList.add(new MyElement(5, "Five"));
        elementsList.add(new MyElement(3, "Three"));
        elementsList.add(new MyElement(1, "One"));

        Collections.sort(elementsList, Comparator.comparingInt(MyElement::getId));
        System.out.println(elementsList);

        Collections.sort(elementsList);
        System.out.println(elementsList);
    }
}

class MyElement implements Comparable {
    int id;
    String name;

    public MyElement(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "MyElement{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MyElement myElement = (MyElement) o;
        return id == myElement.id && Objects.equals(name, myElement.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public int compareTo(Object o) {
        MyElement element = (MyElement) o;
        return this.getName().compareTo(element.getName());
    }
}
