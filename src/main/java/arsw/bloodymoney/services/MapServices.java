package arsw.bloodymoney.services;

import arsw.bloodymoney.entities.Map;
import arsw.bloodymoney.entities.Player;
import arsw.bloodymoney.entities.Room;
import arsw.bloodymoney.entities.User;
import java.util.List;

/**
 * Interface MapServices that defines all the
 * functionalities of the Maps in the game
 * @author Pedro
 * @version 1.0
 * @since 2019-09-20
 */
public interface MapServices {
    
    //TO-DO
    //Define functionalities of the users
    
    public int getNumberOfPlayers(int id);
    public void changeName(int id, String newName);
    public void changeType(int id, String newType);
    public void changeDifficulty(int id, String newDifficulty);
    public void spawnPlayer(int player_id);
    public void killPlayer(int player_id);
    //public void spawnCoin();
    //public void spawnPower();
    
    
    
    /*BASIC SERVICES*/
    
    //Add
    public void addMap(String name, String type, String difficulty);
    
    //Search
    public Map searchMapByID(int id);
    public List<Map> searchMaps();
    public Room searchRoomByMap(int id);
    public Player searchPlayersByMap(int id);
    
    //Update
    public void updateMap(int id, String name, String type, String difficulty);
    
    //Delete
    public void deleteMap(int id);
    
    //Status
    public boolean checkEndgameStatus(int id);
    public void changeEndgameStatus(int id, boolean newEndgameStatus);
    
}
