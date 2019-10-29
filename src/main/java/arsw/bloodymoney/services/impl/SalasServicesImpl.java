package arsw.bloodymoney.services.impl;

import arsw.bloodymoney.entities.Room;
import arsw.bloodymoney.exceptions.ProjectException;
import arsw.bloodymoney.persistence.dao.impl.InMemorySalaPersistence;
import arsw.bloodymoney.services.GameServices;
import org.springframework.stereotype.Service;
import java.util.concurrent.ConcurrentHashMap;


@Service
public class SalasServicesImpl implements GameServices {

    InMemorySalaPersistence sp = new InMemorySalaPersistence();
    @Override
    public void createElement(Object elemento) throws ProjectException {
        sp.addSala();
    }
    @Override
    public Object Read() {
        sp.getSalas();
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
