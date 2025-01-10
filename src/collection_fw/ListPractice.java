package collection_fw;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListPractice {

    public static void main(String[] args) {

        // Fixed size array. Size cannot be modified.
        String[] studentArray = new String[30];
        studentArray[29] = "Dummy";
        //studentArray[30] = "Dummy 2";

        // Automatic size modification as per requirement default size = 10
        // increases the size by n = n + n/2 + 1
        // functions provided : add(data), add(index, data), addAll(List), get(index), remove(index), remove(data), clear(), set(index, data)
        ArrayList<String> studentArrayList = new ArrayList<>();
        studentArrayList.add("Dummy");
        studentArrayList.add("Dummy 2");
        studentArrayList.add("Dummy 3");
        studentArrayList.add(0,"Dummy 3");

        List<String> newStudentList = new ArrayList<>();
        newStudentList.add("one");
        newStudentList.add("Two");
        newStudentList.add("Three");
        newStudentList.add("Four");

        studentArrayList.addAll(newStudentList);

        System.out.println(studentArrayList.get(0));
        System.out.println(studentArrayList.remove(4));
        studentArrayList.set(0, "99");
        studentArrayList.remove(String.valueOf("Three"));

        System.out.println(studentArrayList);

        //studentArrayList.clear();
        System.out.println(studentArrayList);

        studentArrayList.forEach( it -> {
            System.out.println(it);
        });

        for (String s : studentArrayList) {
            System.out.println(s);
        }

        Iterator<String> itr = studentArrayList.iterator();

        while (itr.hasNext()){
            System.out.println(itr.next());
        }


    }
}


