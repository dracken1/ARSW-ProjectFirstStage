package main;

public class Superviviente {

    int posX = 0;
    int posY = 0;
    int vida = 100;
    int speedX = 10;
    int speedY = 10;

    private boolean agonizando;

    public boolean getAgonizando(){
        return agonizando;
    }

    public void setAgonizando(boolean agonizando){
        this.agonizando = agonizando;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getSpeedX() {
        return speedX;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public int getSpeedY() {
        return speedY;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }

}
