package arsw.bloodymoney.controllers;

import arsw.bloodymoney.services.impl.SalasServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;


@Controller
public class socketController {
    @Autowired
    SimpMessagingTemplate msgt;

    @Autowired
    private SalasServicesImpl SalasServicesImpl;
    //Map<String, ArrayList<Point>> conexiones =new ConcurrentHashMap<String,ArrayList<Point>>();
    //ArrayList<Point> poligono;

    @MessageMapping("/nuevaSala")
    public void nuevaSala() throws Exception {
        SalasServicesImpl.createElement(null);
        msgt.convertAndSend("/topic/salas",SalasServicesImpl.listaSalas().toString());

    }
}

