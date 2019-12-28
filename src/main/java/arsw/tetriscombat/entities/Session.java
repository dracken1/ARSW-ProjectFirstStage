package arsw.tetriscombat.entities;

import java.time.LocalDateTime;

public class Session {

    private int id;
    private User user;
    private LocalDateTime expireTime;
    private LocalDateTime initalTime;

    public Session(){}

    public Session(User user){
        this.id = (int) Math.floor(Math.random()*2000 + 1000);
        this.user = user;
        this.initalTime = LocalDateTime.now();
        if(initalTime.getMinute()+10 > 59 && initalTime.getHour()+1 <= 23){
            int newmin = initalTime.getMinute()+10 - 59;
            this.expireTime = LocalDateTime.of(initalTime.getYear(),initalTime.getMonth(),initalTime.getDayOfMonth(),initalTime.getHour()+1,newmin,initalTime.getSecond());
        } else {
            this.expireTime = LocalDateTime.of(initalTime.getYear(),initalTime.getMonth(),initalTime.getDayOfMonth(),initalTime.getHour(),initalTime.getMinute()+10,initalTime.getSecond());
        }
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public User getUser() {return user;}
    public void setUser(User user) {this.user = user;}
    public LocalDateTime getExpireTime() {return expireTime;}
    public void setExpireTime(LocalDateTime expireTime) {this.expireTime = expireTime;}
    public LocalDateTime getInitalTime() {return initalTime;}
    public void setInitalTime(LocalDateTime initalTime) {this.initalTime = initalTime;}
    @Override
    public String toString(){
        return "session{ id= "+id +" user= "+user+" expire="+expireTime+" initated= "+ initalTime +" }";
    }
}
