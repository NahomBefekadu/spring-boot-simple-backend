package org.ac.cst8277.Befekadu.Nahom.twitternbk.dao;

import org.ac.cst8277.Befekadu.Nahom.twitternbk.model.Subscribers;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository("mysqlss")
public class SubscriberDataAccess implements SubscribersDao{

    public SubscriberDataAccess(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final JdbcTemplate jdbcTemplate;

    @Override
    public int insertSubscription(Subscribers followers) {
        final String sql ="INSERT INTO Subscription (dateSubscribed, UserID, followerID) VALUES (?,?,?);";
        return jdbcTemplate.update(sql,followers.getDateSubscribed(),followers.getUserID(),followers.getFollowerID());
    }

    @Override
    public int deleteSubscription(int id) {
        final String sql = "DELETE FROM Subscription WHERE subscriptionID = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public int updateSubscription(int id, Subscribers followers) {
        final String sql ="UPDATE Subscription SET dateSubscribed =?, UserID=?, followerID=? WHERE subscriptionID=?;";
        return jdbcTemplate.update(sql,followers.getDateSubscribed(),followers.getUserID(),followers.getFollowerID(),id);
    }

    @Override
    public List<Subscribers> selectAllSubscription() {
        final String sql = "SELECT * from Subscription limit 10;";
        return jdbcTemplate.query(sql,new SubscriberRowMapper());
    }


    @Override
    public Optional<Subscribers> selectSubscribersByID(int id) {
        final String sql = "SELECT * from Subscription where subscriptionID =?";
        return jdbcTemplate.query(sql,new SubscriberRowMapper(),id).stream().findFirst();
    }
}
