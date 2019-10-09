package arsw.bloodymoney.persistence.dao;

import arsw.bloodymoney.entities.Map;
import arsw.bloodymoney.entities.Room;
import java.util.List;

/**
 * Interface MapDAO that defines all the
 * functionalities related with a Map
 * @author Pedro Mayorga
 * @version 1.0
 * @since 2019-09-20
 */
public interface MapDAO {
    
    //Post
    public void save(Map map);
    
    //Get
    public Map load(int id);
    public Map load(String name);
    public List<Map> loadAll();
    
    //Put
    public void update(Map map);
    public void updateType(int id, int newType);
    
    //Delete
    public void delete(Map map);
    
}
