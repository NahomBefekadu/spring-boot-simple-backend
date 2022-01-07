package org.ac.cst8277.Befekadu.Nahom.twitternbk.dao;

import org.ac.cst8277.Befekadu.Nahom.twitternbk.model.Message;
import org.ac.cst8277.Befekadu.Nahom.twitternbk.model.Subscribers;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SubscriberRowMapper implements RowMapper<Subscribers> {
    @Override
    public Subscribers mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Subscribers(
                rs.getInt("subscriptionID"),
                rs.getString("dateSubscribed"),
                rs.getInt("userID"),
                rs.getInt("followerID")

        );
    }
}
