package arsw.tetriscombat.services.impl;

import arsw.tetriscombat.mappers.Bridge;
import arsw.tetriscombat.entities.User;
import arsw.tetriscombat.exceptions.ProjectException;
//import arsw.bloodymoney.persistence.dao.GameDAO;
import arsw.tetriscombat.persistence.dao.impl.UserDAOImpl;
import arsw.tetriscombat.services.GameServices;

public class UserServicesImpl implements GameServices {

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
}
