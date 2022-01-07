package org.ac.cst8277.Befekadu.Nahom.twitternbk.api;


import org.ac.cst8277.Befekadu.Nahom.twitternbk.model.Message;
import org.ac.cst8277.Befekadu.Nahom.twitternbk.model.Person;
import org.ac.cst8277.Befekadu.Nahom.twitternbk.service.MessageService;
import org.ac.cst8277.Befekadu.Nahom.twitternbk.service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/Message")
@RestController
public class MessageController {
    private final MessageService messageService;
    UserManagementService auther = new UserManagementService();

    @Autowired
    public MessageController(MessageService messageService) {

        this.messageService = messageService;
    }

    //Routes
    @GetMapping
    public List<Message> getAllMessages(@RequestParam ("token") UUID token){
        if (auther.TokenExists(token)){
            return messageService.getAllMessages();
        }else{
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED, "Action Not Allowed"
            );
        }
    }
    @GetMapping(path = "{id}")
    public Message getMessage(@PathVariable("id") int id,@RequestParam ("token") UUID token){
        if (auther.TokenExists(token)){
            return  messageService.getMessageById(id);
        }else{
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED, "Action Not Allowed"
            );
        }
    }

    @DeleteMapping(path = "{id}")
    public void deleteMessage(@PathVariable("id") int id,@RequestParam ("token") UUID token){
        if (auther.TokenExists(token)){
            messageService.deleteMessage(id);
        }else{
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED, "Action Not Allowed"
            );
        }
        }

    @PostMapping
    public void createMessage(@RequestBody Message tweet,@RequestParam ("token") UUID token){
        if (auther.TokenExists(token)){
            messageService.createMessage(tweet);
        }else{
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED, "Action Not Allowed"
            );
        }
    }
    @PutMapping(path = "{id}")
    public void updateMessage(@PathVariable("id") int id,@RequestBody Message tweet, @RequestParam ("token") UUID token){
        if (auther.TokenExists(token)){
            messageService.updateMessage(id,tweet);
        }else{
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED, "Action Not Allowed"
            );
        }
        }


}
