
package arsw.bloodymoney.persistence.dao.impl;

import arsw.bloodymoney.entities.Map;
import arsw.bloodymoney.entities.User;
import arsw.bloodymoney.exceptions.ProjectException;
import arsw.bloodymoney.persistence.dao.GameDAO;

import java.util.List;

/**
 * Interface MapDAOImpl that implements all the
 * functionalities related with a Map
 * @author Pedro Mayorga - PeNav
 * @version 1.0
 * @since 2018-11-23
 */
public class MapDAOImpl implements GameDAO {
    @Override
    public void save(User user) {

    }

    @Override
    public User load(int id) throws ProjectException {
        return null;
    }

    @Override
    public User load(String email) throws ProjectException {
        return null;
    }

    @Override
    public List<User> loadAll() {
        return null;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void updateRole(int id, String newRole) {

    }

    @Override
    public void delete(User user) {

    }

    //@Inject
    //mapper

    /**
    @Override
    public void save(Map map) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map load(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map load(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Map> loadAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Map map) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateType(int id, int newType) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Map map) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
*/
}
