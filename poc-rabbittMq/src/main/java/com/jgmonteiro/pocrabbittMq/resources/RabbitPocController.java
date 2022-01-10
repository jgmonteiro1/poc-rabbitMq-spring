package com.jgmonteiro.pocrabbittMq.resources;

import com.jgmonteiro.pocrabbittMq.messaging.QueueSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sendMessage")
public class RabbitPocController {

    @Autowired
    private  QueueSender queueSender;

    @GetMapping
    public String sendMessage(){
        queueSender.send("Mensagem teste endpoint");
        return "Bateu auqi";
    }


}
