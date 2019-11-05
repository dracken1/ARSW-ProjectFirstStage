package arsw.tetriscombat.persistence.dao.impl;

import arsw.tetriscombat.mappers.Bridge;
//import arsw.bloodymoney.controllers.UserController;
import arsw.tetriscombat.entities.User;
import arsw.tetriscombat.exceptions.ProjectException;
import arsw.tetriscombat.persistence.dao.GameDAO;
import java.util.List;

/**
 * Interface UserDAOImpl that implements all the
 * functionalities related with a User
 * @author Pedro Mayorga
 * @version 1.0
 * @since 2018-11-23
 */
public class UserDAOImpl implements GameDAO {

    private Bridge bg = new Bridge();

    @Override
    public void save(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User load(int id) throws ProjectException{
        try {
            //TO-DO
            User user = new User();
            return user;
        } catch (Exception ex) {
            throw new ProjectException("\nERROR:\nClass: MyBatisUserDAO\n-Method: load()\nNo existe ningun usuario con el id: \n" + id + "\n", ex);
        }
    }

    public User load(String username, String password) throws ProjectException{
        try {
            return bg.authentication(username,password);
        } catch (Exception ex){
            throw new ProjectException("\nERROR:\nClass: MyBatisUserDAO\n-Method: load()\nNo existe ningun usuario con el usuario: \n" + username + "\n", ex);
        }
    }

    @Override
    public User load(String email) throws ProjectException{
        try {
            //TO-DO
            User user = new User();
            return user;
            //return userController.;
        } catch (Exception ex) {
            throw new ProjectException("\nERROR:\nClass: MyBatisUserDAO\n-Method: load()\nNo existe ningun usuario con el email: \n" + email + "\n", ex);
        }
    }

    @Override
    public List<User> loadAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateRole(int id, String newRole) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
