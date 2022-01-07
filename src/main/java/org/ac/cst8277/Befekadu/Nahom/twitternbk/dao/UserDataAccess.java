package org.ac.cst8277.Befekadu.Nahom.twitternbk.dao;

import org.ac.cst8277.Befekadu.Nahom.twitternbk.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("mysql")
public class UserDataAccess implements UserDao{
    private final JdbcTemplate jdbcTemplate;

    public UserDataAccess(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public int insertUser( Person user) {
        final String sql = "INSERT INTO User (UserName, password, email, subscriberCount, createDate) VALUES (?,?,?,?,?)";

        return jdbcTemplate.update(sql,user.getUserName(),user.getPassword(),user.getEmail(),user.getSubscriberCount(),user.getCreateDate());
    }

    @Override
    public int deleteUser(int id) {
        final String sql = "DELETE FROM User WHERE UserID = ?";
        return jdbcTemplate.update(sql, id);

    }

    @Override
    public int updateUser(int id, Person user) {
        final String sql = "UPDATE User SET UserName = ?, password = ?,email = ?,subscriberCount = ?,createDate = ? Where UserID = ?;";
        return jdbcTemplate.update(sql,user.getUserName(),user.getPassword(),user.getEmail(),user.getSubscriberCount(),user.getCreateDate(),id);
    }

    @Override
    public List<Person> selectAllUsers() {
        final String sql = "SELECT * from User Limit 10;";
        return jdbcTemplate.query(sql, new UserRowMapper());


    }

    @Override
    public Optional<Person> selectUserByID(int id) {
        final String sql ="SELECT * FROM User where UserID = ?";
        return jdbcTemplate.query(sql, new UserRowMapper(),id).stream().findFirst();

    }
}
