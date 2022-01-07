package org.ac.cst8277.Befekadu.Nahom.twitternbk.service;

import org.ac.cst8277.Befekadu.Nahom.twitternbk.dao.UserDao;
import org.ac.cst8277.Befekadu.Nahom.twitternbk.exception.NotFoundException;
import org.ac.cst8277.Befekadu.Nahom.twitternbk.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService  {
    private final UserDao userDao;

    @Autowired
    public UserService(@Qualifier("mysql") UserDao userDao) {
        this.userDao = userDao;
    }

    public List<Person> getAllUsers(){return userDao.selectAllUsers();}
    public Person getUserByID(int id){
        return userDao.selectUserByID(id)
                .orElseThrow(()-> new NotFoundException(String.format("User with id $s not found",id)));
    }


    public void deleteUser(int id){
        Optional<Person> user = userDao.selectUserByID(id);
        user.ifPresentOrElse(usr ->{
            int result = userDao.deleteUser(id);
            if (result !=1){
                throw new IllegalStateException("Could not delete user");
            }
        },()->{
            throw new NotFoundException(String.format("Could not find user with $s id",id));
        });
    }

    public void addUser(Person user){
        int result = userDao.insertUser(user);
        if (result != 1){
            throw new IllegalStateException("Something went wrong");
        }
    }

    public void updateUser(int id,Person user){
        int result = userDao.updateUser(id,user);
        if (result != 1){
            throw new IllegalStateException("Something went wrong");
        }
    }


}
