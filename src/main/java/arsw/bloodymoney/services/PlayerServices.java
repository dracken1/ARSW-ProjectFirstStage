package arsw.bloodymoney.services;

import arsw.bloodymoney.entities.Map;
import arsw.bloodymoney.entities.Player;
import arsw.bloodymoney.entities.Room;
import arsw.bloodymoney.entities.User;
import java.util.List;

/**
 * Interface PlayerServices that defines all the
 * functionalities of the Players in the game
 * @author Pedro
 * @version 1.0
 * @since 2019-09-20
 */
public interface PlayerServices {
    
    //TO-DO
    //Define functionalities of the users
    
    public void changeType(int id, String newType);
    public void changeGender(int id, String newGender);
    public void changeComplexion(int id, String newComplexion);
    public void recoverLife(int id, int amount);
    public void loseLife(int id, int amount);
    public void increaseScore(int id, int amount);
    public void decreaseScore(int id, int amount);
    
    
    
    /*BASIC SERVICES*/
    
    //Add
    public void addPlayer(String type, String gender, String complexion);
    
    //Search
    public Player searchPlayerByID(int id);
    public List<Player> searchPlayers();
    public Map searchMapByPlayer(int id);
    public User searchUserByPlayer(int id);
    
    //Update
    public void updatePlayer(int id, String type, String gender, String complexion);
    
    //Delete
    public void deletePlayer(int id);
    
    //Status
    public boolean checkAliveStatus(int id);
    public void changeAliveStatus(int id, boolean newAliveStatus);
    public boolean checkWinnerStatus(int id);
    public void changeWinnerStatus(int id, boolean newWinnerStatus);
}
