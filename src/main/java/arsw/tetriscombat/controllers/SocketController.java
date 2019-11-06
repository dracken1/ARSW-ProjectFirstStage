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

    @MessageMapping("/nuevaSala")
    public void nuevaSala() throws Exception {
        SalasServicesImpl.createElement(null);
        msgt.convertAndSend("/topic/salas",SalasServicesImpl.listaSalas().toString());
    }

    @MessageMapping("/unirseASala.{salaId}") // quizas toque cambiar a string el salaId
    public void unirseASala(@DestinationVariable int salaId,String username) throws Exception {
        JSONObject usuario = new JSONObject(username);
        SalasServicesImpl.unirUsuarioASala(usuario.getString("username"),salaId);
        msgt.convertAndSend("/topic/salas",SalasServicesImpl.listaSalas().toString());
    }

    @MessageMapping("/usuariosEnSala.{salaId}") // quizas toque cambiar a string el salaId
    public void usuariosEnSala(@DestinationVariable int salaId,String username) throws Exception {
        JSONObject usuario = new JSONObject(username);
        msgt.convertAndSend("/topic/salas",SalasServicesImpl.listaSalas().toString());
    }


}
