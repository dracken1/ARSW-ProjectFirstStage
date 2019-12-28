package arsw.tetriscombat.persistence.dao.impl;

//import arsw.bloodymoney.entities.Room;
import arsw.tetriscombat.entities.User;
import arsw.tetriscombat.exceptions.ProjectException;
import arsw.tetriscombat.persistence.dao.GameDAO;

import java.util.List;

/**
 * Interface RoomDAOImpl that implements all the
 * functionalities related with a Room
 * @author Pedro Mayorga - PeNav
 * @version 1.0
 * @since 2018-11-23
 */
public class RoomDAOImpl implements GameDAO {
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
}
