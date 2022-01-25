package com.jgmonteiro.pocrabbittMq.resources;

import com.jgmonteiro.pocrabbittMq.messaging.QueueSender;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sendMessage")
public class RabbitPocController {

    @Autowired
    private  QueueSender queueSender;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/{exchange}/{routingKey}")
    public ResponseEntity<Void> sendMessage(@PathVariable(value = "exchange") final String exchange, @PathVariable(value = "routingKey") final String routingKey, @RequestBody final String message){
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping
    public ResponseEntity<String>  teste(){
        return ResponseEntity.status(HttpStatus.OK).body("Batu");
    }

}
