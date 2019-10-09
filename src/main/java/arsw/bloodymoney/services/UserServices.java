package arsw.bloodymoney.services;

import arsw.bloodymoney.entities.User;
import java.util.List;

/**
 * Interface UserServices that defines all the
 * functionalities of the Users in the game
 * @author Pedro
 * @version 1.0
 * @since 2019-09-20
 */
public interface UserServices {
    
    //TO-DO
    //Define functionalities of the users
    
    public boolean checkLogin(String username, String password);
    public void changeRole(String id, String newRole);
    //public changeRoom(String room_id);    
    //public changeMap(String map_id);
    
    
    
    /*BASIC SERVICES*/
    
    //Add
    public void addUser();
    
    //Search
    public User searchUserByID(String id);
    public List<User> searchUsersByRoom(String room_id);
    public List<User> searchUsersByMap(String map_id);
    public List<User> searchUsers();
    
    //Update
    public void updateUser(String id);
    
    //Delete
    public void deleteUser(String id);
    
    //Status
    public boolean checkUserStatus(String id);
    public void changeUserStatus(String id, String newStatus);
    
}
