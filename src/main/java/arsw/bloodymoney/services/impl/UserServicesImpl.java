package arsw.bloodymoney.services.impl;

import arsw.bloodymoney.entities.Player;
import arsw.bloodymoney.entities.Room;
import arsw.bloodymoney.entities.User;
import arsw.bloodymoney.exceptions.ProjectException;
import arsw.bloodymoney.persistence.dao.UserDAO;
import arsw.bloodymoney.services.UserServices;
import java.util.List;

/**
 * Class UserServicesImpl that defines all the
 * functionalities of the Users in the game
 * @author Pedro
 * @version 1.0
 * @since 2019-09-20
 */
public class UserServicesImpl implements UserServices{
    
    private UserDAO userDAO;

    public UserServicesImpl() {
    }

    @Override
    public boolean checkLogin(String email, String password) throws ProjectException{
        try {
            User user = userDAO.load(email);
            boolean loginAccess;
            if ((user.getEmail().equals(email)) && (user.getPassword().equals(password))) {
                loginAccess = true;
            } else {
                loginAccess = false;
            }            
            return loginAccess;
        } catch (Exception ex) {
            throw new ProjectException("\nERROR:\nClass: UserServicesImpl\n-Method: checkLogin()\nNo se pudo loggear correctamente\n", ex);   
        }
    }
    
    @Override
    public boolean checkSession() throws ProjectException {
        try {
            //try to get the user from the session
            //User user = userDAO.load();
            
            
            boolean sessionAccess = true;
            
            return sessionAccess;
        } catch (Exception ex) {
            throw new ProjectException("\nERROR:\nClass: UserServicesImpl\n-Method: checkLogin()\nNo se pudo loggear correctamente\n", ex);
        }
    }

    @Override
    public void changeUsername(int id, String newUsername) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changeEmail(int id, String newEmail) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changePassword(int id, String newPassword) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changeRole(int id, String newRole) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getLevel(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getWins(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void leaveRoom(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changeRoom(int id, int newRoom_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addUser(String name, String lastname, String username, String email, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User searchUserByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> searchUsers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Player searchPlayerByUser(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Room searchRoomByUser(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateUser(int id, String name, String lastname, String username, String email, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteUser(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean checkOnlineStatus(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changeOnlineStatus(int id, boolean newOnlineStatus) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean checkOngameStatus(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changeOngameStatus(int id, boolean newOngameStatus) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
}
