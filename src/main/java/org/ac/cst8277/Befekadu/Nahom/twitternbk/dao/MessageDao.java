package org.ac.cst8277.Befekadu.Nahom.twitternbk.dao;

import org.ac.cst8277.Befekadu.Nahom.twitternbk.model.Message;


import java.util.List;
import java.util.Optional;

public interface MessageDao {
    int insertMessage(Message tweets);
    int deleteMessage(int id);
    int updateMessage(int id, Message tweets);

    List<Message> selectAllMessage();
    //optional due to possibly returning null when no message found.
    Optional<Message> selectMessageByID(int id);
}
