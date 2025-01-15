package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMapCollect {
    public static void main(String[] args) {

        List<UserDTO> userDTOList = getUserListFromDB().stream().map(user -> new UserDTO(user.getId(), user.getUsername(), user.getEmail())).collect(Collectors.toList());
        System.out.println(userDTOList.toString());

        List<List<UserDTO>> listList = new ArrayList<>();
        listList.add(userDTOList);

        List<UserDTO> userDTOList2 =  listList.stream().flatMap(userDTOS -> userDTOS.stream()).map(user -> new UserDTO(user.getId(), user.getUsername(), user.getEmail())).collect(Collectors.toList());
        System.out.println(userDTOList2.toString());
    }


    public static List<User> getUserListFromDB() {
        List<User> userList = new ArrayList<>();
        userList.add(new User(1, "abc kumar", "password01", "abc@gmail.com"));
        userList.add(new User(2, "bcd singh", "password02", "bcd@gmail.com"));
        userList.add(new User(3, "cde sharma", "password03", "cde@gmail.com"));
        userList.add(new User(4, "def mathur", "password04", "def@gmail.com"));
        userList.add(new User(5, "efg saini", "password05", "efg@gmail.com"));
        return userList;
    }
}


// DOMAIN ENTITY CLASS
class User {
    private int id;
    private String username;
    private String password;
    private String email;

    public User(int id, String username, String password, String email) {
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
}

// DTO CLASS
class UserDTO {
    private int id;
    private String username;
    private String email;

    public UserDTO(int id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserDTO{" + "id=" + id + ", username='" + username + '\'' + ", email='" + email + '\'' + '}';
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}