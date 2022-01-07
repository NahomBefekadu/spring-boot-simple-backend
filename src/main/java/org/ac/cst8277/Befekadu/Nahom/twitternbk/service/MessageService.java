package org.ac.cst8277.Befekadu.Nahom.twitternbk.service;

import org.ac.cst8277.Befekadu.Nahom.twitternbk.dao.MessageDao;
import org.ac.cst8277.Befekadu.Nahom.twitternbk.exception.NotFoundException;
import org.ac.cst8277.Befekadu.Nahom.twitternbk.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService  {
    private final MessageDao messageDao;

    @Autowired
    public MessageService(@Qualifier("mysqls")MessageDao messageDao) {
        this.messageDao = messageDao;
    }

    public List<Message> getAllMessages(){return messageDao.selectAllMessage();}
    public Message getMessageById(int id){
        return messageDao.selectMessageByID(id).orElseThrow(()-> new NotFoundException(String.format("User with id $s not found",id)));
    }

    public void deleteMessage(int id){
        Optional<Message> tweets =messageDao.selectMessageByID(id);
        tweets.ifPresentOrElse(tweet ->{
            int result = messageDao.deleteMessage(id);
            if (result !=1){
                throw new IllegalStateException("Could not delete message");
            }
        },()->{
            throw new NotFoundException(String.format("Could not find message with $s id",id));
        });

    }
    public void createMessage(Message tweet){
        int result = messageDao.insertMessage(tweet);
        if (result != 1){
            throw new IllegalStateException("Something went wrong");
        }
    }
    public void updateMessage(int id, Message tweet){
        int result = messageDao.updateMessage(id,tweet);
        if (result != 1){
            throw new IllegalStateException("Something went wrong");
        }

    }


}
