package org.ac.cst8277.Befekadu.Nahom.twitternbk.dao;

import org.ac.cst8277.Befekadu.Nahom.twitternbk.model.Person;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    int insertUser(Person user);
    int deleteUser(int id);
    int updateUser(int id, Person user);

    List<Person> selectAllUsers();
    //optional due to possibly returning null when no user found.
    Optional <Person> selectUserByID(int id);

}
