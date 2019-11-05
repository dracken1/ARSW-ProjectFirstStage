package arsw.tetriscombat.persistence.dao;

import arsw.tetriscombat.entities.User;
import arsw.tetriscombat.exceptions.ProjectException;
import java.util.List;

/**
 * Interface UserDAO that defines all the
 * functionalities related with a User
 * @author Pedro Mayorga
 * @version 1.0
 * @since 2019-09-20
 */
public interface GameDAO {
    
    //Post
    public void save(User user);
    
    //Get
    public User load(int id) throws ProjectException;
    public User load(String email) throws ProjectException;
    public List<User> loadAll();
    
    //Put
    public void update(User user);
    public void updateRole(int id, String newRole);
    
    //Delete
    public void delete(User user);
    
}
