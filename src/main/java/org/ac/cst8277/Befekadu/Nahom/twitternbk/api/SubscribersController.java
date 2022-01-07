package org.ac.cst8277.Befekadu.Nahom.twitternbk.api;

import org.ac.cst8277.Befekadu.Nahom.twitternbk.model.Message;
import org.ac.cst8277.Befekadu.Nahom.twitternbk.model.Subscribers;
import org.ac.cst8277.Befekadu.Nahom.twitternbk.service.MessageService;
import org.ac.cst8277.Befekadu.Nahom.twitternbk.service.SubscriberService;
import org.ac.cst8277.Befekadu.Nahom.twitternbk.service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/Subscription")
@RestController
public class SubscribersController {
    @Autowired
    public SubscribersController(SubscriberService subscriberService) {
        this.subscriberService = subscriberService;
    }
    UserManagementService auther = new UserManagementService();
    private final SubscriberService subscriberService;


    //Routes
    @GetMapping
    public List<Subscribers> getAllSubscribers(@RequestParam ("token") UUID token){
        if (auther.TokenExists(token)){
            return subscriberService.getAllSubscribers();
        }else{
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED, "Action Not Allowed"
            );
        }
    }


    @GetMapping(path = "{id}")
    public Subscribers getMessage(@PathVariable("id") int id,@RequestParam ("token") UUID token){
        if (auther.TokenExists(token)){
            return  subscriberService.getSubscriptionById(id);
        }else{
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED, "Action Not Allowed"
            );
        }
    }

    @DeleteMapping(path = "{id}")
    public void deleteMessage(@PathVariable("id") int id,@RequestParam ("token") UUID token){
        if (auther.TokenExists(token)){
            subscriberService.deleteSubscription(id);
        }else{
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED, "Action Not Allowed"
            );
        }
    }

    @PostMapping
    public void createMessage(@RequestBody Subscribers followers,@RequestParam ("token") UUID token){
        if (auther.TokenExists(token)){
            subscriberService.createaSubscription(followers);
        }else{
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED, "Action Not Allowed"
            );
        }
    }

    @PutMapping(path = "{id}")
    public void updateMessage(@PathVariable("id") int id,@RequestBody Subscribers followers,@RequestParam ("token") UUID token){
        if (auther.TokenExists(token)){
            subscriberService.updateSubscription(id,followers);
        }else{
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED, "Action Not Allowed"
            );
        }
    }



}
