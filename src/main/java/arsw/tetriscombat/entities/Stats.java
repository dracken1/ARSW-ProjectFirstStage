package arsw.tetriscombat.entities;

public class Stats {
    private String date;
    private String exp;
    private float score;
    private String type;
    private String username;

    public Stats(){}

    /**
    public Stats(String date, String exp, float score, String type,String username){
        this.date = date;
        this.exp = exp;
        this.username = username;
        this.score = score;
        this.type = type;
    }*/

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {return username;}

    public void setUsername(String username) {this.username = username;}

    public  String toString(){
        return "date: " + date + ", exp: " + exp + ", score: " + score + ", type: " + type;
    }
}
