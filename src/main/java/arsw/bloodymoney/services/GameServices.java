package arsw.bloodymoney.services;

import arsw.bloodymoney.exceptions.ProjectException;

/**
 * Interface UserServices that defines all the
 * functionalities of the Users in the game
 * @author Pedro
 * @version 1.0
 * @since 2019-09-20
 */
public interface GameServices {

    //CRUD
    //
    public void createElement(Object elemento) throws ProjectException;


    //READ
    public Object Read();

    //UPDATE
    public Object Update();

    //DELETE
    public void Delete();

    /**
    public void changeUsername(int id, String newUsername);
    public void changeEmail(int id, String newEmail);
    public void changePassword(int id, String newPassword);
    public void changeRole(int id, String newRole);
    public int getLevel(int id);
    public int getWins(int id);
    
    public void leaveRoom(int id);
    public void changeRoom(int id, int newRoom_id);
    //public void changePlayerType(int id, String newType);
    //public changeMap(String map_id);*/
    
    
    
    /*BASIC SERVICES*/
    /**
    //Add
    public void addUser(String name, String lastname, String username, String email, String password);
    
    //Search
    public User searchUserByID(int id);
    public List<User> searchUsers();
    public Player searchPlayerByUser(int id);
    public Room searchRoomByUser(int id);
    
    //Update
    public void updateUser(int id, String name, String lastname, String username, String email, String password);
    
    //Delete
    public void deleteUser(int id);
    
    //Status
    public boolean checkOnlineStatus(int id);
    public void changeOnlineStatus(int id, boolean newOnlineStatus);
    public boolean checkOngameStatus(int id);
    public void changeOngameStatus(int id, boolean newOngameStatus);
    */

}
