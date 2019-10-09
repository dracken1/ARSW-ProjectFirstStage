package arsw.bloodymoney.entities;

import java.io.Serializable;
import java.util.List;

/**
 * Class Player that defines the
 * Players in a game
 * @author Pedro Mayorga - PeNav
 * @version 1.0
 * @since 2019-09-23
 */
public class Player implements Serializable{

    private int id;
    private String type;
    private float coins;
    private int life;
    private boolean lifeStatus;
    private boolean winnerStatus;
    
    //private Weapon weapon; //or weapons
    //private Power power; //or powers
}
