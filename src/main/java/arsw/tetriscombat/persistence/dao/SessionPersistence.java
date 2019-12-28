package arsw.tetriscombat.persistence.dao;

import arsw.tetriscombat.entities.Session;
import arsw.tetriscombat.entities.User;
import arsw.tetriscombat.exceptions.ProjectException;
import org.springframework.stereotype.Service;

@Service
public interface SessionPersistence {
    public void addSession(User user, Session session) throws ProjectException;
}
