package arsw.bloodymoney.persistence.dao;

import arsw.bloodymoney.entities.Session;
import arsw.bloodymoney.entities.User;
import arsw.bloodymoney.exceptions.ProjectException;
import org.springframework.stereotype.Service;

//import java.util.concurrent.ConcurrentHashMap;

@Service
public interface SessionPersistence {
    public void addSession(User user, Session session) throws ProjectException;
}
