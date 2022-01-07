package org.ac.cst8277.Befekadu.Nahom.twitternbk.dao;

import org.ac.cst8277.Befekadu.Nahom.twitternbk.model.Message;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MessageRowMapper implements RowMapper<Message> {
    @Override
    public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Message(
                rs.getInt("MessageID"),
                rs.getString("content"),
                rs.getInt("likesCount"),
                rs.getInt("retweetCount"),
                rs.getString("createDate"),
                rs.getInt("User_UserID")
        );
    }
}
