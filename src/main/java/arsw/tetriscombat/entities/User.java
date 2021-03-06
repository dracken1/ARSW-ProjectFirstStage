package arsw.tetriscombat.entities;

import java.io.Serializable;
//import java.util.List;

/**
 * Class User that defines the
 * User used to play the Game
 * @author Pedro Mayorga - PeNav
 * @version 1.0
 * @since 2019-09-23
 */
public class User implements Serializable{

    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String lastname;
    private String username;
    private String email;
    private String password;
    private String role;
    private int level;
    private int wins;
    private boolean onlineStatus;
    private boolean ongameStatus;
    private Room room;
    //private List<Award> awards;
    
    //Constructors

    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public User(String name, String lastname, String username, String email, String password) {
        this.name = name;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(int id, String name, String lastname, String username, String email, String password, String role) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User(int id, String name, String lastname, String username, String email, String password, String role, int level) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.level = level;
    }
    
    
    //Getters and Setters

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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public boolean isOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(boolean onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    public boolean isOngameStatus() {
        return ongameStatus;
    }

    public void setOngameStatus(boolean ongameStatus) {
        this.ongameStatus = ongameStatus;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
    
    
    //To String

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", lastname=" + lastname + ", username=" + username + ", email=" + email + ", password=" + password + ", role=" + role + ", level=" + level + ", wins=" + wins + ", onlineStatus=" + onlineStatus + ", ongameStatus=" + ongameStatus  + ", room=" + room + '}';
    }
   
}
