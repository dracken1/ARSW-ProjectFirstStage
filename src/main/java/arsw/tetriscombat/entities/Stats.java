package arsw.tetriscombat.entities;

public class Stats {
    private String date;
    private String exp;
    private float score;
    private String type;

    public Stats(){}

    public Stats(String date, String exp, float score, String type){
        this.date = date;
        this.exp = exp;
        this.score = score;
        this.type = type;
    }

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
}
