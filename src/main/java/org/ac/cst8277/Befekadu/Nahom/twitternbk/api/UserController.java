package org.ac.cst8277.Befekadu.Nahom.twitternbk.api;


import org.ac.cst8277.Befekadu.Nahom.twitternbk.model.Person;
import org.ac.cst8277.Befekadu.Nahom.twitternbk.service.UserManagementService;
import org.ac.cst8277.Befekadu.Nahom.twitternbk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/User")
@RestController
public class UserController {
    private final UserService userService;
    UserManagementService auther = new UserManagementService();

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Routes


    @GetMapping
    public List<Person> getAllUsers(){ return userService.getAllUsers(); }

    @GetMapping(path = "{id}")
    public Person getUserById(@PathVariable("id")int id,@RequestParam ("token") UUID token){
        //System.out.println(auther.getTokens());
        System.out.println(auther.getTokens());
        if (auther.TokenExists(token)){
            System.out.println("I'm here");
            return userService.getUserByID(id);
        }else{
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED, "Action Not Allowed"
            );
        }


    }



    @PostMapping
    public void addUser (@RequestBody Person user){
       userService.addUser(user);
    }

    @DeleteMapping(path = "{id}")
    public void deleteUser (@PathVariable("id") int id,@RequestParam ("token") UUID token){

        if (auther.TokenExists(token)){
            userService.deleteUser(id);
        }else{
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED, "Action Not Allowed"
            );
        }
    }

    @PutMapping(path = "{id}")
    public void updateUser(@PathVariable("id") int id,@RequestBody Person user,@RequestParam ("token") UUID token){

        if (auther.TokenExists(token)){
            userService.updateUser(id,user);
        }else{
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED, "Action Not Allowed"
            );
        }
    }





}
