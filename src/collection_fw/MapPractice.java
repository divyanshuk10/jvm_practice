package collection_fw;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapPractice {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        // value is override to 3
        map.put("three", 3);
        // value is override to 4
        map.put("three", 4);

        // value does not overrides to 6
        map.putIfAbsent("three", 6);

        if(map.containsKey("three")){
            System.out.println("True");
        }
        if (map.containsValue(1)) {
            System.out.println("True");
        }

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        for(String it : map.keySet()){
            System.out.println(it);
        }

        for(Integer it : map.values()){
            System.out.println(it);
        }
        System.out.println(map);

        // entries will be sorted in natural sorting order of the keys
        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("three", 3);
        treeMap.put("two", 2);
        treeMap.put("three", 4);
        treeMap.put("one", 1);
        treeMap.put("three", 3);

        System.out.println(treeMap);
    }
}

