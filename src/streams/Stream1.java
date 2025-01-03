package streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Stream1 {
    public static void main(String[] args) {

        getEmployees().stream()
                .filter(employee -> employee.getAge() >= 23 && employee.getAge() <= 55)
                .peek(it -> it.setName(it.getName().toUpperCase())).forEach(System.out::println);

        // Sorting by name
        List<Employee> sortedList1 = getEmployees().stream().sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
        // Sorting by age descending
        List<Employee> sortedList2 = getEmployees().stream().sorted(Comparator.comparingInt(Employee::getAge).reversed()).collect(Collectors.toList());

        System.out.println("\n");
        System.out.println(sortedList1);
        System.out.println(sortedList2);

    }

    static List<Employee> getEmployees() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1, "john", 22));
        list.add(new Employee(2, "marry", 34));
        list.add(new Employee(3, "Harry", 44));
        list.add(new Employee(4, "goKu", 56));
        list.add(new Employee(5, "BrandoN", 33));

        return list;
    }
}


class Employee {
    private int id;
    private String name;
    private int age;

    public Employee(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name=" + name +
                ", age=" + age +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}