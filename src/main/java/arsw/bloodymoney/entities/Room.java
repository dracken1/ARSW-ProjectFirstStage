package arsw.bloodymoney.entities;

import java.io.Serializable;
import java.util.List;

/**
 * Class Room that defines the
 * Rooms used by an User
 * @author Pedro Mayorga - PeNav
 * @version 1.0
 * @since 2019-09-23
 */
public class Room implements Serializable{
    
    private int id;
    private String name;
    private int capacity;
    private int stages;
    private int time;
    private String remainingTime;    
    
    private List<Map> maps;
    private List<User> users;
    

    //Constructors
    
    public Room() {
    }
    
    public Room(int id) {
        this.id = id;
    }
    
    public Room(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Room(int id, String name, int capacity, int stages) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.stages = stages;
    }

    public Room(int id, String name, int capacity, int stages, int time) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.stages = stages;
        this.time = time;
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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getStages() {
        return stages;
    }

    public void setStages(int stages) {
        this.stages = stages;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(String remainingTime) {
        //long start = System.currentTimeMillis();
        //long elapsedTimeMillis = System.currentTimeMillis()-start
        //Time in minutes and seconds
        //float elapsedTimeMin = elapsedTimeMillis/(60*1000F);
        //float elapsedTimeSec = elapsedTimeMillis/1000F;
        this.remainingTime = remainingTime;
    }

    public List<Map> getMaps() {
        return maps;
    }

    public void setMaps(List<Map> maps) {
        this.maps = maps;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    
    //To String
    
    @Override
    public String toString() {
        return "Room{" + "id=" + id + ", name=" + name + ", capacity=" + capacity + ", stages=" + stages + ", time=" + time + ", remainingTime=" + remainingTime + ", maps=" + maps + ", users=" + users + '}';
    }
 
}