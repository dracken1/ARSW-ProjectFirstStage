package arsw.tetriscombat.controllers;


import org.json.JSONObject;
import arsw.tetriscombat.services.impl.SalasServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class SocketController {
    @Autowired
    SimpMessagingTemplate msgt;

    @Autowired
    private SalasServicesImpl SalasServicesImpl;


    @MessageMapping("/salas") // quizas toque cambiar a string el salaId
    public void salas(String username) throws Exception {
        msgt.convertAndSend("/topic/salas",SalasServicesImpl.listaSalas().toString());
    }

    @MessageMapping("/nuevaSala")
    public void nuevaSala() throws Exception {
        SalasServicesImpl.createElement(null);
        msgt.convertAndSend("/topic/nuevaSala",SalasServicesImpl.listaSalas().toString());
    }

    @MessageMapping("/unirseASala.{salaId}") // quizas toque cambiar a string el salaId
    public void unirseASala(@DestinationVariable int salaId,String username) throws Exception {
        JSONObject usuario = new JSONObject(username);
        SalasServicesImpl.unirUsuarioASala(usuario.getString("username"),salaId);
        msgt.convertAndSend("/topic/unirseASala"+salaId,SalasServicesImpl.listaSalas().toString());
    }

    @MessageMapping("/usuariosEnSala.{salaId}") // quizas toque cambiar a string el salaId
    public void usuariosEnSala(@DestinationVariable int salaId,String username) throws Exception {
        msgt.convertAndSend("/topic/usuariosEnSala"+salaId,SalasServicesImpl.listaSalas().toString());
    }

    @MessageMapping("/abandonarSala.{salaId}") // quizas toque cambiar a string el salaId
    public void abandonarSala(@DestinationVariable int salaId,String username) throws Exception {
        JSONObject usuario = new JSONObject(username);
        SalasServicesImpl.usuarioAbandonarSala(usuario.getString("username"),salaId);
        msgt.convertAndSend("/topic/abandonarSala"+ salaId,SalasServicesImpl.listaSalas().toString());
    }

    //Recibe score de los jugadores, luego las reenvia.
    @MessageMapping("/scorePlayer.{salaId}")
    public void scorePlayer(@DestinationVariable String salaId, JSONObject score) throws Exception {
        msgt.convertAndSend("/topic/scorePlayer"+salaId,score);
    }

    //Recibe rows de los jugadores, luego las reenvia.
    @MessageMapping("/rowsPlayer.{salaId}")
    public void rowsPlayer(@DestinationVariable String salaId, JSONObject rows) throws Exception {
        msgt.convertAndSend("/topic/rowsPlayer"+salaId,rows);
    }

    //Recibe las fichas de los jugadores, luego las reenvia.
    @MessageMapping("/drawPlayer.{salaId}")
    public void drawPlayer(@DestinationVariable String salaId, JSONObject movePlayer) throws Exception {
        msgt.convertAndSend("/topic/drawPlayer"+salaId,movePlayer);
    }

    //Recibe las fichas puestas de los jugadores, luego las reenvia.
    @MessageMapping("/dropPlayer.{salaId}")
    public void dropPlayer(@DestinationVariable String salaId, JSONObject dPlayer) throws Exception {
        msgt.convertAndSend("/topic/dropPlayer"+salaId,dPlayer);
    }

    //Recibe las fichas puestas de los jugadores, luego las reenvia.
    @MessageMapping("/drawNext.{salaId}")
    public void drawNext(@DestinationVariable String salaId, JSONObject dNextPlayer) throws Exception {
        msgt.convertAndSend("/topic/drawNext"+salaId,dNextPlayer);
    }

    //Recibe el poder del oponente, luego las reenvia.
    @MessageMapping("/drawPower.{salaId}")
    public void drawPower(@DestinationVariable String salaId, JSONObject dPowerPlayer) throws Exception {
        msgt.convertAndSend("/topic/drawPower"+salaId,dPowerPlayer);
    }

    //Recibe el jugador que acaba de acabar su juego, luego lo reenvia.
    @MessageMapping("/gameOver.{salaId}")
    public void gameOver(@DestinationVariable String salaId, JSONObject player) throws Exception {
        msgt.convertAndSend("/topic/gameOver"+salaId,player);
    }
}
