package streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StreamFindElements {

    public static void main(String[] args) {

        long count = getUserListFromDB().stream().count();
        System.out.println(count);

        User1 min = getUserListFromDB().stream().min(Comparator.comparing(String::valueOf)).get();
        System.out.println(min);

        User1 max = getUserListFromDB().stream().max(Comparator.comparing(String::valueOf)).get();
        System.out.println(max);


        Optional<User1> findFirstUser = getUserListFromDB().stream().findFirst();
        if (findFirstUser.isPresent()) {
            System.out.println("First element is Present");
        } else {
            System.out.println("No First element found");
        }

        Optional<User1> findAnyUser = new ArrayList<User1>().stream().findAny();
        if (findAnyUser.isPresent()) {
            System.out.println("An element is Present");
        } else {
            System.out.println("No element found");
        }

        Optional<Integer> reduce1 = getUserListFromDB().stream().map(User1::getId).reduce(Integer::max);

        if (reduce1.isPresent()) {
            System.out.println(reduce1.get());
        } else {
            System.out.println("No element found");
        }


        getUserListFromDB().stream().sorted(User1::compareTo).sorted(Comparator.comparing(User1::getUsername).reversed()).forEach(System.out::println);


    }

    private static List<User1> getUserListFromDB() {
        List<User1> userList = new ArrayList<>();
        userList.add(new User1(1, "abc kumar", "password01", "abc@gmail.com"));
        userList.add(new User1(2, "bcd singh", "password02", "bcd@gmail.com"));
        userList.add(new User1(3, "cde sharma", "password03", "cde@gmail.com"));
        userList.add(new User1(4, "def mathur", "password04", "def@gmail.com"));
        userList.add(new User1(5, "efg saini", "password05", "efg@gmail.com"));
        return userList;
    }
}


// DOMAIN ENTITY CLASS
class User1 implements Comparable<User1> {
    private int id;
    private String username;
    private String password;
    private String email;

    public User1(int id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username='" + username + '\'' + ", password='" + password + '\'' + ", email='" + email + '\'' + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public int compareTo(User1 o) {
        return this.id - o.id;
    }
}
