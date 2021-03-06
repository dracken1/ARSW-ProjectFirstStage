package arsw.tetriscombat.services.impl;

import arsw.tetriscombat.mappers.Bridge;
import arsw.tetriscombat.entities.User;
import arsw.tetriscombat.exceptions.ProjectException;
//import arsw.bloodymoney.persistence.dao.GameDAO;
import arsw.tetriscombat.persistence.dao.impl.UserDAOImpl;
import arsw.tetriscombat.services.GameServices;

/**
 * Class UserServicesImpl that defines all the
 * functionalities of the Users in the game
 * @author Pedro
 * @version 1.0
 * @since 2019-09-20
 */


public class UserServicesImpl implements GameServices {
    
    //private GameDAO userDAO;

    private UserDAOImpl userdao = new UserDAOImpl();

    public UserServicesImpl() {

    }

    public User checkLogin(String username, String password) throws ProjectException{
        try {
            return userdao.load(username,password);
        } catch (Exception ex) {
            throw new ProjectException("\nERROR:\nClass: UserServicesImpl\n-Method: checkLogin()\nNo se pudo loggear correctamente\n", ex);   
        }
    }

    public boolean checkSession() throws ProjectException {
        try {
            boolean sessionAccess = true;
            return sessionAccess;
        } catch (Exception ex) {
            throw new ProjectException("\nERROR:\nClass: UserServicesImpl\n-Method: checkLogin()\nNo se pudo loggear correctamente\n", ex);
        }
    }

    public boolean checkduplicated(String user){
        Bridge bg = new Bridge();
        return bg.checkForDuplicatedUsername(user);
    }

    public  boolean checkUsedEmail(String email){
        Bridge bg = new Bridge();
        return bg.checkForUsedEmail(email);
    }

    @Override
    public void createElement(Object objeto) {
        User user = (User) objeto;
        Bridge bg = new Bridge();
        
        Boolean res = bg.addUser(user.getName(),
                user.getLastname(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword());
    }

    @Override
    public Object Read() {
        return null;
    }

    @Override
    public Object Update() {
        return null;
    }

    @Override
    public void Delete() {

    }

    /**
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
    */
        
}
