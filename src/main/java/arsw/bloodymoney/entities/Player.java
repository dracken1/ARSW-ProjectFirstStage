package arsw.bloodymoney.entities;

import java.io.Serializable;
import java.util.List;

/**
 * Class Player that defines the
 * Players in a game
 * @author Pedro Mayorga - PeNav
 * @version 1.0
 * @since 2019-09-23
 */
public class Player implements Serializable{

    private int id;
    private String type;
    private int speed;
    private int coins;
    private int keys;
    private int score;
    private int life;    
    private String gender;
    private String complexion;
    //hair color
    //respawn point
    private boolean aliveStatus;
    private boolean winnerStatus;
    
    private Map map;
    private User user;
    //private Weapon weapon; //or weapons
    //private Power power; //or powers
    //private Shirt shirt;
    //private Pant pant;
    
    
    //Constructors

    public Player() {
    }

    public Player(int id) {
        this.id = id;
    }

    public Player(int id, String type, String gender, String complexion) {
        this.id = id;
        this.type = type;
        this.gender = gender;
        this.complexion = complexion;
    }
    
    
    //Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getKeys() {
        return keys;
    }

    public void setKeys(int keys) {
        this.keys = keys;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getComplexion() {
        return complexion;
    }

    public void setComplexion(String complexion) {
        this.complexion = complexion;
    }
    
    public boolean isAliveStatus() {
        return aliveStatus;
    }

    public void setAliveStatus(boolean aliveStatus) {
        this.aliveStatus = aliveStatus;
    }

    public boolean isWinnerStatus() {
        return winnerStatus;
    }

    public void setWinnerStatus(boolean winnerStatus) {
        this.winnerStatus = winnerStatus;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
    //To String

    @Override
    public String toString() {
        return "Player{" + "id=" + id + ", type=" + type + ", speed=" + speed + ", coins=" + coins + ", keys=" + keys + ", score=" + score + ", life=" + life + ", gender=" + gender + ", complexion=" + complexion + ", aliveStatus=" + aliveStatus + ", winnerStatus=" + winnerStatus + ", map=" + map + ", user=" + user + '}';
    }  
    
}
