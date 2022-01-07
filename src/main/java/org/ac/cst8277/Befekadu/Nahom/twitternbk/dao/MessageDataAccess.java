package org.ac.cst8277.Befekadu.Nahom.twitternbk.dao;

import org.ac.cst8277.Befekadu.Nahom.twitternbk.model.Message;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("mysqls")
public class MessageDataAccess implements MessageDao{
    private final JdbcTemplate jdbcTemplate;

    public MessageDataAccess(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertMessage( Message tweets) {
        final String sql = "INSERT INTO Message (content, likesCount, retweetCount, createDate, User_UserID) values (?,?,?,?,?)";
        return jdbcTemplate.update(sql,tweets.getContent(),tweets.getLikesCount(),tweets.getRetweetCount(),tweets.getCreateDate(),tweets.getCreatorID());
    }

    @Override
    public int deleteMessage(int id) {
        final String sql = "DELETE FROM Message WHERE MessageID = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public int updateMessage(int id, Message tweets) {
        final String sql = "UPDATE Message SET content=? , likesCount=?, retweetCount=?, createDate=?, User_UserID=? where MessageID = ?;";
        return jdbcTemplate.update(sql,tweets.getContent(),tweets.getLikesCount(),tweets.getRetweetCount(),tweets.getCreateDate(),tweets.getCreatorID(),id);
    }

    @Override
    public List<Message> selectAllMessage() {
        final String sql = "SELECT * from Message limit 10";
        return jdbcTemplate.query(sql,new MessageRowMapper());
    }

    @Override
    public Optional<Message> selectMessageByID(int id) {
        final String sql = "SELECT * from Message where MessageID =?";
        return jdbcTemplate.query(sql,new MessageRowMapper(),id).stream().findFirst();
    }
}
