
package com.bloody.app.bloodymoney.persistence;


@Service
public class InMemorySalaPersistence  implements SalasPersistence{

    public InMemorySalaPersistence(){

    }

    @Override
    public void addSala(Sala s) throws SalasPersistenceException;

}