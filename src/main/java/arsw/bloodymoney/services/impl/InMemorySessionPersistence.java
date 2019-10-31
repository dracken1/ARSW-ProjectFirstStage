package arsw.bloodymoney.services.impl;

import arsw.bloodymoney.entities.Session;
import arsw.bloodymoney.entities.User;
import arsw.bloodymoney.persistence.dao.SessionPersistence;

import java.util.concurrent.ConcurrentHashMap;

public class InMemorySessionPersistence implements SessionPersistence {
    static public ConcurrentHashMap<User, Session> sessions = new ConcurrentHashMap<>();

    public InMemorySessionPersistence(){
    }

    @Override
    public void addSession(User user,Session session){
        if(sessions.containsKey(user)){
            sessions.remove(user);
            sessions.put(user,session);
        }
        sessions.put(user,session);
    }

    public static ConcurrentHashMap<User, Session> getSessions() {
        return sessions;
    }
}
