package org.ac.cst8277.Befekadu.Nahom.twitternbk.api;


import org.ac.cst8277.Befekadu.Nahom.twitternbk.model.Person;
import org.ac.cst8277.Befekadu.Nahom.twitternbk.service.UserManagementService;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/auth")
@RestController
public class Login {

    public Login(UserController userController) {
        this.userController = userController;
    }

    private final UserController userController;
    UserManagementService auther = new UserManagementService() ;


    @PostMapping
    public Result Login (@RequestBody Person user){
        if (user.getUserName()==null || user.getPassword()==null){
            throw new IllegalStateException();
        }

        List<Person> users = userController.getAllUsers();
        if (users.stream().anyMatch(u->u.getUserName().equals(user.getUserName())) && users.stream().anyMatch(u->u.getPassword().equals(user.getPassword()))){
            return new Result("Access Granted",auther.createToken());
        }
        return new Result("Access Denied",null);
    }



}
