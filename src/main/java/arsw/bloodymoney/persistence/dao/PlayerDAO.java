package arsw.bloodymoney.persistence.dao;

import arsw.bloodymoney.entities.Map;
import arsw.bloodymoney.entities.Player;
import java.util.List;

/**
 * Interface PlayerDAO that defines all the
 * functionalities related with a Player
 * @author Pedro Mayorga
 * @version 1.0
 * @since 2019-09-20
 */
public interface PlayerDAO {
    
    //Post
    public void save(Player player);
    
    //Get
    public Player load(int id);
    public List<Player> loadAll();
    
    //Put
    public void update(Player player);
    public void updateType(int id, int newType);
    public void updateGender(int id, int newGender);
    
    //Delete
    public void delete(Player player);
}
